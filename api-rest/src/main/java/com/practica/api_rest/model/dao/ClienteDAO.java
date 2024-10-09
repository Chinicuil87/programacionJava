package com.practica.api_rest.model.dao;

import com.practica.api_rest.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {

}
