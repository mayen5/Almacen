package com.cmayen.almacen.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
@NamedQueries(
    {
        @NamedQuery(name="Producto.findAll", query="select p from Producto p"),
        @NamedQuery(name="Producto.findAllOrderById", query = "select p from Producto p order by p.codigoProducto"),
        @NamedQuery(name="Producto.findByCodigoProducto", query = "select p from Producto p where p.codigoProducto = ?1")
    }
)
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_producto")
    private Long codigoProducto;
    @Column(name = "codigo_categoria")
    private Long codigoCategoria;
    @Column(name = "codigo_empaque")
    private Long codigoEmpaque;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio_unitario")
    private Double precioUnitario;
    @Column(name = "precio_por_docena")
    private Double precioPorDocena;
    @Column(name = "precio_por_mayor")
    private Double precioPorMayor;
    @Column(name = "existencia")
    private Integer existencia;
    @Column(name = "imagen")
    private String imagen;

    public Producto() {
    }

    public Producto(Long codigoProducto, Long codigoCategoria, Long codigoEmpaque, String descripcion, Double precioUnitario, Double precioPorDocena, Double precioPorMayor, Integer existencia, String imagen) {
        this.codigoProducto = codigoProducto;
        this.codigoCategoria = codigoCategoria;
        this.codigoEmpaque = codigoEmpaque;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.precioPorDocena = precioPorDocena;
        this.precioPorMayor = precioPorMayor;
        this.existencia = existencia;
        this.imagen = imagen;
    }

    public Long getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Long codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Long getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Long codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Long getCodigoEmpaque() {
        return codigoEmpaque;
    }

    public void setCodigoEmpaque(Long codigoEmpaque) {
        this.codigoEmpaque = codigoEmpaque;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioPorDocena() {
        return precioPorDocena;
    }

    public void setPrecioPorDocena(Double precioPorDocena) {
        this.precioPorDocena = precioPorDocena;
    }

    public Double getPrecioPorMayor() {
        return precioPorMayor;
    }

    public void setPrecioPorMayor(Double precioPorMayor) {
        this.precioPorMayor = precioPorMayor;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    

}
