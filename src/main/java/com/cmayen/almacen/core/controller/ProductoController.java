package com.cmayen.almacen.core.controller;

import com.cmayen.almacen.core.MainApp;
import com.cmayen.almacen.core.model.Producto;
import com.cmayen.almacen.core.service.ProductoService;
import com.cmayen.almacen.core.service.ProductoServiceImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class ProductoController implements Initializable{
private ProductoService productoService = new ProductoServiceImpl();
    private ObservableList<Producto> lista;
    
    private MainApp principal;
    @FXML private TableView tblProducto;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       lista = FXCollections.observableArrayList(productoService.findAllProducto());        
       this.tblProducto.setItems(lista);
    }
    
    public void setPrincipal(MainApp principal){
        this.principal=principal;
    }
    
    public void regresarVentanaPrincipal()throws IOException {
        this.principal.mostrarVentanaPrincipal();
    }
    
}
