package com.cmayen.almacen.core.service;

import com.cmayen.almacen.core.dao.CompraDao;
import com.cmayen.almacen.core.dao.CompraDaoImpl;
import com.cmayen.almacen.core.model.Compra;
import java.util.List;

public class CompraServiceImpl implements CompraService {

    private CompraDao compraDao = new CompraDaoImpl();

    @Override
    public List<Compra> findAllCompra() {
        return this.compraDao.findAllCompra();
    }

    @Override
    public Compra findById(Long codigoCompra) {
        return this.compraDao.findById(codigoCompra);
    }

    @Override
    public void saveCompra(Compra elemento) {
        this.compraDao.saveCompra(elemento);
    }

    @Override
    public void deleteCompra(Compra elemento) {
        this.compraDao.deleteCompra(elemento);
    }

    @Override
    public void updateCompra(Compra elemento) {
        this.compraDao.updateCompra(elemento);
    }

}
