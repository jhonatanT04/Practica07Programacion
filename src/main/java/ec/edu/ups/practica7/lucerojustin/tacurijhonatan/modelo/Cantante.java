/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Cantante extends Persona { // Define la clase Cantante, que extiende de la clase Persona

    private String nombreArtistico; // Define el nombre artistico del cantante
    private String generoMusical; // Define el género musical del cantante
    private int numeroDeSencillos; // Define el número de sencillos que ha lanzado el cantante
    private int numeroDeConciertos; // Define el número de conciertos que ha dado el cantante
    private int numeroDeGiras; // Define el número de giras que ha realizado el cantante
    private List<Disco> discografia; // Define la discografía del cantante, que es una lista de objetos de la clase Disco

    public Cantante() { // Constructor por defecto de la clase Cantante
        discografia = new ArrayList(); // Inicializa la lista de discos del cantante
    }

    public Cantante(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    
    
    public Cantante(int codigo, String nombre, String apellido, int edad, String nacionalidad) {
        super(codigo, nombre, apellido, edad, nacionalidad);
    }

    
    
    public Cantante(String nombreArtistico, String generoMusical, int numeroDeSencillos, int numeroDeConciertos, int numeroDeGiras,  int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario) { // Constructor personalizado de la clase Cantante
        super(codigo, nombre, apellido, edad, nacionalidad, salario); // Invoca al constructor de la clase Persona con los parámetros correspondientes
        this.nombreArtistico = nombreArtistico; // Asigna el nombre artistico del cantante
        this.generoMusical = generoMusical; // Asigna el género musical del cantante
        this.numeroDeSencillos = numeroDeSencillos; // Asigna el número de sencillos del cantante
        this.numeroDeConciertos = numeroDeConciertos; // Asigna el número de conciertos del cantante
        this.numeroDeGiras = numeroDeGiras; // Asigna el número de giras del cantante
        discografia = new ArrayList();
    }
 
    @Override
    public double calcularSalario() { // Sobrescribe el método calcularSalario de la clase Persona
        double salarioFinal = getSalario(); // Obtiene el salario del cantante y lo asigna a una variable auxiliar

        if (numeroDeSencillos > 10 && numeroDeGiras > 3) { // Si el cantante ha lanzado más de 10 sencillos y ha realizado más de 3 giras
            int comision = 1000; // Se asigna una comisión de 1000
            salarioFinal += comision; // Se le agrega la comisión al salario final
        }
        if (numeroDeSencillos >= 1 && numeroDeSencillos <= 10) { // Si el cantante ha lanzado entre 1 y 10 sencillos
            double f = salarioFinal * 0.05; // Se calcula el 5% del salario final
            salarioFinal += f; // Se le agrega el 5% al salario final
        }
        if (numeroDeGiras >= 1 && numeroDeGiras <= 3) { // Si el cantante ha realizado entre 1 y 3 giras
            double g = salarioFinal * 0.03; // Se calcula el 3% del salario final
            salarioFinal += g; // Se le agrega el 3%
        }
        if (discografia.size() >= 5) {
            int bono = 2000; // Se asigna un bono de 2000
            salarioFinal += bono; // Se agrega el bono
        }
        return salarioFinal; //Retorna el salarioFinal 
    }

    
    public void agregarDisco(Disco discografi){
        discografia.add(discografi); // Se agrega el objeto creado a la lista "discografia".
    }
    public Disco buscarDisco(int codigo){
        for (Disco disco : discografia) {
            if (disco.getCodigo()== codigo) {
                return disco;
            }
        }
        return null;
    }
    
    public List<Disco> listarDiscos(){
        return discografia;
    }
    public void actualizarDisco(Disco discoActualizado) {
        for (Disco disco : discografia) {
            if (disco.getCodigo() == discoActualizado.getCodigo()) {
                disco.setNombre(discoActualizado.getNombre());
                disco.setAnioDeLanzamiento(discoActualizado.getAnioDeLanzamiento());
                System.out.println("Disco actualizado correctamente.");
                return;
            }
        }
        System.out.println("El disco no se encontró en la lista.");
    }

    public void eliminarDisco(int codigoDisco) {
        Disco discoAEliminar = null;
        for (Disco disco : discografia) {
            if (disco.getCodigo() == codigoDisco) {
                discoAEliminar = disco;
                break;
            }
        }

        if (discoAEliminar != null) {
            discografia.remove(discoAEliminar);
            System.out.println("Disco eliminado correctamente.");
        } else {
            System.out.println("El disco con el código especificado no se encontró en la discografía.");
        }
    }
    
    public String getNombreArtistico() {
        return nombreArtistico; // Se retorna el valor de la variable "nombreArtistico".
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico; // Se asigna el valor del argumento a la variable "nombreArtistico".
    }

    public String getGeneroMusical() {
        return generoMusical; // Se retorna el valor de la variable "generoMusical".
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical; // Se asigna el valor del argumento a la variable "generoMusical".
    }

    public int getNumeroDeSencillos() {
        return numeroDeSencillos; // Se retorna el valor de la variable "numeroDeSencillos".
    }

    public void setNumeroDeSencillos(int numeroDeSencillos) {
        this.numeroDeSencillos = numeroDeSencillos; // Se asigna el valor del argumento a la variable "numeroDeSencillos".
    }

    public int getNumeroDeConciertos() {
        return numeroDeConciertos; // Se retorna el valor de la variable "numeroDeConciertos".
    }

    public void setNumeroDeConciertos(int numeroDeConciertos) {
        this.numeroDeConciertos = numeroDeConciertos; // Se asigna el valor del argumento a la variable "numeroDeConciertos".
    }

    public int getNumeroDeGiras() {
        return numeroDeGiras; // Se retorna el valor de la variable "numeroDeGiras".
    }

    public void setNumeroDeGiras(int numeroDeGiras) {
        this.numeroDeGiras = numeroDeGiras; // Se asigna el valor del argumento a la variable "numeroDeGiras".
    }

    public List<Disco> getDiscos() {
        return discografia; // Se retorna la lista "discografia".
    }

    public void setDiscos(List<Disco> discos) {
        this.discografia = discos; // Se asigna la lista pasada como argumento a la variable "discografia".
    }

    
    @Override
    public String toString() {
        return "Cantante"+ super.toString()  + "\nNombreArtistico:" + nombreArtistico + "\nGeneroMusical=" + generoMusical + "\nNumeroDeSencillos=" + numeroDeSencillos + "\nNumeroDeConciertos=" + numeroDeConciertos + "\nNumeroDeGiras=" + numeroDeGiras + "\nLista de Discos: " + discografia ;
    }  

    
}