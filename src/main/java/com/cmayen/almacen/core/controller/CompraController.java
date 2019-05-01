package com.cmayen.almacen.core.controller;

import com.cmayen.almacen.core.MainApp;
import com.cmayen.almacen.core.model.Compra;
import com.cmayen.almacen.core.service.CompraService;
import com.cmayen.almacen.core.service.CompraServiceImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class CompraController implements Initializable {

    private CompraService compraService = new CompraServiceImpl();
    private ObservableList<Compra> lista;

    private MainApp principal;

    @FXML
    private TableView tblCompra;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(compraService.findAllCompra());
        this.tblCompra.setItems(lista);
    }

    public void setPrincipal(MainApp principal) {
        this.principal = principal;
    }

    public void regresarVentanaPrincipal() throws IOException {
        this.principal.mostrarVentanaPrincipal();
    }

}
