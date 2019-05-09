package com.cmayen.almacen.core.controller;

import com.cmayen.almacen.core.MainApp;
import com.cmayen.almacen.core.service.CategoriaService;
import com.cmayen.almacen.core.service.CategoriaServiceImpl;
import com.cmayen.almacen.core.service.ClienteService;
import com.cmayen.almacen.core.service.ClienteServiceImpl;
import com.cmayen.almacen.core.service.CompraService;
import com.cmayen.almacen.core.service.CompraServiceImpl;
import com.cmayen.almacen.core.service.ProductoService;
import com.cmayen.almacen.core.service.ProductoServiceImpl;
import com.cmayen.almacen.core.service.ProveedorService;
import com.cmayen.almacen.core.service.ProveedorServiceImpl;
import com.cmayen.almacen.core.service.TipoDeEmpaqueService;
import com.cmayen.almacen.core.service.TipoDeEmpaqueServiceImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLController implements Initializable {

    private ProveedorService proveedorService = new ProveedorServiceImpl();
    private ClienteService clienteService = new ClienteServiceImpl();
    private ProductoService productoService = new ProductoServiceImpl();
    private CategoriaService categoriaService = new CategoriaServiceImpl();
    private TipoDeEmpaqueService tipoDeEmpaqueService = new TipoDeEmpaqueServiceImpl();
    private CompraService CompraService = new CompraServiceImpl();

    private MainApp principal;
    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        /*Proveedor nuevo = new Proveedor();
        nuevo.setContactoPrincipal("Carmelo Mayen");
        nuevo.setDireccion("Guatemala, Guatemala");
        nuevo.setNit("5974049-3");
        nuevo.setPaginaWeb("www.cemayen.com");
        nuevo.setRazonSocial("Carmelo Mayen Company");
        System.out.println("You clicked me!");
        proveedorService.saveProveedor(nuevo);
        label.setText("Proveedor almacenado!");*/
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setPrincipal(MainApp principal) {
        this.principal = principal;
    }
    
    public void cerrarVentana(){
        System.exit(0);
    }

    public void mostrarVentanaProveedores() throws IOException {
        this.principal.mostrarVentanaProveedores();
    }

    public void mostrarVentanaClientes() throws IOException {
        this.principal.mostrarVentanaClientes();
    }

    public void mostrarVentanaCompras() throws IOException {
        this.principal.mostrarVentanaCompras();
    }

    public void mostrarVentanaProductos() throws IOException {
        this.principal.mostrarVentanaProductos();
    }

    public void mostrarVentanaTipoDeEmpaques() throws IOException {
        this.principal.mostrarVentanaTipoDeEmpaques();
    }

    public void mostrarVentanaCategorias() throws IOException {
        this.principal.mostrarVentanaCategorias();
    }
    

}
