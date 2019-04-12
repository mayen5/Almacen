package com.cmayen.almacen.core.dao;

import com.cmayen.almacen.core.db.Conexion;
import com.cmayen.almacen.core.model.Cliente;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {

    @Override
    public List<Cliente> findAllCliente() {
        return (List<Cliente>) Conexion.getInstancia().findAll(Cliente.class);
    }

    @Override
    public Cliente findByNit(String nitCliente) {
        return (Cliente)Conexion.getInstancia().findById(Cliente.class, nitCliente);
    }

    @Override
    public void saveCliente(Cliente elemento) {        
        Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteCliente(Cliente elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateCliente(Cliente elemento) {
Conexion.getInstancia().update(elemento);
    }

}
