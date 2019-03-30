package com.cmayen.almacen.core.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="compra")
public class Compra implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_compra")
    private Long idCompra;
    
    @Column(name="numero_documento")
    private Long numeroDocumento;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="codigo_proveedor")
    private Proveedor proveedor;
    
    @Column(name="fecha")
    private Date fecha;
    
    @Column(name="total")
    private Float total;

    public Compra() {
    }

    public Compra(Long idCompra, Long numeroDocumento, Proveedor proveedor, Date fecha, Float total) {
        this.idCompra = idCompra;
        this.numeroDocumento = numeroDocumento;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.total = total;
    }
    
    
}
