package com.cmayen.almacen.core.controller;

import com.cmayen.almacen.core.MainApp;
import com.cmayen.almacen.core.model.Proveedor;
import com.cmayen.almacen.core.service.ProveedorService;
import com.cmayen.almacen.core.service.ProveedorServiceImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class ProveedorController implements Initializable {
    
    private ProveedorService proveedorService = new ProveedorServiceImpl();
    private ObservableList<Proveedor> lista;
    
    private MainApp principal;
    
    @FXML private TableView tblProveedor;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       lista = FXCollections.observableArrayList(proveedorService.findAllProveedor());        
       this.tblProveedor.setItems(lista);
    }
    
    public void setPrincipal(MainApp principal){
        this.principal=principal;
    }
    
    public void regresarVentanaPrincipal()throws IOException {
        this.principal.mostrarVentanaPrincipal();
    }

}