package org.allianz.claseseis.repositories;

import org.allianz.claseseis.models.Cliente;
import org.springframework.stereotype.*;

@Service
public class ClienteMockRepository implements ClienteRepository {

	@Override
	public Cliente findById(int id) {
		Cliente c = new Cliente(1,"DOCUMENTO","Juan","Perez");
		c.setId(id);
		c.getNombre();
		c.setDeuda(1222);
		return c;	
	}

}
