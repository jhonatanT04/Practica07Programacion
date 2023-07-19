/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica7.lucerojustin.tacurijhonatan.dao;


import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.idao.ICantanteDao;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo.Cantante;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo.Disco;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CantanteDao implements ICantanteDao {
    private String ruta;
    private RandomAccessFile archivoEscritura;
    //private List<Cantante> listaCantantes;
    private RandomAccessFile archivoLectura;
    private RandomAccessFile archivito;

    public CantanteDao() {
        //listaCantantes = new ArrayList<>();
        this.ruta = "C:\\Users\\venot\\OneDrive\\Escritorio\\Carpeta.Practica7\\Cantante.djj";
        //this.ruta = "PON TU RUTA AQUI GEI SI QUIERES PROBAR Y COMENTA MI RUTA"
        
    }
    
    
    @Override
    public void create(Cantante cantante) {
        
         try {
            archivoEscritura = new RandomAccessFile(ruta, "rw");
            archivoEscritura.seek(archivoEscritura.length());
            archivoEscritura.writeInt(cantante.getCodigo());
            archivoEscritura.writeUTF(cantante.getNombre());
            archivoEscritura.writeUTF(cantante.getApellido());
            archivoEscritura.writeInt(cantante.getEdad());
            archivoEscritura.writeUTF(cantante.getNacionalidad());
            archivoEscritura.writeUTF(cantante.getNombreArtistico());
            archivoEscritura.writeUTF(cantante.getGeneroMusical());
            archivoEscritura.writeInt(cantante.getNumeroDeSencillos());
            archivoEscritura.writeInt(cantante.getNumeroDeConciertos());
            archivoEscritura.writeInt(cantante.getNumeroDeGiras());
            archivoEscritura.writeDouble(cantante.getSalario());
            List<Disco> listaDisc = cantante.getDiscos();
            for (int i = 0; i < 10; i++) {
                 archivoEscritura.writeInt(listaDisc.get(i).getCodigo());
                 archivoEscritura.writeUTF(listaDisc.get(i).getNombre());
                 archivoEscritura.writeInt(listaDisc.get(i).getAnioDeLanzamiento());
            }
            
            
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
    public Cantante read(int codigo) {
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
                    String nombreArtistico = archivoLectura.readUTF();
                    String generoMusical = archivoLectura.readUTF();
                    int numeroDeSencillos = archivoLectura.readInt();
                    int numeroDeConciertos = archivoLectura.readInt();
                    int numeroDeGiras = archivoLectura.readInt();
                    double salario = archivoLectura.readDouble();
                    Cantante cantante = new Cantante(nombreArtistico, generoMusical, numeroDeSencillos, numeroDeConciertos, numeroDeGiras, codigo, nombre, apellido, edad, nacionalidad,salario);
                    for (int j = 0; i < 10; i++) {
                        int codigoCan = archivoLectura.readInt();
                        String nombreCAn = archivoLectura.readUTF();
                        int anio = archivoLectura.readInt();
                        Disco dis = new Disco(codigoCan, nombreCAn, anio);
                        cantante.agregarDisco(dis);
                        
                    }
                    archivoLectura.close();

                    return cantante ;
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
    public void update(Cantante cantante) {
         try {
            RandomAccessFile archivo = new RandomAccessFile(ruta, "rw");
            int bytesPorCantante = 363 ;
            long numCantantes = archivo.length() / bytesPorCantante;
            for (int i = 0; i < numCantantes; i++) {
                archivo.seek(i * bytesPorCantante);
                int codigoCantante = archivo.readInt();
                if (codigoCantante == cantante.getCodigo()) {
                    //archivo.writeInt(cantante.getCodigo());
                    archivo.writeUTF(cantante.getNombre());
                    archivo.writeUTF(cantante.getApellido());
                    archivo.writeInt(cantante.getEdad());
                    archivo.writeUTF(cantante.getNacionalidad());
                    archivo.writeUTF(cantante.getNombreArtistico());
                    archivo.writeUTF(cantante.getGeneroMusical());
                    archivo.writeInt(cantante.getNumeroDeSencillos());
                    archivo.writeInt(cantante.getNumeroDeConciertos());
                    archivo.writeInt(cantante.getNumeroDeGiras());
                    archivo.writeDouble(cantante.getSalario());
                    List<Disco> listaDisc = cantante.getDiscos();
                    System.out.println("Lista del update = "+ listaDisc.toString());
                    for (int j = 0; i < listaDisc.size(); j++) {
                        archivo.writeInt(listaDisc.get(j).getCodigo());
                        archivo.writeUTF(listaDisc.get(j).getNombre());
                        archivo.writeInt(listaDisc.get(j).getAnioDeLanzamiento());
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
    public void delete(Cantante cantante) {
        try{
            archivito = new RandomAccessFile(ruta, "rw");

            int bytesPorCantante = 363;
            long numCantantes = archivito.length() / bytesPorCantante;

            for (int i = 0; i < numCantantes; i++) {
                archivito.seek(i * bytesPorCantante);
                int codigoCantante = archivito.readInt();
                if (codigoCantante == cantante.getCodigo()) {
                    long posicionActual = i * bytesPorCantante;
                    long posicionSiguiente = (i + 1) * bytesPorCantante;
                    long bytesRestantes = archivito.length() - posicionSiguiente;

                    byte[] buffer = new byte[(int) bytesRestantes];
                    archivito.read(buffer);

                    archivito.seek(posicionActual);
                    archivito.write(buffer);
                    archivito.setLength(archivito.length() - bytesPorCantante);
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
    public Cantante buscarPorNombreDeDisco(String valor) {
        List <Cantante> listaCantantes = this.findAll();
        for(Cantante cantante : listaCantantes){
            if(cantante instanceof Cantante){
                for(Disco disco : cantante.getDiscos()){
                    if(disco.getNombre().equals(valor)){
                        return cantante;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<Cantante> findAll() {
        List<Cantante> listaCantantes = new ArrayList<>();
    try {
        RandomAccessFile archivoLectura = new RandomAccessFile(ruta, "r");
        int bytesPorCantante = 363 ;
        long numCantantes = archivoLectura.length() / bytesPorCantante;
        System.out.println(numCantantes);
        for (int i = 0; i < numCantantes; i++) {
            archivoLectura.seek(i * bytesPorCantante);
            int codigo = archivoLectura.readInt();
            
            String nombre = archivoLectura.readUTF();
            String apellido = archivoLectura.readUTF();
            int edad = archivoLectura.readInt();
            String nacionalidad = archivoLectura.readUTF();
            String nombreArtistico = archivoLectura.readUTF();
            String generoMusical = archivoLectura.readUTF();
            int numeroDeSencillos = archivoLectura.readInt();
            int numeroDeConciertos = archivoLectura.readInt();
            int numeroDeGiras = archivoLectura.readInt();
            double salario = archivoLectura.readDouble();
            Cantante cantante = new Cantante(nombreArtistico, generoMusical, numeroDeSencillos, numeroDeConciertos, numeroDeGiras, codigo, nombre, apellido, edad, nacionalidad, salario);
            for (int j = 0; j < 10; j++) {
                int codigoCan = archivoLectura.readInt();
                String nombreCAn = archivoLectura.readUTF();
                int anio = archivoLectura.readInt();
                Disco dis = new Disco(codigoCan, nombreCAn, anio);
                cantante.agregarDisco(dis);
            }
            listaCantantes.add(cantante);
        }

        archivoLectura.close();
    } catch (FileNotFoundException e) {
        System.out.println("Ruta no encontrada");
    } catch (IOException e1) {
        System.out.println("Error de Lectura");
    } catch (Exception e) {
        System.out.println("Error General");
    }

    return listaCantantes;
    }
    
}
