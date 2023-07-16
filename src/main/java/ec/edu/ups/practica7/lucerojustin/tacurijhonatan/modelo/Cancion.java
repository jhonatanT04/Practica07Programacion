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
public class Cancion {
    private int codigo; // Declaración de la variable 'codigo' de tipo int y se establece como privada
    private String titulo; // Declaración de la variable 'titulo' de tipo String y se establece como privada
    private String letra; // Declaración de la variable 'letra' de tipo String y se establece como privada
    private double tiempoEnMinutos; // Declaración de la variable 'tiempoEnMinutos' de tipo double y se establece como privada

    public Cancion() { // Constructor por defecto
    }

    public Cancion(int codigo, String titulo, String letra, double tiempoEnMinutos) { // Constructor con parámetros
        this.codigo = codigo; // Inicialización de la variable 'codigo' con el valor del parámetro 'codigo'
        this.titulo = titulo; // Inicialización de la variable 'titulo' con el valor del parámetro 'titulo'
        this.letra = letra; // Inicialización de la variable 'letra' con el valor del parámetro 'letra'
        this.tiempoEnMinutos = tiempoEnMinutos; // Inicialización de la variable 'tiempoEnMinutos' con el valor del parámetro 'tiempoEnMinutos'
    }

    public int getCodigo() { // Método getter que devuelve el valor de la variable 'codigo'
        return codigo;
    }

    public void setCodigo(int codigo) { // Método setter que establece el valor de la variable 'codigo' con el valor del parámetro 'codigo'
        this.codigo = codigo;
    }

    public String getTitulo() { // Método getter que devuelve el valor de la variable 'titulo'
        return titulo;
    }

    public void setTitulo(String titulo) { // Método setter que establece el valor de la variable 'titulo' con el valor del parámetro 'titulo'
        this.titulo = titulo;
    }

    public String getLetra() { // Método getter que devuelve el valor de la variable 'letra'
        return letra;
    }

    public void setLetra(String letra) { // Método setter que establece el valor de la variable 'letra' con el valor del parámetro 'letra'
        this.letra = letra;
    }

    public double getTiempoEnMinutos() { // Método getter que devuelve el valor de la variable 'tiempoEnMinutos'
        return tiempoEnMinutos;
    }

    public void setTiempoEnMinutos(double tiempoEnMinutos) { // Método setter que establece el valor de la variable 'tiempoEnMinutos' con el valor del parámetro 'tiempoEnMinutos'
        this.tiempoEnMinutos = tiempoEnMinutos;
    }

    @Override
    public int hashCode() { // Método que devuelve un número entero generado a partir de la variable 'titulo'
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.titulo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) { // Método que compara si dos objetos son iguales
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cancion other = (Cancion) obj;
        return Objects.equals(this.titulo, other.titulo);
    }

    @Override
    public String toString() { // Override del método toString para mostrar información del objeto Cancion en forma de string
        return "\nCancion: " + "\nCodigo: " + codigo + "\nTitulo=" + titulo + "\nLetra=" + letra + "\nTiempoEnMinutos=" + tiempoEnMinutos + '}';
    }  
}
