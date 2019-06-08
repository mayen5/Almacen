package com.cmayen.almacen.core.controller;

import com.cmayen.almacen.core.MainApp;
import com.cmayen.almacen.core.model.Proveedor;
import com.cmayen.almacen.core.reporte.GenerarReporte;
import com.cmayen.almacen.core.service.ProveedorService;
import com.cmayen.almacen.core.service.ProveedorServiceImpl;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    @FXML
    private TextField txtNit;
    @FXML
    private TextField txtRazonSocial;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtPaginaWeb;
    @FXML
    private TextField txtContactoPrincipal;

    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnReporte;
    @FXML
    private Button btnSalir;

    private enum tipo {
        NUEVO, CANCELAR, GUARDAR, NINGUNO, MODIFICAR
    }

    private tipo tipoOperacion = tipo.NINGUNO;

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

    public void salir() throws IOException {
        this.principal.mostrarVentanaPrincipal();
    }

    public void nuevo() {

        switch (tipoOperacion) {
            case NINGUNO:
                this.limpiar();
                this.activarDesactivarControles(true);
                this.btnNuevo.setText("Cancelar");
                this.btnGuardar.setDisable(false);
                this.btnEliminar.setDisable(true);
                this.btnModificar.setDisable(true);
                this.btnReporte.setDisable(true);
                this.btnSalir.setDisable(true);
                this.tipoOperacion = tipo.NUEVO;
                break;

            case NUEVO:
                this.limpiar();
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnSalir.setDisable(false);
                this.tipoOperacion = tipo.NINGUNO;
                break;

            case MODIFICAR:
                this.limpiar();
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnSalir.setDisable(false);
                this.tipoOperacion = tipo.NINGUNO;
                break;
        }
    }

    public void limpiar() {
        txtNit.setText("");
        txtRazonSocial.setText("");
        txtDireccion.setText("");
        txtPaginaWeb.setText("");
        txtContactoPrincipal.setText("");
    }

    public void seleccionar() {
        txtNit.setText(tblProveedor.getSelectionModel().getSelectedItem().getNit());
        txtRazonSocial.setText(tblProveedor.getSelectionModel().getSelectedItem().getRazonSocial());
        txtDireccion.setText(tblProveedor.getSelectionModel().getSelectedItem().getDireccion());
        txtPaginaWeb.setText(tblProveedor.getSelectionModel().getSelectedItem().getPaginaWeb());
        txtContactoPrincipal.setText(tblProveedor.getSelectionModel().getSelectedItem().getContactoPrincipal());
    }

    public void activarDesactivarControles(boolean tipo) {
        if (tipo == true) {
            this.txtNit.setEditable(tipo);
            this.txtRazonSocial.setEditable(tipo);
            this.txtDireccion.setEditable(tipo);
            this.txtPaginaWeb.setEditable(tipo);
            this.txtContactoPrincipal.setEditable(tipo);
        }
    }

    public void guardar() {

        switch (tipoOperacion) {
            case NUEVO:
                try {
                    Proveedor nuevo = new Proveedor();
                    nuevo.setNit(txtNit.getText());
                    nuevo.setRazonSocial(txtRazonSocial.getText());
                    nuevo.setDireccion(txtDireccion.getText());
                    nuevo.setPaginaWeb(txtPaginaWeb.getText());
                    nuevo.setContactoPrincipal(txtContactoPrincipal.getText());
                    this.proveedorService.saveProveedor(nuevo);
                    this.lista.add(nuevo);
                    this.btnNuevo.setText("Nuevo");
                    this.btnGuardar.setDisable(true);
                    this.btnEliminar.setDisable(false);
                    this.btnModificar.setDisable(false);
                    this.btnReporte.setDisable(false);
                    this.btnSalir.setDisable(false);
                    JOptionPane.showMessageDialog(null, "Registro almacenado");
                    this.activarDesactivarControles(false);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error en el registro de los datos!");
                }
                break;

            case MODIFICAR:
                try {
                    Proveedor proveedor = tblProveedor.getSelectionModel().getSelectedItem();
                    proveedor.setNit(txtNit.getText());
                    proveedor.setRazonSocial(txtRazonSocial.getText());
                    proveedor.setDireccion(txtDireccion.getText());
                    proveedor.setPaginaWeb(txtPaginaWeb.getText());
                    proveedor.setContactoPrincipal(txtContactoPrincipal.getText());
                    this.proveedorService.updateProveedor(proveedor);
                    this.lista.set(tblProveedor.getSelectionModel().getSelectedIndex(), proveedor);
                    JOptionPane.showMessageDialog(null, "Registro Actualizado!");
                    this.btnNuevo.setText("Nuevo");
                    this.btnGuardar.setDisable(true);
                    this.btnEliminar.setDisable(false);
                    this.btnModificar.setDisable(false);
                    this.btnReporte.setDisable(false);
                    this.btnSalir.setDisable(false);
                    this.activarDesactivarControles(false);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error en el registro de los datos!");
                }

                break;
        }

        this.tipoOperacion = tipo.NINGUNO;
        this.limpiar();

    }

    public void modificar() {
        if (this.tblProveedor.getSelectionModel().getSelectedItem() != null) {
            this.activarDesactivarControles(true);
            this.tipoOperacion = tipo.MODIFICAR;
            this.btnNuevo.setText("Cancelar");
            this.btnGuardar.setDisable(false);
            this.btnEliminar.setDisable(true);
            this.btnModificar.setDisable(true);
            this.btnReporte.setDisable(true);
            this.btnSalir.setDisable(true);

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro!");
        }
    }

    public void eliminar() {
        if (this.tblProveedor.getSelectionModel().getSelectedItem() != null) {
            try {
                Proveedor proveedor = tblProveedor.getSelectionModel().getSelectedItem();
                
                
                int respuesta =JOptionPane.showConfirmDialog(null, "Desea eliminar el Proveedor" + tblProveedor.getSelectionModel().getSelectedItem().getRazonSocial()+"?", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (JOptionPane.YES_OPTION == respuesta) {
                    this.proveedorService.deleteProveedor(proveedor);
                    int index = this.tblProveedor.getSelectionModel().getSelectedIndex();
                    this.lista.remove(index);
                    JOptionPane.showMessageDialog(null, "Registro Eliminado!");
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error en el registro de los datos!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro!");
        }
    }
    
    public void mostrarReporte(){
        Map parametros = new HashMap();
        parametros.put("_codigoProveedor", tblProveedor.getSelectionModel()
                .getSelectedItem().getCodigoProveedor());
        GenerarReporte.getInstancia()
                .mostrarReporte("Reporte de Proveedores", "ReporteProveedores.jrxml", parametros);
    }

}
