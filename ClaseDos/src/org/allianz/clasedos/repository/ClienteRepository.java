package org.allianz.clasedos.repository;

import java.util.*;
import org.allianz.clasedos.model.Cliente;

public interface ClienteRepository {
     public void save(Cliente cliente);
     public void update(Cliente cliente);
     public void delete(int id);
     public Cliente findById(int id);   
     public Cliente findByNumerocl(int numerocl);
     public List<Cliente> findAll();
}
