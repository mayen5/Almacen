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
@Table(name = "tipo_empaque")
@NamedQueries(
    {
        @NamedQuery(name="TipoDeEmpaque.findAll", query="select t from TipoDeEmpaque t"),
        @NamedQuery(name="TipoDeEmpaque.findAllOrderById", query = "select t from TipoDeEmpaque t order by t.codigoEmpaque"),
        @NamedQuery(name="TipoDeEmpaque.findByCodigoTipoDeEmpaque", query = "select t from TipoDeEmpaque t where t.codigoEmpaque = ?1")
    }
)
public class TipoDeEmpaque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_empaque")
    private Long codigoEmpaque;
    @Column(name = "descripcion")
    private String descripcion;

    public TipoDeEmpaque() {
    }

    public TipoDeEmpaque(Long codigoEmpaque, String descripcion) {
        this.codigoEmpaque = codigoEmpaque;
        this.descripcion = descripcion;
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
    
    
}
