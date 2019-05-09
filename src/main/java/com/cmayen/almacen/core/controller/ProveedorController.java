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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class ProveedorController implements Initializable {
    
    private MainApp principal;
    private ProveedorService proveedorService = new ProveedorServiceImpl();
    private ObservableList<Proveedor> lista;
    
    @FXML
    private TableView<Proveedor> tblProveedor;
    @FXML
    private TableColumn<Proveedor, String> colNit;
    @FXML
    private TableColumn<Proveedor, String> colRazonSocial;
    @FXML
    private TableColumn<Proveedor, String> colDireccion;
    @FXML
    private TableColumn<Proveedor, String> colPaginaWeb;
    @FXML
    private TableColumn<Proveedor, String> colContactoPrincipal;
    
    @FXML private TextField txtNit;
    @FXML private TextField txtRazonSocial;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtPaginaWeb;
    @FXML private TextField txtContactoPrincipal;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(proveedorService.findAllProveedor());
        this.tblProveedor.setItems(lista);
        this.colNit.setCellValueFactory(cellData -> cellData.getValue().nit());
        this.colRazonSocial.setCellValueFactory(cellData -> cellData.getValue().razonSocial());
        this.colDireccion.setCellValueFactory(cellData -> cellData.getValue().direccion());
        this.colPaginaWeb.setCellValueFactory(cellData -> cellData.getValue().paginaWeb());
        this.colContactoPrincipal.setCellValueFactory(cellData -> cellData.getValue().contactoPrincipal());
    }
    
    public void setPrincipal(MainApp principal) {
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException {
        this.principal.mostrarVentanaPrincipal();
    }
    
    public void nuevo() {
        try {
            Proveedor nuevo = new Proveedor();
            nuevo.setNit(txtNit.getText());
            nuevo.setRazonSocial(txtRazonSocial.getText());
            nuevo.setDireccion(txtDireccion.getText());
            nuevo.setPaginaWeb(txtPaginaWeb.getText());
            nuevo.setContactoPrincipal(txtContactoPrincipal.getText());
            this.proveedorService.saveProveedor(nuevo);
            this.lista.add(nuevo);
            JOptionPane.showMessageDialog(null, "Registro almacenado");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en el registro de los datos!");
        }
        limpiar();
    }
    public void limpiar(){
        txtNit.setText("");
        txtRazonSocial.setText("");
        txtDireccion.setText("");
        txtPaginaWeb.setText("");
        txtContactoPrincipal.setText("");
    }
    public void seleccionar(){
        txtNit.setText(tblProveedor.getSelectionModel().getSelectedItem().getNit());
        txtRazonSocial.setText(tblProveedor.getSelectionModel().getSelectedItem().getRazonSocial());
        txtDireccion.setText(tblProveedor.getSelectionModel().getSelectedItem().getDireccion());
        txtPaginaWeb.setText(tblProveedor.getSelectionModel().getSelectedItem().getPaginaWeb());
        txtContactoPrincipal.setText(tblProveedor.getSelectionModel().getSelectedItem().getContactoPrincipal());
    }
    
}
