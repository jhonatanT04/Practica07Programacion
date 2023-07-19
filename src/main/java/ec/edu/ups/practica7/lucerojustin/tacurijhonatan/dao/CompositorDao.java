/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica7.lucerojustin.tacurijhonatan.dao;

import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.idao.ICompositorDao;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo.Cancion;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo.Cantante;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo.Compositor;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo.Disco;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CompositorDao implements ICompositorDao{
    
    private String ruta;
    private RandomAccessFile archivoEscritura;
    
    private RandomAccessFile archivoLectura;
    private RandomAccessFile archivito;
    //private List<Compositor> listaCompositor;

    public CompositorDao() {
        this.ruta = "C:\\Users\\Usuario\\Desktop\\Carpeta7\\compositor.djj";
    }
    
    

    @Override
    public void create(Compositor compositor) {
        try {
            archivoEscritura = new RandomAccessFile(ruta, "rw");
            archivoEscritura.seek(archivoEscritura.length());
            archivoEscritura.writeInt(compositor.getCodigo());
            archivoEscritura.writeUTF(compositor.getNombre());
            archivoEscritura.writeUTF(compositor.getApellido());
            archivoEscritura.writeInt(compositor.getEdad());
            archivoEscritura.writeUTF(compositor.getNacionalidad());
            archivoEscritura.writeInt(compositor.getNumeroDeComposiciones());
            archivoEscritura.writeDouble(compositor.getSalario());
            List<Cancion> listaCanc = compositor.getCancionesTop100Billboard();
            for (int i = 0; i < 10 ; i++) {
                 archivoEscritura.writeInt(listaCanc.get(i).getCodigo());
                 archivoEscritura.writeUTF(listaCanc.get(i).getTitulo());
                 archivoEscritura.writeUTF(listaCanc.get(i).getLetra());
                 archivoEscritura.writeDouble(listaCanc.get(i).getTiempoEnMinutos());
            }
            List<Cantante> listaCantante = compositor.getCliente();
            for (int i = 0; i < 10; i++) {
                archivoEscritura.writeInt(listaCantante.get(i).getCodigo());
                archivoEscritura.writeUTF(listaCantante.get(i).getNombre());
                archivoEscritura.writeUTF(listaCantante.get(i).getApellido());
                archivoEscritura.writeInt(listaCantante.get(i).getEdad());
                archivoEscritura.writeUTF(listaCantante.get(i).getNacionalidad());
                archivoEscritura.writeUTF(listaCantante.get(i).getNombreArtistico());
                archivoEscritura.writeUTF(listaCantante.get(i).getGeneroMusical());
                archivoEscritura.writeInt(listaCantante.get(i).getNumeroDeSencillos());
                archivoEscritura.writeInt(listaCantante.get(i).getNumeroDeConciertos());
                archivoEscritura.writeInt(listaCantante.get(i).getNumeroDeGiras());
                archivoEscritura.writeDouble(listaCantante.get(i).getSalario());
            }
            System.out.println(archivoEscritura.length()); 
            archivoEscritura.close();
         }
        catch(FileNotFoundException e){
            System.out.println("Ruta no ecncontrada");
        } catch(IOException e1){
            System.out.println("Error de Escritura");
        }
        catch (Exception e) {
            System.out.println("Error General");
        }
    }

    @Override
    public Compositor read(int codigo) {
        try {
            archivoLectura = new RandomAccessFile(ruta, "r");
            int bytesPorCantante = 363;
            long numCantantes = archivoLectura.length() / bytesPorCantante;

            for (int i = 0; i < numCantantes; i++) {
                archivoLectura.seek(i * bytesPorCantante);
                int codigoCantante = archivoLectura.readInt();

                if (codigoCantante == codigo) {
                    String nombre = archivoLectura.readUTF();
                    String apellido = archivoLectura.readUTF();
                    int edad = archivoLectura.readInt();
                    String nacionalidad = archivoLectura.readUTF();
                    int numeroComposiciones = archivoLectura.readInt();
                    double salario = archivoLectura.readDouble();
                    Compositor compositor = new Compositor(numeroComposiciones, codigo, nombre, apellido, edad, nacionalidad, salario);
                    for (int j = 0; i < 10; i++) {
                        int codigoComp = archivoLectura.readInt();
                        String titulo = archivoLectura.readUTF();
                        String letra = archivoLectura.readUTF();
                        double tiempo = archivoLectura.readDouble();
                        Cancion cancion = new Cancion(codigoComp, titulo, letra,tiempo );
                        compositor.agregarCancion(cancion); 
                        
                    }
                    archivoLectura.close();

                    return compositor ;
            }
        }
        archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ruta no encontrada");
        } catch (IOException e1) {
            System.out.println("Error de Lectura");
        } catch (Exception e) {
            System.out.println("Error General");
    }

    return null; 
    }

    @Override
    public void update(Compositor compositor) {
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            int bytesPorCompositor = 363 ;
            long numCompositores = archivo.length() / bytesPorCompositor;
            for (int i = 0; i < numCompositores; i++) {
                archivo.seek(i * bytesPorCompositor);
                int codigoCompositor = archivo.readInt();
                if (codigoCompositor == compositor.getCodigo()) {
                    //archivo.writeInt(cantante.getCodigo());
                    archivo.writeUTF(compositor.getNombre());
                    archivo.writeUTF(compositor.getApellido());
                    archivo.writeInt(compositor.getEdad());
                    archivo.writeUTF(compositor.getNacionalidad());
                    archivo.writeInt(compositor.getNumeroDeComposiciones());
                    archivo.writeDouble(compositor.getSalario());
                    List<Cancion> listaCanc = compositor.getCancionesTop100Billboard();
                    System.out.println("Lista del update = "+ listaCanc.toString());
                    for (int j = 0; i < listaCanc.size(); j++) {
                        archivo.writeInt(listaCanc.get(j).getCodigo());
                        archivo.writeUTF(listaCanc.get(j).getTitulo());
                        archivo.writeUTF(listaCanc.get(j).getLetra());
                        archivo.writeDouble(listaCanc.get(j).getTiempoEnMinutos());
                        
                    }
                    
                    archivo.close();
                    return; 
            }
        }

        archivo.close();
        //System.out.println("No ser encontr cantante");
        } catch (FileNotFoundException e) {
            System.out.println("Ruta no encontrada");
            } catch (IOException e1) {
                System.out.println("Error de Lectura");
            } catch (Exception e) {
                System.out.println("Error General");
        }
    }

    @Override
    public void delete(Compositor compostior) {
        try{
            archivito = new RandomAccessFile(ruta, "rw");

            int bytesPorCompositor = 363;
            long numCantantes = archivito.length() / bytesPorCompositor;

            for (int i = 0; i < numCantantes; i++) {
                archivito.seek(i * bytesPorCompositor);
                int codigoCantante = archivito.readInt();
                if (codigoCantante == compostior.getCodigo()) {
                    long posicionActual = i * bytesPorCompositor;
                    long posicionSiguiente = (i + 1) * bytesPorCompositor;
                    long bytesRestantes = archivito.length() - posicionSiguiente;

                    byte[] buffer = new byte[(int) bytesRestantes];
                    archivito.read(buffer);

                    archivito.seek(posicionActual);
                    archivito.write(buffer);
                    archivito.setLength(archivito.length() - bytesPorCompositor);
                    archivito.close();
                    return; 
                }
            }
            archivito.close();
            //System.out.println("No Existe el codgo");
        }catch (FileNotFoundException e) {
            System.out.println("Ruta no encontrada");
        } catch (IOException e1) {
            System.out.println("Error de Lectura/Escritura");
        } catch (Exception e) {
            System.out.println("Error General");
        }
    }
    
    @Override
    public Compositor buscarPorTituloDeCancion(String valor) {
        List<Compositor> listaCompositor = this.findAll();
        for (Compositor compositor : listaCompositor) { // iteramos sobre cada persona en la lista
            if (compositor instanceof Compositor) { // si la persona es un compositor
                for (Cancion cancion : compositor.getCancionesTop100Billboard()) { // iteramos sobre las canciones del compositor
                    if (cancion.getTitulo().equals(valor)) { 
                        return compositor; // solo se imprime la primera coincidencia, por lo que terminamos el método con un return
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    public List<Compositor> findAll() {
        List<Compositor> listaCompositores = new ArrayList<>();
    try {
        RandomAccessFile archivoLectura = new RandomAccessFile(ruta, "r");
        int bytesPorCompositor = 363 ;
        long numCantantes = archivoLectura.length() / bytesPorCompositor;
        System.out.println(numCantantes);
        for (int i = 0; i < numCantantes; i++) {
            archivoLectura.seek(i * bytesPorCompositor);
            int codigo = archivoLectura.readInt();
            
            String nombre = archivoLectura.readUTF();
            String apellido = archivoLectura.readUTF();
            int edad = archivoLectura.readInt();
            String nacionalidad = archivoLectura.readUTF();
            int numeroComposiciones = archivoLectura.readInt();
            double salario = archivoLectura.readDouble();
            Compositor compositor = new Compositor(numeroComposiciones, codigo, nombre, apellido, edad, nacionalidad, salario);
            for (int j = 0; j < 10; j++) {
                int codigoc = archivoLectura.readInt();
                String titulo = archivoLectura.readUTF();
                String letra = archivoLectura.readUTF();
                double timepo = archivoLectura.readDouble();
                Cancion cancion = new Cancion(codigoc, titulo, letra, timepo);
                compositor.agregarCancion(cancion); 
            }
            listaCompositores.add(compositor); 
        }

        archivoLectura.close();
    } catch (FileNotFoundException e) {
        System.out.println("Ruta no encontrada");
    } catch (IOException e1) {
        System.out.println("Error de Lectura");
    } catch (Exception e) {
        System.out.println("Error General");
    }

    return listaCompositores;
    }
    
}
