package org.allianz.clasedos.repository;

import java.util.ArrayList;
import java.util.List;

import org.allianz.clasedos.model.Cliente;

public class ClienteMockRepository implements ClienteRepository {
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private int proximo_id = 1;

	@Override
	public void save(Cliente cliente) {
		cliente.setId(this.proximo_id);
		clientes.add(cliente);
		this.proximo_id++;
	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		//??
	}

	@Override
	public void delete(int id) {
		Cliente c = this.findById(id);
		this.clientes.remove(c);
	}

	@Override
	public Cliente findById(int id) {
		/*for (Cliente c:this.clientes) {
			if (c.getId()==id) {
				return c;
			}
		}
		throw new Error("CLIENTE NOT FOUND (ID:"+id+")");*/
		
		Cliente cli = this.clientes.stream()
		  .filter( c -> c.getId()==id).findFirst().orElse(null);

		if (cli==null) { throw new Error("CLIENTE NOT FOUND (ID:"+id+")"); }
		
		return cli;
	}

	@Override
	public Cliente findByNumerocl(int numerocl) {
		/*for (Cliente c:this.clientes) {
			if (c.getNumerocl()==numerocl) {
				return c;
			}
		}
		throw new Error("CLIENTE NOT FOUND (NumeroCl:"+numerocl+")");*/
		
        Cliente cli = this.clientes.stream().filter(c -> c.getNumerocl()==numerocl).findFirst().orElse(null);
        if (cli==null) { throw new Error("Cliente not found (Numerocl"+ numerocl +")");}
        return cli;
	}

	@Override
	public List<Cliente> findAll() {
		return this.clientes;
	}

}
