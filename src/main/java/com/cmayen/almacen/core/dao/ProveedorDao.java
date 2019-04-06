package com.cmayen.almacen.core.dao;

import com.cmayen.almacen.core.model.Proveedor;
import java.util.List;

public interface ProveedorDao {
    public List<Proveedor> findAllProveedor();
    public Proveedor findById(Long codigoProveedor);
    public void saveProveedor(Proveedor elemento);
    public void deleteProveedor(Proveedor elemento);
    public void updateProveedor(Proveedor elemento);
}
