/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista;

import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.controlador.ControladorCantante;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.controlador.ControladorCompositor;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.dao.CantanteDao;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.dao.CompositorDao;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.idao.ICantanteDao;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.idao.ICompositorDao;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.cancion.ActualizarCancion;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.cancion.AgregarCancion;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.cancion.BuscarCancion;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.cancion.EliminarCancion;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.cantante.ActualizarCantante;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.cantante.BuscarCantante;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.cantante.BuscarPorNombreDeDisco;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.cantante.CrearCantante;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.cantante.EliminarCantante;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.cantante.ListarCantante;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.compositor.ActualizarCompositor;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.compositor.AgregarCliente;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.compositor.BuscarCompositor;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.compositor.BuscarPorTitulo;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.compositor.CrearCompositor;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.compositor.EliminarCompositor;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.compositor.ListarCompositor;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.disco.ActualizarDisco;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.disco.AgregarDisco;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.disco.BuscarDisco;
import ec.edu.ups.practica7.lucerojustin.tacurijhonatan.vista.disco.EliminarDisco;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ESTUDIANTE
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    private ControladorCantante controladorCantante;
    private ICantanteDao cantanteDao;
    private ControladorCompositor controladorCompositor;
    private ICompositorDao compositorDao;
    
    private EliminarCantante eliminarCantante;
    private CrearCantante ventanaCrearCantante;
    private BuscarCantante ventanaBuscarCantante;
    private ActualizarCantante actualizarCantante;
    private ListarCantante listarCantante;
    private CrearCompositor crearCompositor;
    private BuscarCompositor buscarCompositor;
    private ActualizarCompositor actualizarCompositor;
    private EliminarCompositor eliminarCompositor;
    private ListarCompositor listarCompositor;
    private AgregarCancion agregarCancion;
    private AgregarDisco agregarDisco;
    private BuscarCancion buscarCacion;
    private ActualizarCancion actualizarCancion;
    private EliminarCancion eliminarCancion;
    private ActualizarDisco actualizarDisco;
    private AgregarCliente agregarCliente;
    private BuscarDisco buscarDisco; 
    private BuscarPorTitulo buscarPorTitulo;
    private EliminarDisco eliminarDisco; 
    private BuscarPorNombreDeDisco buscarPorNombreDeDisco;
    
    //Internacionalizacion 
    private Locale localizacion;
    private ResourceBundle mensajes;
    
    //Imagenes
    //FondoPanel fondopanel = new FondoPanel();
    
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        //this.setContentPane(fondopanel);
        initComponents();
        cantanteDao = new CantanteDao();
        controladorCantante = new ControladorCantante(cantanteDao) ;
        compositorDao = new CompositorDao();
        controladorCompositor = new ControladorCompositor(compositorDao);
        
        
        
        //Internacionalizacion
        localizacion = Locale.getDefault();
        mensajes = ResourceBundle.getBundle("mensajes.mensaje", localizacion);
        cambiarIdioma();
    } 
    
    private void cambiarIdioma(){
        mensajes = ResourceBundle.getBundle("mensajes.mensaje", localizacion);
        menuCantante.setText(mensajes.getString("menu.cantante"));
        menuCompositor.setText(mensajes.getString("menu.Compositor"));
        menuIdiomas.setText(mensajes.getString("menu.idiomas"));
        menuOpciones.setText(mensajes.getString("menu.opciones"));
        menuItemCrearCantante.setText(mensajes.getString("menuItem.crear"));
        menuItemBuscarCantante.setText(mensajes.getString("menuItem.buscar"));
        menuItemEliminarCantante.setText(mensajes.getString("menuItem.eliminar"));
        menuItemActualizarCantante.setText(mensajes.getString("menuItem.actualizar"));
        menuItemListarCantante.setText(mensajes.getString("menuItem.listar"));
        menuItemDisco.setText(mensajes.getString("menuItem.disco")); 
        menuItemCrearCompositor.setText(mensajes.getString("menuItem.crear"));
        menuItemBuscarCompositor.setText(mensajes.getString("menuItem.buscar"));
        menuItemEliminarCompositor.setText(mensajes.getString("menuItem.eliminar"));
        menuItemActualizarCompositor.setText(mensajes.getString("menuItem.actualizar"));
        menuItemListarCompositor.setText(mensajes.getString("menuItem.listar"));
        menuItemBuscarPorTitulo.setText(mensajes.getString("menuItem.buscartitulo"));
        menuItemAgregarCliemt.setText(mensajes.getString("menuItem.agregarcliente")); 
        menuItemCancion.setText(mensajes.getString("menuItem.cancion"));
        menuItemAgregarCancion.setText(mensajes.getString("menuItem.agregar"));
        menuItemAgregarDisco.setText(mensajes.getString("menuItem.agregar"));
        menuItemBuscarCancion.setText(mensajes.getString("menuItem.buscar"));
        menuItemEliminarCancion.setText(mensajes.getString("menuItem.eliminar"));
        menuItemActualizarCancion.setText(mensajes.getString("menuItem.actualizar"));
        menuItemBuscarDisco.setText(mensajes.getString("menuItem.buscar"));
        menuItemEliminarDisco.setText(mensajes.getString("menuItem.eliminar"));
        menuItemActualizarDisco.setText(mensajes.getString("menuItem.actualizar"));
        menuItemSalirMenu.setText(mensajes.getString("menuItem.salir")); 
        menuItemEspanol.setText(mensajes.getString("menuItem.espanol"));
        menuItemIngles.setText(mensajes.getString("menuItem.ingles"));
        menuItemFrances.setText(mensajes.getString("menuItem.frances"));
        //menuItemBuscaporDisco.setText(mensajes.getString("menuItemBuscarPorNombreDeDisco.buscarPorNombreDisco")); 
        if(crearCompositor != null){
            crearCompositor.cambiarIdioma(localizacion);
        }
        
        if(eliminarCompositor != null){
            eliminarCompositor.cambiarIdioma(localizacion);
        }
        
        if(buscarCompositor != null){
            buscarCompositor.cambiarIdioma(localizacion);
        }
        
        if(actualizarCompositor != null){
            actualizarCompositor.cambiarIdioma(localizacion);
        }
        
        if(buscarPorTitulo != null){
            buscarPorTitulo.cambiarIdioma(localizacion);
        }
        
        if(agregarCliente != null){
            agregarCliente.cambiarIdioma(localizacion);
        }
        
        if(agregarCancion != null){
            agregarCancion.cambiarIdioma(localizacion);
        }
        
        if(actualizarCancion != null){
            actualizarCancion.cambiarIdioma(localizacion);
        }
        
        if(buscarCacion != null){
            buscarCacion.cambiarIdioma(localizacion);
        }
        
        if(eliminarCancion!= null){
            eliminarCancion.cambiarIdioma(localizacion);
        }
        
        if(agregarDisco!= null){
            agregarDisco.cambiarIdioma(localizacion);
        }
        
        if(actualizarDisco!= null){
            actualizarDisco.cambiarIdioma(localizacion);
        }
        
        if(buscarDisco!= null){
            buscarDisco.cambiarIdioma(localizacion);
        }
        
        if(eliminarDisco!= null){
            eliminarDisco.cambiarIdioma(localizacion);
        }
        
        if(ventanaCrearCantante!= null){
            ventanaCrearCantante.cambiarIdioma(localizacion);
        }
        
        if(ventanaBuscarCantante!= null){
            ventanaBuscarCantante.cambiarIdioma(localizacion);
        }
        
        if(actualizarCantante!= null){
            actualizarCantante.cambiarIdioma(localizacion);
        }
        
        if(buscarPorNombreDeDisco!= null){
            buscarPorNombreDeDisco.cambiarIdioma(localizacion);
        }
        
        if(eliminarCantante!= null){
            eliminarCantante.cambiarIdioma(localizacion);
        }
        
        if(listarCantante!= null){
            listarCantante.cambiarIdioma(localizacion);
        }
        
        if(listarCompositor!= null){
            listarCompositor.cambiarIdioma(localizacion);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuCantante = new javax.swing.JMenu();
        menuItemCrearCantante = new javax.swing.JMenuItem();
        menuItemActualizarCantante = new javax.swing.JMenuItem();
        menuItemBuscarCantante = new javax.swing.JMenuItem();
        menuItemEliminarCantante = new javax.swing.JMenuItem();
        menuItemListarCantante = new javax.swing.JMenuItem();
        menuItemBuscaporDisco = new javax.swing.JMenuItem();
        menuItemDisco = new javax.swing.JMenu();
        menuItemAgregarDisco = new javax.swing.JMenuItem();
        menuItemActualizarDisco = new javax.swing.JMenuItem();
        menuItemBuscarDisco = new javax.swing.JMenuItem();
        menuItemEliminarDisco = new javax.swing.JMenuItem();
        menuCompositor = new javax.swing.JMenu();
        menuItemCrearCompositor = new javax.swing.JMenuItem();
        menuItemActualizarCompositor = new javax.swing.JMenuItem();
        menuItemBuscarCompositor = new javax.swing.JMenuItem();
        menuItemEliminarCompositor = new javax.swing.JMenuItem();
        menuItemListarCompositor = new javax.swing.JMenuItem();
        menuItemAgregarCliemt = new javax.swing.JMenuItem();
        menuItemBuscarPorTitulo = new javax.swing.JMenuItem();
        menuItemCancion = new javax.swing.JMenu();
        menuItemAgregarCancion = new javax.swing.JMenuItem();
        menuItemActualizarCancion = new javax.swing.JMenuItem();
        menuItemBuscarCancion = new javax.swing.JMenuItem();
        menuItemEliminarCancion = new javax.swing.JMenuItem();
        menuIdiomas = new javax.swing.JMenu();
        menuItemIngles = new javax.swing.JMenuItem();
        menuItemFrances = new javax.swing.JMenuItem();
        menuItemEspanol = new javax.swing.JMenuItem();
        menuOpciones = new javax.swing.JMenu();
        menuItemSalirMenu = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoPrincipal.jpg"))); // NOI18N
        desktopPane.add(jLabel1);
        jLabel1.setBounds(0, 0, 1330, 940);

        menuCantante.setMnemonic('f');
        menuCantante.setText("Cantante");

        menuItemCrearCantante.setMnemonic('o');
        menuItemCrearCantante.setText("Crear");
        menuItemCrearCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCrearCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemCrearCantante);

        menuItemActualizarCantante.setMnemonic('s');
        menuItemActualizarCantante.setText("Actualizar");
        menuItemActualizarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActualizarCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemActualizarCantante);

        menuItemBuscarCantante.setMnemonic('a');
        menuItemBuscarCantante.setText("Buscar");
        menuItemBuscarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemBuscarCantante);

        menuItemEliminarCantante.setMnemonic('x');
        menuItemEliminarCantante.setText("Eliminar");
        menuItemEliminarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEliminarCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemEliminarCantante);

        menuItemListarCantante.setText("Listar");
        menuItemListarCantante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListarCantanteActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemListarCantante);

        menuItemBuscaporDisco.setText("Buscar Por Nombre Disco");
        menuItemBuscaporDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscaporDiscoActionPerformed(evt);
            }
        });
        menuCantante.add(menuItemBuscaporDisco);

        menuItemDisco.setText("Disco");

        menuItemAgregarDisco.setText("Agregar");
        menuItemAgregarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAgregarDiscoActionPerformed(evt);
            }
        });
        menuItemDisco.add(menuItemAgregarDisco);

        menuItemActualizarDisco.setText("Actualizar");
        menuItemActualizarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActualizarDiscoActionPerformed(evt);
            }
        });
        menuItemDisco.add(menuItemActualizarDisco);

        menuItemBuscarDisco.setText("Buscar");
        menuItemBuscarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarDiscoActionPerformed(evt);
            }
        });
        menuItemDisco.add(menuItemBuscarDisco);

        menuItemEliminarDisco.setText("Eliminar");
        menuItemEliminarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEliminarDiscoActionPerformed(evt);
            }
        });
        menuItemDisco.add(menuItemEliminarDisco);

        menuCantante.add(menuItemDisco);

        menuBar.add(menuCantante);

        menuCompositor.setMnemonic('e');
        menuCompositor.setText("Compositor");

        menuItemCrearCompositor.setMnemonic('t');
        menuItemCrearCompositor.setText("Crear");
        menuItemCrearCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCrearCompositorActionPerformed(evt);
            }
        });
        menuCompositor.add(menuItemCrearCompositor);

        menuItemActualizarCompositor.setMnemonic('y');
        menuItemActualizarCompositor.setText("Actualizar");
        menuItemActualizarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActualizarCompositorActionPerformed(evt);
            }
        });
        menuCompositor.add(menuItemActualizarCompositor);

        menuItemBuscarCompositor.setMnemonic('p');
        menuItemBuscarCompositor.setText("Buscar");
        menuItemBuscarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarCompositorActionPerformed(evt);
            }
        });
        menuCompositor.add(menuItemBuscarCompositor);

        menuItemEliminarCompositor.setMnemonic('d');
        menuItemEliminarCompositor.setText("Eliminar");
        menuItemEliminarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEliminarCompositorActionPerformed(evt);
            }
        });
        menuCompositor.add(menuItemEliminarCompositor);

        menuItemListarCompositor.setText("Listar");
        menuItemListarCompositor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemListarCompositorActionPerformed(evt);
            }
        });
        menuCompositor.add(menuItemListarCompositor);

        menuItemAgregarCliemt.setText("Agregar Cliente");
        menuItemAgregarCliemt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAgregarCliemtActionPerformed(evt);
            }
        });
        menuCompositor.add(menuItemAgregarCliemt);

        menuItemBuscarPorTitulo.setText("Buscar Por Titulo");
        menuItemBuscarPorTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarPorTituloActionPerformed(evt);
            }
        });
        menuCompositor.add(menuItemBuscarPorTitulo);

        menuItemCancion.setText("Cancion");

        menuItemAgregarCancion.setText("Agregar");
        menuItemAgregarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAgregarCancionActionPerformed(evt);
            }
        });
        menuItemCancion.add(menuItemAgregarCancion);

        menuItemActualizarCancion.setText("Actualizar");
        menuItemActualizarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemActualizarCancionActionPerformed(evt);
            }
        });
        menuItemCancion.add(menuItemActualizarCancion);

        menuItemBuscarCancion.setText("Buscar");
        menuItemBuscarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBuscarCancionActionPerformed(evt);
            }
        });
        menuItemCancion.add(menuItemBuscarCancion);

        menuItemEliminarCancion.setText("Eliminar");
        menuItemEliminarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEliminarCancionActionPerformed(evt);
            }
        });
        menuItemCancion.add(menuItemEliminarCancion);

        menuCompositor.add(menuItemCancion);

        menuBar.add(menuCompositor);

        menuIdiomas.setText("Idiomas");

        menuItemIngles.setText("Inglés");
        menuItemIngles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemInglesActionPerformed(evt);
            }
        });
        menuIdiomas.add(menuItemIngles);

        menuItemFrances.setText("Francés");
        menuItemFrances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFrancesActionPerformed(evt);
            }
        });
        menuIdiomas.add(menuItemFrances);

        menuItemEspanol.setText("Español");
        menuItemEspanol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEspanolActionPerformed(evt);
            }
        });
        menuIdiomas.add(menuItemEspanol);

        menuBar.add(menuIdiomas);

        menuOpciones.setMnemonic('h');
        menuOpciones.setText("Opciones");

        menuItemSalirMenu.setMnemonic('c');
        menuItemSalirMenu.setText("Salir");
        menuItemSalirMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirMenuActionPerformed(evt);
            }
        });
        menuOpciones.add(menuItemSalirMenu);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        menuOpciones.add(aboutMenuItem);

        menuBar.add(menuOpciones);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemEliminarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEliminarCantanteActionPerformed
        if(eliminarCantante == null){
            eliminarCantante = new EliminarCantante(controladorCantante);
            desktopPane.add(eliminarCantante);
        }
        eliminarCantante.cambiarIdioma(localizacion); 
        eliminarCantante.setVisible(true); 
    }//GEN-LAST:event_menuItemEliminarCantanteActionPerformed

    private void menuItemCrearCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCrearCompositorActionPerformed
        if(crearCompositor == null){
            crearCompositor = new CrearCompositor(controladorCompositor);
            desktopPane.add(crearCompositor);
        }
        crearCompositor.cambiarIdioma(localizacion); 
        crearCompositor.setVisible(true); 
    }//GEN-LAST:event_menuItemCrearCompositorActionPerformed

    private void menuItemBuscarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarCompositorActionPerformed
        if(buscarCompositor == null){
            buscarCompositor = new BuscarCompositor(controladorCompositor);
            desktopPane.add(buscarCompositor);
        }
        buscarCompositor.cambiarIdioma(localizacion); 
        buscarCompositor.setVisible(true); 
    }//GEN-LAST:event_menuItemBuscarCompositorActionPerformed

    private void menuItemCrearCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCrearCantanteActionPerformed
        if(ventanaCrearCantante == null){
            ventanaCrearCantante = new CrearCantante(controladorCantante);
            desktopPane.add(ventanaCrearCantante);
        }
        ventanaCrearCantante.cambiarIdioma(localizacion); 
        ventanaCrearCantante.setVisible(true); 
    }//GEN-LAST:event_menuItemCrearCantanteActionPerformed

    private void menuItemBuscarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarCantanteActionPerformed
        // TODO add your handling code here:
        if(ventanaBuscarCantante == null){
            ventanaBuscarCantante = new BuscarCantante(controladorCantante);
            desktopPane.add(ventanaBuscarCantante);
        }
        ventanaBuscarCantante.cambiarIdioma(localizacion); 
        ventanaBuscarCantante.setVisible(true); 
    }//GEN-LAST:event_menuItemBuscarCantanteActionPerformed

    private void menuItemAgregarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAgregarCancionActionPerformed
        if(agregarCancion == null){
            agregarCancion = new AgregarCancion(controladorCompositor);
            desktopPane.add(agregarCancion);
        }
        agregarCancion.cambiarIdioma(localizacion); 
        agregarCancion.setVisible(true); 
    }//GEN-LAST:event_menuItemAgregarCancionActionPerformed

    private void menuItemActualizarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActualizarCantanteActionPerformed
        // TODO add your handling code here:
        if(actualizarCantante == null){
            actualizarCantante = new ActualizarCantante(controladorCantante);
            desktopPane.add(actualizarCantante);
        }
        actualizarCantante.cambiarIdioma(localizacion);
        actualizarCantante.setVisible(true); 
        
    }//GEN-LAST:event_menuItemActualizarCantanteActionPerformed

    private void menuItemListarCantanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListarCantanteActionPerformed
        // TODO add your handling code here:
        if(listarCantante == null){
            listarCantante = new ListarCantante(controladorCantante);
            desktopPane.add(listarCantante);
        }
        listarCantante.cambiarIdioma(localizacion); 
        listarCantante.setVisible(true); 
    }//GEN-LAST:event_menuItemListarCantanteActionPerformed

    private void menuItemActualizarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActualizarCompositorActionPerformed
        if(actualizarCompositor == null){
            actualizarCompositor = new ActualizarCompositor(controladorCompositor);
            desktopPane.add(actualizarCompositor);
        }
        actualizarCompositor.cambiarIdioma(localizacion); 
        actualizarCompositor.setVisible(true); 
    }//GEN-LAST:event_menuItemActualizarCompositorActionPerformed

    private void menuItemEliminarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEliminarCompositorActionPerformed
        if(eliminarCompositor == null){
            eliminarCompositor = new EliminarCompositor(controladorCompositor);
            desktopPane.add(eliminarCompositor);
        }
        eliminarCompositor.cambiarIdioma(localizacion); 
        eliminarCompositor.setVisible(true); 
    }//GEN-LAST:event_menuItemEliminarCompositorActionPerformed

    private void menuItemListarCompositorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemListarCompositorActionPerformed
        if(listarCompositor == null){
            listarCompositor = new ListarCompositor(controladorCompositor);
            desktopPane.add(listarCompositor);
        }
        listarCompositor.cambiarIdioma(localizacion); 
        listarCompositor.setVisible(true); 
    }//GEN-LAST:event_menuItemListarCompositorActionPerformed

    private void menuItemAgregarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAgregarDiscoActionPerformed
        // TODO add your handling code here:
        if(agregarDisco == null){
            agregarDisco = new AgregarDisco(controladorCantante);
            desktopPane.add(agregarDisco);
        }
        agregarDisco.cambiarIdioma(localizacion);
        agregarDisco.setVisible(true); 
    }//GEN-LAST:event_menuItemAgregarDiscoActionPerformed

    private void menuItemEspanolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEspanolActionPerformed
        localizacion = new Locale("es", "EC");
        cambiarIdioma();
    }//GEN-LAST:event_menuItemEspanolActionPerformed

    private void menuItemInglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemInglesActionPerformed
        localizacion = new Locale("en", "US");
        cambiarIdioma();
    }//GEN-LAST:event_menuItemInglesActionPerformed

    private void menuItemActualizarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActualizarDiscoActionPerformed
        // TODO add your handling code here:
        if(actualizarDisco == null){
            actualizarDisco = new ActualizarDisco(controladorCantante);
            desktopPane.add(actualizarDisco);
        }
        actualizarDisco.cambiarIdioma(localizacion);
        actualizarDisco.setVisible(true); 
    }//GEN-LAST:event_menuItemActualizarDiscoActionPerformed

    private void menuItemBuscarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarCancionActionPerformed
        if(buscarCacion == null){
            buscarCacion = new BuscarCancion(controladorCompositor);
            desktopPane.add(buscarCacion);
        }
        buscarCacion.cambiarIdioma(localizacion);
        buscarCacion.setVisible(true);
    }//GEN-LAST:event_menuItemBuscarCancionActionPerformed

    private void menuItemActualizarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemActualizarCancionActionPerformed
        if(actualizarCancion == null){
            actualizarCancion = new ActualizarCancion(controladorCompositor);
            desktopPane.add(actualizarCancion);
        }
        actualizarCancion.cambiarIdioma(localizacion);
        actualizarCancion.setVisible(true);
    }//GEN-LAST:event_menuItemActualizarCancionActionPerformed

    private void menuItemEliminarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEliminarCancionActionPerformed
        if(eliminarCancion == null){
            eliminarCancion = new EliminarCancion(controladorCompositor);
            desktopPane.add(eliminarCancion);
        }
        eliminarCancion.cambiarIdioma(localizacion); 
        eliminarCancion.setVisible(true);
    }//GEN-LAST:event_menuItemEliminarCancionActionPerformed

    private void menuItemAgregarCliemtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAgregarCliemtActionPerformed
        if(agregarCliente == null){
            agregarCliente = new AgregarCliente(controladorCompositor,controladorCantante);
            desktopPane.add(agregarCliente);
        }
        agregarCliente.cambiarIdioma(localizacion);
        agregarCliente.setVisible(true);
    }//GEN-LAST:event_menuItemAgregarCliemtActionPerformed

    private void menuItemBuscarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarDiscoActionPerformed
        // TODO add your handling code here:
        if(buscarDisco == null){
            buscarDisco = new BuscarDisco(controladorCantante);
            desktopPane.add(buscarDisco);
        }
        buscarDisco.cambiarIdioma(localizacion);
        buscarDisco.setVisible(true);
    }//GEN-LAST:event_menuItemBuscarDiscoActionPerformed

    private void menuItemEliminarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEliminarDiscoActionPerformed
        // TODO add your handling code here:
        
        if(eliminarDisco == null){
            eliminarDisco = new EliminarDisco(controladorCantante);
            desktopPane.add(eliminarDisco);
        }
        eliminarDisco.cambiarIdioma(localizacion);
        eliminarDisco.setVisible(true);
    }//GEN-LAST:event_menuItemEliminarDiscoActionPerformed

    private void menuItemBuscarPorTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscarPorTituloActionPerformed
        if(buscarPorTitulo == null){
            buscarPorTitulo = new BuscarPorTitulo(controladorCompositor);
            desktopPane.add(buscarPorTitulo);
        }
        buscarPorTitulo.cambiarIdioma(localizacion);
        buscarPorTitulo.setVisible(true);
    }//GEN-LAST:event_menuItemBuscarPorTituloActionPerformed

    private void menuItemFrancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFrancesActionPerformed
        localizacion = new Locale("fr", "FR");
        this.cambiarIdioma();
    }//GEN-LAST:event_menuItemFrancesActionPerformed

    private void menuItemBuscaporDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBuscaporDiscoActionPerformed
        if(buscarPorNombreDeDisco== null){
            buscarPorNombreDeDisco = new BuscarPorNombreDeDisco(controladorCantante);
            desktopPane.add(buscarPorNombreDeDisco);
        }
        buscarPorNombreDeDisco.cambiarIdioma(localizacion); 
        buscarPorNombreDeDisco.setVisible(true);
    }//GEN-LAST:event_menuItemBuscaporDiscoActionPerformed

    private void menuItemSalirMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirMenuActionPerformed
        System.exit(0); 
    }//GEN-LAST:event_menuItemSalirMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCantante;
    private javax.swing.JMenu menuCompositor;
    private javax.swing.JMenu menuIdiomas;
    private javax.swing.JMenuItem menuItemActualizarCancion;
    private javax.swing.JMenuItem menuItemActualizarCantante;
    private javax.swing.JMenuItem menuItemActualizarCompositor;
    private javax.swing.JMenuItem menuItemActualizarDisco;
    private javax.swing.JMenuItem menuItemAgregarCancion;
    private javax.swing.JMenuItem menuItemAgregarCliemt;
    private javax.swing.JMenuItem menuItemAgregarDisco;
    private javax.swing.JMenuItem menuItemBuscaporDisco;
    private javax.swing.JMenuItem menuItemBuscarCancion;
    private javax.swing.JMenuItem menuItemBuscarCantante;
    private javax.swing.JMenuItem menuItemBuscarCompositor;
    private javax.swing.JMenuItem menuItemBuscarDisco;
    private javax.swing.JMenuItem menuItemBuscarPorTitulo;
    private javax.swing.JMenu menuItemCancion;
    private javax.swing.JMenuItem menuItemCrearCantante;
    private javax.swing.JMenuItem menuItemCrearCompositor;
    private javax.swing.JMenu menuItemDisco;
    private javax.swing.JMenuItem menuItemEliminarCancion;
    private javax.swing.JMenuItem menuItemEliminarCantante;
    private javax.swing.JMenuItem menuItemEliminarCompositor;
    private javax.swing.JMenuItem menuItemEliminarDisco;
    private javax.swing.JMenuItem menuItemEspanol;
    private javax.swing.JMenuItem menuItemFrances;
    private javax.swing.JMenuItem menuItemIngles;
    private javax.swing.JMenuItem menuItemListarCantante;
    private javax.swing.JMenuItem menuItemListarCompositor;
    private javax.swing.JMenuItem menuItemSalirMenu;
    private javax.swing.JMenu menuOpciones;
    // End of variables declaration//GEN-END:variables

        //class FondoPanel extends JPanel{
            //private Image imagen;
            //@Override   
            //public void paint(Graphics g){
                //imagen = new ImageIcon(getClass().getResource("/imagenes/imagenPricipal.jpg")).getImage();
                //g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
                /*setOpaque(false);
                super.paint(g);
            }
        }*/
    
        
}
