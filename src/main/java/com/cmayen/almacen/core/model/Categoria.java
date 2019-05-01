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
@Table(name = "categoria")
@NamedQueries(
    {
        @NamedQuery(name="Categoria.findAll", query="select c from Categoria c"),
        @NamedQuery(name="Categoria.findAllOrderById", query = "select c from Categoria c order by c.codigoCategoria"),
        @NamedQuery(name="Categoria.findByCodigoCategoria", query = "select c from Categoria c where c.codigoCategoria = ?1")
    }
)
public class Categoria implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_categoria")
    private Long codigoCategoria;
    @Column(name = "descripcion")
    private String descripcion;

    public Categoria() {
    }

    public Categoria(Long codigoCategoria, String descripcion) {
        this.codigoCategoria = codigoCategoria;
        this.descripcion = descripcion;
    }

    public Long getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Long codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
