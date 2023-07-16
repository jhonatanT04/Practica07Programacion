/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Compositor extends Persona {
    // Se crea la clase Compositor que extiende de la clase Persona
    private int numeroDeComposiciones;
    // Se declara el atributo numeroDeComposiciones como un entero
    private List<Cancion> cancionesTop100Billboard;
    // Se declara el atributo cancionesTop100Billboard como una lista de canciones
    private List<Cantante> cliente;
    // Se declara el atributo cliente como una lista de cantantes
    
    public Compositor() {
        cliente = new ArrayList();
        cancionesTop100Billboard = new ArrayList();
    }
    // Se crea un constructor por defecto de la clase Compositor, que inicializa las listas cliente y cancionesTop100Billboard como ArrayList vacíos
    
    public Compositor(int numeroDeComposiciones, int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario) {
        // Se crea un constructor de la clase Compositor que recibe varios parámetros
        super(codigo, nombre, apellido, edad, nacionalidad, salario);
        // Se llama al constructor de la clase padre Persona con los atributos especificados
        this.numeroDeComposiciones = numeroDeComposiciones;
        // Se asigna el valor del parámetro numeroDeComposiciones al atributo numeroDeComposiciones de la clase
        
        cliente = new ArrayList();
        cancionesTop100Billboard = new ArrayList();
        // Se asigna el valor del parámetro cliente al atributo cliente de la clase
    }

    

    @Override
    public double calcularSalario() {
        // Se sobrescribe el método calcularSalario de la clase Persona
        double salarioFinal = getSalario();
        // Se crea la variable salarioFinal y se le asigna el valor del salario de la persona
        if (numeroDeComposiciones > 5) {
            double regalia = 300;
            // Si el compositor ha compuesto más de 5 canciones se le asigna un bono de 300
            salarioFinal += regalia;
            // Se suma el bono al salario final
        }
        if (cancionesTop100Billboard.size() >= 1 && cancionesTop100Billboard.size() <= 3) {
            double c = salarioFinal * 0.10;
            // Si el compositor tiene entre 1 y 3 canciones en el top100 de billboard, se le asigna un bono del 10%
            salarioFinal += c;
            // Se suma el bono al salario final
        }
        if (cancionesTop100Billboard.size() >=4 && cancionesTop100Billboard.size() <= 6){ // Si la cantidad de canciones en el top 100 de Billboard es entre 4 y 6, se agrega un 20% al salario final
            double d = salarioFinal * 0.20;
            salarioFinal += d;
        }
        if(cancionesTop100Billboard.size() > 6){ // Si la cantidad de canciones en el top 100 de Billboard es mayor a 6, se agrega un 20% adicional al salario final
            double e = salarioFinal * 0.20;
            salarioFinal += e;
        }
        return salarioFinal; // Retorna el salario final del compositor
    }    

    public void agregarCancion(Cancion listcan){ // Método para agregar una canción al top 100 de Billboard
        // Se crea un objeto de tipo Cancion
        cancionesTop100Billboard.add(listcan); // Se agrega la canción a la lista de canciones top 100 de Billboard
    }
    public Cancion buscarCancione(int codigo){
        for (Cancion cancion : cancionesTop100Billboard) {
            if (cancion.getCodigo()==codigo) {
                return  cancion;
            }
        }
        return null;
    }
    public List<Cancion> listaCanciones(){
        return cancionesTop100Billboard;
    }
    
    public void agregarClientE(Cantante clientes) { // Método para agregar un cantante cliente al compositor
        cliente.add(clientes); // Se agrega el cantante a la lista de clientes del compositor
    }
    
    public void actualizarCancion(Cancion cancionActualizada) {
        int codigoCancion = cancionActualizada.getCodigo();
        for (Cancion cancion : cancionesTop100Billboard) {
            if (cancion.getCodigo() == codigoCancion) {
                cancion.setTitulo(cancionActualizada.getTitulo());
                cancion.setLetra(cancionActualizada.getLetra());
                cancion.setTiempoEnMinutos(cancionActualizada.getTiempoEnMinutos());
                //System.out.println("Canción actualizada correctamente.");
                return;
            }
        }
        //System.out.println("El código de canción no se encontró en el top 100 de Billboard.");
    }
    

    public void eliminarCancion(int codigoCancion) {
        for (Cancion cancion : cancionesTop100Billboard) {
            if (cancion.getCodigo() == codigoCancion) {
                cancionesTop100Billboard.remove(cancion);
                System.out.println("Canción eliminada correctamente.");
                return;
            }
        }
        System.out.println("El código de canción no se encontró en el top 100 de Billboard.");
    }


    public int getNumeroDeComposiciones() { // Getter para obtener el número de composiciones del compositor
        return numeroDeComposiciones;
    }

    public void setNumeroDeComposiciones(int numeroDeComposiciones) { // Setter para establecer el número de composiciones del compositor
        this.numeroDeComposiciones = numeroDeComposiciones;
    }

    public List<Cancion> getCancionesTop100Billboard() { // Getter para obtener la lista de canciones top 100 de Billboard del compositor
        return cancionesTop100Billboard;
    }

    public void setCancionesTop100Billboard(List<Cancion> cancionesTop100Billboard) { // Setter para establecer la lista de canciones top 100 de Billboard del compositor
        this.cancionesTop100Billboard = cancionesTop100Billboard;
    }

    public List<Cantante> getCliente() { // Getter para obtener la lista de clientes del compositor
        return cliente;
    }

    public void setCliente(List<Cantante> cliente) { // Setter para establecer la lista de clientes del compositor
        this.cliente = cliente;
    }

    @Override
    public String toString() { // Override del método toString para mostrar información del objeto Compositor en forma de string
        return "Compositor " + super.toString()  + "\nNumeroDeComposiciones=" + numeroDeComposiciones + "\nCancionesTop100Billboard: " + cancionesTop100Billboard + "\nClientes : " + cliente ;
    }    

   
}

