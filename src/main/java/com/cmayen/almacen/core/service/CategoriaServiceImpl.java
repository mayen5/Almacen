package com.cmayen.almacen.core.service;

import com.cmayen.almacen.core.dao.CategoriaDao;
import com.cmayen.almacen.core.dao.CategoriaDaoImpl;
import com.cmayen.almacen.core.model.Categoria;
import java.util.List;

public class CategoriaServiceImpl implements CategoriaService{

    private CategoriaDao categoriaDao = new CategoriaDaoImpl();
    @Override
    public List<Categoria> findAllCategoria() {
        return categoriaDao.findAllCategoria();
    }

    @Override
    public Categoria findById(Long codigoCategoria) {
        return categoriaDao.findById(codigoCategoria);
    }

    @Override
    public void saveCategoria(Categoria elemento) {
        categoriaDao.saveCategoria(elemento);
    }

    @Override
    public void deleteCategoria(Categoria elemento) {
        categoriaDao.deleteCategoria(elemento);
    }

    @Override
    public void updateCategoria(Categoria elemento) {
        categoriaDao.updateCategoria(elemento);
    }
    
}
