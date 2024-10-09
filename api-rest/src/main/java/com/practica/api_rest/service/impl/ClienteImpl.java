package com.practica.api_rest.service.impl;

import com.practica.api_rest.model.dao.ClienteDAO;
import com.practica.api_rest.model.entity.Cliente;
import com.practica.api_rest.service.ICliente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteImpl implements ICliente {
    @Autowired
    private ClienteDAO clienteDAO;
    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
        return clienteDAO.save(cliente);
    }
    @Transactional(readOnly = true)
    @Override
    public Cliente findById(Integer id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Cliente cliente) {
        clienteDAO.delete(cliente);
    }
}
