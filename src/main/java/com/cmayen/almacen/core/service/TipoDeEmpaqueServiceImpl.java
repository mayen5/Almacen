package com.cmayen.almacen.core.service;

import com.cmayen.almacen.core.dao.TipoDeEmpaqueDao;
import com.cmayen.almacen.core.dao.TipoDeEmpaqueDaoImpl;
import com.cmayen.almacen.core.model.TipoDeEmpaque;
import java.util.List;

public class TipoDeEmpaqueServiceImpl implements TipoDeEmpaqueService{

    private TipoDeEmpaqueDao tipoDeEmpaqueDao = new TipoDeEmpaqueDaoImpl();
    
    @Override
    public List<TipoDeEmpaque> findAllTipoDeEmpaque() {
        return tipoDeEmpaqueDao.findAllTipoDeEmpaque();
    }

    @Override
    public TipoDeEmpaque findById(Long codigoEmpaque) {
        return tipoDeEmpaqueDao.findById(codigoEmpaque);
    }

    @Override
    public void saveTipoDeEmpaque(TipoDeEmpaque elemento) {
        tipoDeEmpaqueDao.saveTipoDeEmpaque(elemento);
    }

    @Override
    public void deleteTipoDeEmpaque(TipoDeEmpaque elemento) {
        tipoDeEmpaqueDao.deleteTipoDeEmpaque(elemento);
    }

    @Override
    public void updateTipoDeEmpaque(TipoDeEmpaque elemento) {
        tipoDeEmpaqueDao.updateTipoDeEmpaque(elemento);
    }
    
}
