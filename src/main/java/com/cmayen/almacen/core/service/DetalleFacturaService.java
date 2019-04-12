package com.cmayen.almacen.core.service;

import com.cmayen.almacen.core.model.DetalleFactura;
import java.util.List;

public interface DetalleFacturaService {

    public List<DetalleFactura> findAllDetalleFactura();

    public DetalleFactura findById(Long idDetalle);

    public void saveDetalleFactura(DetalleFactura elemento);

    public void deleteDetalleFactura(DetalleFactura elemento);

    public void updateDetalleFactura(DetalleFactura elemento);
}
