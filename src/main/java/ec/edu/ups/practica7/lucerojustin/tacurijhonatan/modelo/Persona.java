/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo;

import java.util.Objects;

/**
 *
 * @author Usuario
 */
public abstract class Persona {
    private int codigo;            // variable privada para almacenar el código de la persona
    private String nombre;        // variable privada para almacenar el nombre de la persona
    private String apellido;      // variable privada para almacenar el apellido de la persona
    private int edad;             // variable privada para almacenar la edad de la persona
    private String nacionalidad;  // variable privada para almacenar la nacionalidad de la persona
    private double salario;       // variable privada para almacenar el salario de la persona

    // constructor por defecto
    public Persona() {
    }

    // constructor que inicializa las variables de instancia con los valores proporcionados
    public Persona(int codigo, String nombre, String apellido, int edad, String nacionalidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }

    // constructor que inicializa las variables de instancia con los valores proporcionados, incluyendo salario
    public Persona(int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.salario = salario;
    }

    // getter para obtener el código de la persona
    public int getCodigo() {
        return codigo;
    }

    // setter para establecer el código de la persona
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // getter para obtener el nombre de la persona
    public String getNombre() {
        return nombre;
    }

    // setter para establecer el nombre de la persona
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // getter para obtener el apellido de la persona
    public String getApellido() {
        return apellido;
    }

    // setter para establecer el apellido de la persona
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // getter para obtener la edad de la persona
    public int getEdad() {
        return edad;
    }

    // setter para establecer la edad de la persona
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // getter para obtener la nacionalidad de la persona
    public String getNacionalidad() {
        return nacionalidad;
    }

    // setter para establecer la nacionalidad de la persona
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    // getter para obtener el salario de la persona
    public double getSalario() {
        return salario;
    }

    // setter para establecer el salario de la persona
    public void setSalario(double salario) {
        this.salario = salario;
    }

    // método abstracto para calcular el salario de la persona
    public abstract double calcularSalario();
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.codigo;
        return hash;
    }

    // método hashCode para calcular un código hash basado en el nombre de la persona
    @Override    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return this.codigo == other.codigo;
    }

    // Método toString que devuelve una cadena que representa a la persona, incluyendo todos sus campos
    @Override
    public String toString() {
        return "\nCodigo : " + codigo + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nEdad: " + edad + "\nNacionalidad: " + nacionalidad + "\nSalario :" + calcularSalario();
    }
    
}

