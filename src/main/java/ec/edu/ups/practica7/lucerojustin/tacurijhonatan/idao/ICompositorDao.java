/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica7.lucerojustin.tacurijhonatan.idao;

import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.modelo.Compositor;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ICompositorDao {
    
    public void create(Compositor compositor);
    public Compositor read(int codigo);
    public void update(Compositor compositor);
    public void delete(Compositor compostior);   
    public Compositor buscarPorTituloDeCancion(String valor);
    public List<Compositor> findAll();
    
}
