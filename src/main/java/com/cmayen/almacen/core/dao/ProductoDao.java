package com.cmayen.almacen.core.dao;

import com.cmayen.almacen.core.model.Producto;
import java.util.List;

public interface ProductoDao {
    public List<Producto> findAllProducto();
    public Producto findById(Long codigoProducto);
    public void saveProducto(Producto elemento);
    public void deleteProducto(Producto elemento);
    public void updateProducto(Producto elemento);
}
