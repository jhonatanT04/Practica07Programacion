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
public class Disco {
    private int codigo; // variable de instancia privada para el código del disco
    private String nombre; // variable de instancia privada para el nombre del disco
    private int anioDeLanzamiento; // variable de instancia privada para el año de lanzamiento del disco

    public Disco() {
        // constructor por defecto sin parámetros
    }
    
    public Disco(int codigo, String nombre, int anioDeLanzamiento) {
        this.codigo = codigo; // asigna el código del disco a la variable de instancia correspondiente
        this.nombre = nombre; // asigna el nombre del disco a la variable de instancia correspondiente
        this.anioDeLanzamiento = anioDeLanzamiento; // asigna el año de lanzamiento del disco a la variable de instancia correspondiente
    }

    public int getCodigo() {
        return codigo; // retorna el código del disco
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo; // asigna el código del disco a la variable de instancia correspondiente
    }

    public String getNombre() {
        return nombre; // retorna el nombre del disco
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // asigna el nombre del disco a la variable de instancia correspondiente
    }

    public int getAnioDeLanzamiento() {
        return anioDeLanzamiento; // retorna el año de lanzamiento del disco
    }

    public void setAnioDeLanzamiento(int anioDeLanzamiento) {
        this.anioDeLanzamiento = anioDeLanzamiento; // asigna el año de lanzamiento del disco a la variable de instancia correspondiente
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7; // se inicializa una variable hash con un valor 7
        hash = 29 * hash + Objects.hashCode(this.nombre); // se aplica una función hash al nombre del disco y se multiplica por 29
        return hash; // retorna el valor resultante
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // si los objetos son iguales, retorna verdadero
            return true;
        }
        if (obj == null) { // si el objeto es nulo, retorna falso
            return false;
        }
        if (getClass() != obj.getClass()) { // si las clases no son iguales, retorna falso
            return false;
        }
        final Disco other = (Disco) obj; // se castea el objeto como Disco
        if (Objects.equals(this.nombre, other.nombre)){ // si los nombres de los discos son iguales, retorna falso
            return false;
        }
        return true; // retorna verdadero si no se cumple ninguna de las condiciones anteriores
    }

    @Override
    public String toString() {
        return "\nDisco: " + "Codigo: " + codigo + "Nombre: " + nombre + "AnioDeLanzamiento: " + anioDeLanzamiento + '}'; // retorna una cadena de caracteres con la información del disco
    }
}

