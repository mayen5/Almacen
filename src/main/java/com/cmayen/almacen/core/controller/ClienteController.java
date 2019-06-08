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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class ClienteController implements Initializable {

    private ClienteService clienteService = new ClienteServiceImpl();
    private ObservableList<Cliente> lista;
    private MainApp principal;

    
    @FXML
    private TableView<Cliente> tblCliente;
    @FXML
    private TableColumn<Cliente, String> colNit;
    @FXML
    private TableColumn<Cliente, String> colDpi;
    @FXML
    private TableColumn<Cliente, String> colNombre;
    @FXML
    private TableColumn<Cliente, String> colDireccion;
    
    
    @FXML private TextField txtNit;
    @FXML private TextField txtDpi;
    @FXML private TextField txtNombre;
    @FXML private TextField txtDireccion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(clienteService.findAllCliente());
        this.tblCliente.setItems(lista);
        this.colNit.setCellValueFactory(cellData -> cellData.getValue().nit());
        this.colDpi.setCellValueFactory(cellData -> cellData.getValue().dpi());
        this.colNombre.setCellValueFactory(cellData -> cellData.getValue().nombre());
        this.colDireccion.setCellValueFactory(cellData -> cellData.getValue().direccion());
    }

    public void setPrincipal(MainApp principal) {
        this.principal = principal;
    }

    public void regresarVentanaPrincipal() throws IOException {
        this.principal.mostrarVentanaPrincipal();
    }

    public void nuevo() {
        try {
            Cliente nuevo = new Cliente();
            nuevo.setNit(txtNit.getText());
            nuevo.setDpi(txtDpi.getText());
            nuevo.setNombre(txtNombre.getText());
            nuevo.setDireccion(txtDireccion.getText());
            this.clienteService.saveCliente(nuevo);
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
        txtDpi.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
    }
    public void seleccionar(){
        txtNit.setText(tblCliente.getSelectionModel().getSelectedItem().getNit());
        txtDpi.setText(tblCliente.getSelectionModel().getSelectedItem().getDpi());
        txtNombre.setText(tblCliente.getSelectionModel().getSelectedItem().getNombre());
        txtDireccion.setText(tblCliente.getSelectionModel().getSelectedItem().getDireccion());
    }
}
