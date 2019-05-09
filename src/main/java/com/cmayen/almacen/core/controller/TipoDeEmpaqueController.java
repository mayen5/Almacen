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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TipoDeEmpaqueController implements Initializable {

    private MainApp principal;
    private TipoDeEmpaqueService tipoDeEmpaqueService = new TipoDeEmpaqueServiceImpl();
    private ObservableList<TipoDeEmpaque> lista;

    @FXML
    private TableView tblTipoDeEmpaque;

    @FXML
    private TableColumn<TipoDeEmpaque, Number> colCodigoTipoDeEmpaque;

    @FXML
    private TableColumn<TipoDeEmpaque, String> colDescripcion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(tipoDeEmpaqueService.findAllTipoDeEmpaque());
        this.tblTipoDeEmpaque.setItems(lista);
        
        this.colCodigoTipoDeEmpaque.setCellValueFactory(cellData -> cellData.getValue().codigoEmpaque());
        this.colDescripcion.setCellValueFactory(cellData -> cellData.getValue().descripcion());
    }

    public void setPrincipal(MainApp principal) {
        this.principal = principal;
    }

    public void regresarVentanaPrincipal() throws IOException {
        this.principal.mostrarVentanaPrincipal();
    }

}
