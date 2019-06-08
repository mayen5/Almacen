package com.cmayen.almacen.core;

import com.cmayen.almacen.core.controller.CategoriaController;
import com.cmayen.almacen.core.controller.ClienteController;
import com.cmayen.almacen.core.controller.CompraController;
import com.cmayen.almacen.core.controller.FXMLController;
import com.cmayen.almacen.core.controller.ProductoController;
import com.cmayen.almacen.core.controller.ProveedorController;
import com.cmayen.almacen.core.controller.TipoDeEmpaqueController;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private final String PAQUETE_VISTA = "/com/cmayen/almacen/core/view/";
    private Stage escenarioPrincipal;

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        this.escenarioPrincipal = escenarioPrincipal;
        mostrarVentanaPrincipal();
        //mostrarVentanaProveedores();
        this.escenarioPrincipal.setTitle("Sistema Almacen V1");
        this.escenarioPrincipal.show();
    }


    public void mostrarVentanaPrincipal() throws IOException {
        FXMLController main = (FXMLController) cambiarEscena("VentanaPrincipalView.fxml", 800, 600);
        main.setPrincipal(this);

    }

    //Metodo para cambiar el escenario principal
    public Initializable cambiarEscena(String fxml, int ancho, int alto) throws IOException {
        Initializable resultado = null;
        //Cargador del archivo FXML
        FXMLLoader cargadorFXML = new FXMLLoader();
        //Asignacion del archivo logico
        InputStream archivo = MainApp.class.getResourceAsStream(PAQUETE_VISTA + fxml);
        //Cargador de fabrica para cargar el archivo FXML
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        //Direccion de la ruta del archivo FXML
        cargadorFXML.setLocation(MainApp.class.getResource(PAQUETE_VISTA + fxml));
        //Creacion de la escena
        Scene scene = new Scene((AnchorPane) cargadorFXML.load(archivo), ancho, alto);
        //Asignacion de estilo a la escena
        scene.getStylesheets().add("/styles/Styles.css");
        //Asignacion de la escena en el escenario principal
        this.escenarioPrincipal.setScene(scene);
        //Ajustar el tamaño del escenario a la escena
        this.escenarioPrincipal.sizeToScene();
        //Retornar el objeto initializable del controlador
        resultado = (Initializable) cargadorFXML.getController();
        return resultado;
    }
    
    public void mostrarVentanaProveedores() throws IOException {
        ProveedorController proveedorController = (ProveedorController) cambiarEscena("ProveedorView.fxml", 760, 600);
        proveedorController.setPrincipal(this);
    }
    
    public void mostrarVentanaClientes() throws IOException {
        ClienteController clienteController = (ClienteController) cambiarEscena("ClienteView.fxml", 760, 600);
        clienteController.setPrincipal(this);
    }
    
    public void mostrarVentanaCompras() throws IOException {
        CompraController compraController = (CompraController) cambiarEscena("CompraView.fxml", 760, 600);
        compraController.setPrincipal(this);
    }
    
    public void mostrarVentanaProductos() throws IOException {
        ProductoController productoController = (ProductoController) cambiarEscena("ProductoView.fxml", 760, 600);
        productoController.setPrincipal(this);
    }
    
    public void mostrarVentanaTipoDeEmpaques() throws IOException {
        TipoDeEmpaqueController tipoDeEmpaqueController = (TipoDeEmpaqueController) cambiarEscena("TipoDeEmpaqueView.fxml", 760, 600);
        tipoDeEmpaqueController.setPrincipal(this);
    }
    
    public void mostrarVentanaCategorias() throws IOException {
        CategoriaController categoriaController = (CategoriaController) cambiarEscena("CategoriaView.fxml", 600, 400);
        categoriaController.setPrincipal(this);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
