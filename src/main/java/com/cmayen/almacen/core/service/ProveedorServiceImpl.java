package com.cmayen.almacen.core.service;

import com.cmayen.almacen.core.dao.ProveedorDao;
import com.cmayen.almacen.core.dao.ProveedorDaoImpl;
import com.cmayen.almacen.core.model.Proveedor;
import java.util.List;

public class ProveedorServiceImpl implements ProveedorService{

    private ProveedorDao proveedorDao = new ProveedorDaoImpl();
    
    @Override
    public List<Proveedor> findAllProveedor() {
        return proveedorDao.findAllProveedor();
    }

    @Override
    public Proveedor findById(Long codigoProveedor) {
        return proveedorDao.findById(codigoProveedor);
    }

    @Override
    public void saveProveedor(Proveedor elemento) {
        proveedorDao.saveProveedor(elemento);
    }

    @Override
    public void deleteProveedor(Proveedor elemento) {
        proveedorDao.deleteProveedor(elemento);
    }

    @Override
    public void updateProveedor(Proveedor elemento) {
        proveedorDao.updateProveedor(elemento);
    }
    
}
