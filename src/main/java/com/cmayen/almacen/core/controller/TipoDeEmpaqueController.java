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
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class TipoDeEmpaqueController implements Initializable {

    private MainApp principal;
    private TipoDeEmpaqueService tipoDeEmpaqueService = new TipoDeEmpaqueServiceImpl();
    private ObservableList<TipoDeEmpaque> lista;

    @FXML
    private TableView<TipoDeEmpaque> tblTipoDeEmpaque;

    @FXML
    private TableColumn<TipoDeEmpaque, Number> colCodigoTipoDeEmpaque;

    @FXML
    private TableColumn<TipoDeEmpaque, String> colDescripcion;
    
    @FXML private TextField txtDescripcion;

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
    
    public void nuevo() {
        try {
            TipoDeEmpaque nuevo = new TipoDeEmpaque();
            nuevo.setDescripcion(txtDescripcion.getText());
            this.tipoDeEmpaqueService.saveTipoDeEmpaque(nuevo);
            this.lista.add(nuevo);
            JOptionPane.showMessageDialog(null, "Registro almacenado");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en el registro de los datos!");
        }
        limpiar();
    }
    public void limpiar(){
        txtDescripcion.setText("");
    }
    public void seleccionar(){
        txtDescripcion.setText(tblTipoDeEmpaque.getSelectionModel().getSelectedItem().getDescripcion());
    }

}
