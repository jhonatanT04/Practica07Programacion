/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica7.lucerojustin.tacurijhonatan.dao;


import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.idao.ICantanteDao;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo.Cantante;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo.Disco;
import java.io.File;
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
public class CantanteDao implements ICantanteDao {
    private String ruta;
    private RandomAccessFile archivoEscritura;
    private List<Cantante> listaCantantes;

    public CantanteDao() {
        listaCantantes = new ArrayList<>();
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
    public Cantante read(int id) {
        for (Cantante cantante : listaCantantes) {
            if (cantante.getCodigo()==(id)) {
                return cantante;
            }
        }
        return null;
    }

    @Override
    public void update(Cantante cantante) {
        for (int i = 0; i < listaCantantes.size(); i++) {
            Cantante c = listaCantantes.get(i);
            if (c.getCodigo() == cantante.getCodigo()) {
                listaCantantes.set(i, cantante);
                break;
            }
        }
    }

    @Override
    public void delete(Cantante cantante) {
        Iterator<Cantante> it = listaCantantes.iterator();
        while (it.hasNext()) {
            Cantante d = it.next();
            if (d.getCodigo()== cantante.getCodigo()) {
                it.remove();
                break;
            }
        }
    }
    
    @Override
    public Cantante buscarPorNombreDeDisco(String valor) {
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
        return listaCantantes;
    }
    
}
