package com.cmayen.almacen.core.dao;

import com.cmayen.almacen.core.model.Cliente;
import java.util.List;

public interface ClienteDao {

    public List<Cliente> findAllCliente();

    public Cliente findByNit(String nitCliente);

    public void saveCliente(Cliente elemento);

    public void deleteCliente(Cliente elemento);

    public void updateCliente(Cliente elemento);
}
