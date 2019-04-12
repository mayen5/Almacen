package com.cmayen.almacen.core.dao;

import com.cmayen.almacen.core.model.DetalleFactura;
import java.util.List;

public interface DetalleFacturaDao {
    public List<DetalleFactura> findAllDetalleFactura();

    public DetalleFactura findByIdDetalle(Long idDetalle);

    public void saveDetalleFactura(DetalleFactura elemento);

    public void deleteDetalleFactura(DetalleFactura elemento);

    public void updateDetalleFactura(DetalleFactura elemento);
}
