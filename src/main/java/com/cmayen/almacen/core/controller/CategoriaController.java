package com.cmayen.almacen.core.controller;

import com.cmayen.almacen.core.MainApp;
import com.cmayen.almacen.core.model.Categoria;
import com.cmayen.almacen.core.service.CategoriaService;
import com.cmayen.almacen.core.service.CategoriaServiceImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class CategoriaController implements Initializable{

    private CategoriaService categoriaService = new CategoriaServiceImpl();
    private ObservableList<Categoria> lista;
    
    private MainApp principal;
    
    @FXML private TableView tblCategoria;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       lista = FXCollections.observableArrayList(categoriaService.findAllCategoria());        
       this.tblCategoria.setItems(lista);
    }
    
    public void setPrincipal(MainApp principal){
        this.principal=principal;
    }
    
    public void regresarVentanaPrincipal()throws IOException {
        this.principal.mostrarVentanaPrincipal();
    }
    
}
