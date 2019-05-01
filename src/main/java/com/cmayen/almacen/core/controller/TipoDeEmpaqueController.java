package com.cmayen.almacen.core.controller;

import com.cmayen.almacen.core.MainApp;
import com.cmayen.almacen.core.model.TipoDeEmpaque;
import com.cmayen.almacen.core.service.TipoDeEmpaqueService;
import com.cmayen.almacen.core.service.TipoDeEmpaqueServiceImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class TipoDeEmpaqueController implements Initializable{

   private TipoDeEmpaqueService tipoDeEmpaqueService = new TipoDeEmpaqueServiceImpl();
    private ObservableList<TipoDeEmpaque> lista;
    
    private MainApp principal;
    
    @FXML private TableView tblTipoDeEmpaque;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       lista = FXCollections.observableArrayList(tipoDeEmpaqueService.findAllTipoDeEmpaque());        
       this.tblTipoDeEmpaque.setItems(lista);
    }
    
    public void setPrincipal(MainApp principal){
        this.principal=principal;
    }
    
    public void regresarVentanaPrincipal()throws IOException {
        this.principal.mostrarVentanaPrincipal();
    }
    
}
