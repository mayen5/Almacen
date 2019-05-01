package com.cmayen.almacen.core.controller;

import com.cmayen.almacen.core.MainApp;
import com.cmayen.almacen.core.model.Cliente;
import com.cmayen.almacen.core.service.ClienteService;
import com.cmayen.almacen.core.service.ClienteServiceImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class ClienteController implements Initializable {

    private ClienteService clienteService = new ClienteServiceImpl();
    private ObservableList<Cliente> lista;
    private MainApp principal;

    @FXML
    private TableView tblCliente;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(clienteService.findAllCliente());
        this.tblCliente.setItems(lista);
    }

    public void setPrincipal(MainApp principal) {
        this.principal = principal;
    }

    public void regresarVentanaPrincipal() throws IOException {
        this.principal.mostrarVentanaPrincipal();
    }

}
