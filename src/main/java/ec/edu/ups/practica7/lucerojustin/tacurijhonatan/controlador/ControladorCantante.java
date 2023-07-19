/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica7.lucerojustin.tacurijhonatan.controlador;

import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.idao.ICantanteDao;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo.Cantante;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo.Disco;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ControladorCantante {
    //objetos modelo
    private Cantante cantante;
    private Disco disco;
    //objetos DAOa
    private ICantanteDao cantanteDao;
    

    // constructor

    public ControladorCantante(ICantanteDao cantanteDao) {
        this.cantanteDao = cantanteDao;
        
        
    }
    
    //llama al DAO para guardar un cliente
    public void registrar(Cantante cantante) {
        cantanteDao.create(cantante);
        ///eingresar disco
    }
    
    //llama al DAO para actualizar un cliente
    public void actualizar(Cantante cantante) {
        
        //Disco discoss = (Disco) cantante.getDiscos();//ERROR
        //cantante.agregarDisco(discoss);
        //List<Disco> discoss = cantante.getDiscos();
        //cantante.setDiscos(discoss);
        cantanteDao.update(cantante);
        
    }

    //llama al DAO para eliminar un cliente
    public void eliminar(Cantante cantante) {
        cantanteDao.delete(cantante);
    }
    
    
    //llama al DAO para obtener un cliente por el id y luego los muestra en la vista
    public Cantante buscarCantante(int id) {
        return cantanteDao.read(id);
    }


    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public List<Cantante> verCantantes() {
        return cantanteDao.findAll();
        
    }
    
    public Cantante buscarporDisco(String nombre){
        return cantanteDao.buscarPorNombreDeDisco(nombre);
    }
    
    public void eliminarDisco(Cantante cantante,int codigo){
        List<Disco> listaDiscos=cantante.getDiscos();
        for (Disco listaDisco : listaDiscos) {
            if (listaDisco.getCodigo()==codigo) {
                cantante.eliminarDisco(codigo);
                cantanteDao.update(cantante);
            }
        }
    }
    
    public void actualizarDisco(Cantante cantante,Disco disco){
        cantante.actualizarDisco(disco);
        cantanteDao.update(cantante); 
    }
    
    
    
}
