package org.allianz.claseseis.services;

import org.allianz.claseseis.models.Cliente;
import org.allianz.claseseis.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteMockService implements ClienteService {
	
	ClienteRepository repository;
	
	public ClienteMockService(ClienteRepository repo) {
		this.repository = repo;
	}

	@Override
	public Cliente findById(int id) {
		return this.repository.findById(id);
		/*Cliente c = new Cliente(1,"DOCUMENTO","Juan","Perez");
		c.setId(id);
		c.getNombre();
		c.setDeuda(1222);
		return c;*/
	}



}
