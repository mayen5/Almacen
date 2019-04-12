package com.cmayen.almacen.core.service;

import com.cmayen.almacen.core.dao.DetalleFacturaDao;
import com.cmayen.almacen.core.dao.DetalleFacturaDaoImpl;
import com.cmayen.almacen.core.model.DetalleFactura;
import java.util.List;

public class DetalleFacturaServiceImpl implements DetalleFacturaService {

    private DetalleFacturaDao detalleFacturaDao = new DetalleFacturaDaoImpl();

    @Override
    public List<DetalleFactura> findAllDetalleFactura() {
        return detalleFacturaDao.findAllDetalleFactura();
    }

    @Override
    public DetalleFactura findById(Long idDetalle) {
        return detalleFacturaDao.findByIdDetalle(idDetalle);
    }

    @Override
    public void saveDetalleFactura(DetalleFactura elemento) {
        detalleFacturaDao.saveDetalleFactura(elemento);
    }

    @Override
    public void deleteDetalleFactura(DetalleFactura elemento) {
        detalleFacturaDao.deleteDetalleFactura(elemento);
    }

    @Override
    public void updateDetalleFactura(DetalleFactura elemento) {
        detalleFacturaDao.updateDetalleFactura(elemento);
    }

}
