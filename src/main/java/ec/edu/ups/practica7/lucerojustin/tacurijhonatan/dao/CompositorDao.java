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
   

    public CompositorDao() {
        this.ruta = "src\\main\\resources\\rutas\\compositor.djj";
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
            for (int i = 0; i < listaCanc.size() ; i++) {
                 archivoEscritura.writeInt(listaCanc.get(i).getCodigo());
                 archivoEscritura.writeUTF(listaCanc.get(i).getTitulo());
                 archivoEscritura.writeUTF(listaCanc.get(i).getLetra());
                 archivoEscritura.writeDouble(listaCanc.get(i).getTiempoEnMinutos());
            }
            List<Cantante> listaCantante = compositor.getCliente();
            for (int i = 0; i < listaCantante.size(); i++) {
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
            System.out.println("Tamnio del archivo : "+archivoEscritura.length()); 
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
            int bytesPorCompositor = 1941;
            long numCompositores = archivoLectura.length() / bytesPorCompositor;

            for (int i = 0; i < numCompositores; i++) {
                archivoLectura.seek(i * bytesPorCompositor);
                int codigoCantante = archivoLectura.readInt();

                if (codigoCantante == codigo) {
                    String nombre = archivoLectura.readUTF();
                    String apellido = archivoLectura.readUTF();
                    int edad = archivoLectura.readInt();
                    String nacionalidad = archivoLectura.readUTF();
                    int numeroComposiciones = archivoLectura.readInt();
                    double salario = archivoLectura.readDouble();
                    Compositor compositor = new Compositor(numeroComposiciones, codigo, nombre, apellido, edad, nacionalidad, salario);
                    for (int j = 0; j < 10; j++) {
                        int codigoComp = archivoLectura.readInt();
                        String titulo = archivoLectura.readUTF();
                        String letra = archivoLectura.readUTF();
                        double tiempo = archivoLectura.readDouble();
                        Cancion cancion = new Cancion(codigoComp, titulo, letra,tiempo );
                        compositor.agregarCancion(cancion); 
                        
                    }
                    
                    for (int j = 0; j < 10; j++) {
                        int codigoCan = archivoLectura.readInt();
                        String nombreCan = archivoLectura.readUTF();
                        String apellidoCan = archivoLectura.readUTF();
                        int edadCan = archivoLectura.readInt();
                        String nacionalidadCan = archivoLectura.readUTF();
                        String nombreARCan = archivoLectura.readUTF();
                        String generoMusical = archivoLectura.readUTF();
                        int numeroSencillos = archivoLectura.readInt();
                        int numeroConciertos = archivoLectura.readInt();
                        int numeroGiras = archivoLectura.readInt();
                        double salarioCan = archivoLectura.readDouble();
                        Cantante cantante = new Cantante(nombreARCan, generoMusical, numeroSencillos, numeroConciertos, numeroGiras, codigoCan, nombreCan, apellidoCan, edadCan, nacionalidadCan, salarioCan);
                        compositor.agregarClientE(cantante); 
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
    public void update(Compositor nuevoCompositor) {
        try {
            RandomAccessFile archivoEscritura = new RandomAccessFile(ruta, "rw");
            int bytesPorCompositor = 1941; // Asegúrate de que este valor coincida con el tamaño de registro que utilizaste al escribir los datos
            long numCompositores = archivoEscritura.length() / bytesPorCompositor;
            boolean encontrado = false;

            for (int i = 0; i < numCompositores; i++) {
            
                archivoEscritura.seek(i * bytesPorCompositor);

                int codigo = archivoEscritura.readInt();

                if (codigo == nuevoCompositor.getCodigo()) {
                    System.out.println("Codigo " + codigo);
                    encontrado = true;
                    archivoEscritura.writeUTF(nuevoCompositor.getNombre());
                    archivoEscritura.writeUTF(nuevoCompositor.getApellido());
                    archivoEscritura.writeInt(nuevoCompositor.getEdad());
                    archivoEscritura.writeUTF(nuevoCompositor.getNacionalidad());
                    archivoEscritura.writeInt(nuevoCompositor.getNumeroDeComposiciones());
                    archivoEscritura.writeDouble(nuevoCompositor.getSalario());
                    List<Cancion> listaCanc = nuevoCompositor.getCancionesTop100Billboard();
                    for (int j = 0; j < listaCanc.size(); j++) {
                        archivoEscritura.writeInt(listaCanc.get(j).getCodigo());
                        archivoEscritura.writeUTF(listaCanc.get(j).getTitulo());
                        archivoEscritura.writeUTF(listaCanc.get(j).getLetra());
                        archivoEscritura.writeDouble(listaCanc.get(j).getTiempoEnMinutos());
                    }
                    List<Cantante> listaCantante = nuevoCompositor.getCliente();
                    for (int j = 0; j < listaCantante.size(); j++) {
                        archivoEscritura.writeInt(listaCantante.get(j).getCodigo());
                        archivoEscritura.writeUTF(listaCantante.get(j).getNombre());
                        archivoEscritura.writeUTF(listaCantante.get(j).getApellido());
                        archivoEscritura.writeInt(listaCantante.get(j).getEdad());
                        archivoEscritura.writeUTF(listaCantante.get(j).getNacionalidad());
                        archivoEscritura.writeUTF(listaCantante.get(j).getNombreArtistico());
                        archivoEscritura.writeUTF(listaCantante.get(j).getGeneroMusical());
                        archivoEscritura.writeInt(listaCantante.get(j).getNumeroDeSencillos());
                        archivoEscritura.writeInt(listaCantante.get(j).getNumeroDeConciertos());
                        archivoEscritura.writeInt(listaCantante.get(j).getNumeroDeGiras());
                        archivoEscritura.writeDouble(listaCantante.get(j).getSalario());
                    }
                    break; 
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ruta no encontrada");
        } catch (IOException e1) {
            System.out.println("Error de Lectura/Escritura");
        } catch (Exception e) {
            System.out.println("Error General");
        }
    }

    @Override
    public void delete(Compositor compostior) {
        
        try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            int bytesPorCompositor = 1941; 
            long numCompositores = archivo.length() / bytesPorCompositor;
            

            for (int i = 0; i < numCompositores; i++) {
                archivo.seek(i * bytesPorCompositor);
                int codigo = archivo.readInt();
                if (codigo == compostior.getCodigo()) {
                    
                    for (int j = i + 1; j < numCompositores; j++) {
                        archivo.seek(j * bytesPorCompositor);
                        byte[] datos = new byte[bytesPorCompositor];
                        archivo.readFully(datos);
                        archivo.seek((j - 1) * bytesPorCompositor);
                        archivo.write(datos);
                    }

                    archivo.setLength((numCompositores - 1) * bytesPorCompositor); 
                    break; 
                }
            }

            archivo.close();

        } catch (FileNotFoundException e) {
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
            //if (compositor instanceof Compositor) { // si la persona es un compositor
                System.out.println("Listas de canciones"+compositor.getCancionesTop100Billboard());
                for (Cancion cancion : compositor.getCancionesTop100Billboard()) { // iteramos sobre las canciones del compositor
                    if (cancion.getTitulo().equals(valor)) { 
                        return compositor; // solo se imprime la primera coincidencia, por lo que terminamos el método con un return
                    }
                }
            //}
        }
        return null;
    }
    
    @Override
    public List<Compositor> findAll() {
        List<Compositor> listaCompositores = new ArrayList<>();

        try {
            RandomAccessFile archivoLectura = new RandomAccessFile(ruta, "r");
            int bytesPorCompositor = 1941; 

            long numCompositores = archivoLectura.length() / bytesPorCompositor;
            System.out.println(archivoLectura.length());
            for (int i = 0; i < numCompositores; i++) {
                archivoLectura.seek(i * bytesPorCompositor);

                int codigo = archivoLectura.readInt();
                String nombre = archivoLectura.readUTF();
                String apellido = archivoLectura.readUTF();
                int edad = archivoLectura.readInt();
                String nacionalidad = archivoLectura.readUTF();
                int numeroComposiciones = archivoLectura.readInt();
                double salario = archivoLectura.readDouble();

                Compositor compositor = new Compositor(numeroComposiciones, codigo, nombre, apellido, edad, nacionalidad, salario);
                System.out.println(archivoLectura.length());
                for (int j = 0; j < 10; j++) {
                    int codigoCancion = archivoLectura.readInt();
                    String titulo = archivoLectura.readUTF();
                    String letra = archivoLectura.readUTF();
                    double tiempo = archivoLectura.readDouble();
                    Cancion cancion = new Cancion(codigoCancion, titulo, letra, tiempo);
                    compositor.agregarCancion(cancion);
                }

                for (int j = 0; j < 10; j++) {
                    int codigoCantante = archivoLectura.readInt();
                    String nombreCantante = archivoLectura.readUTF();
                    String apellidoCantante = archivoLectura.readUTF();
                    int edadCantante = archivoLectura.readInt();
                    String nacionalidadCantante = archivoLectura.readUTF();
                    String nombreArtistico = archivoLectura.readUTF();
                    String generoMusical = archivoLectura.readUTF();
                    int numeroSencillos = archivoLectura.readInt();
                    int numeroConciertos = archivoLectura.readInt();
                    int numeroGiras = archivoLectura.readInt();
                    double salarioCantante = archivoLectura.readDouble();

                    Cantante cantante = new Cantante(nombreArtistico, generoMusical, numeroSencillos, numeroConciertos, numeroGiras, codigoCantante, nombreCantante, apellidoCantante, edadCantante, nacionalidadCantante, salarioCantante);
                    compositor.agregarClientE(cantante);
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
