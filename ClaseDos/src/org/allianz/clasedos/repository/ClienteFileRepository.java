package org.allianz.clasedos.repository;

import java.util.*;
import java.util.stream.Stream;

import org.allianz.clasedos.model.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class ClienteFileRepository implements ClienteRepository {

	@Override
	public void save(Cliente cliente) {
		List<String> datos = new ArrayList<String>();
		datos.add(Integer.toString(cliente.getId()));
		datos.add(Integer.toString(cliente.getNumerocl()));
		datos.add(cliente.getDocumento());
		datos.add(cliente.getNombre());
		datos.add(cliente.getApellido());
		datos.add(Double.toString(cliente.getDeuda()));
		datos.add(Double.toString(cliente.getSaldo()));
			
		try {
			new File("./clientes").mkdir();
			Files.write(Paths.get("./clientes/"+cliente.getId()+".txt"), datos);
		} catch (IOException e) {
			throw new Error(e.getMessage());
		}
	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente findById(int id) {
		try {
			List<String> datos = Files.readAllLines(Paths.get("./clientes/"+id+".txt"));
			Cliente c = new Cliente(
					Integer.parseInt(datos.get(1)),
					datos.get(2), 
					datos.get(3), 
					datos.get(4));
			c.setId(Integer.parseInt(datos.get(0)));
			c.setDeuda(Double.parseDouble(datos.get(5)));
			c.setSaldo(Double.parseDouble(datos.get(6)));
			return c;
		} catch (IOException e) {
			throw new Error(e.getMessage());
		}
	}

	@Override
	public Cliente findByNumerocl(int numerocl) {
		return this.findAll().stream().filter(c -> c.getNumerocl()==numerocl).findFirst().orElseThrow();
	}

	@Override
	public List<Cliente> findAll() {
		List<Cliente> result = new ArrayList<Cliente>();
		try {
			Stream<Path> archivos = Files.list(Paths.get("./clientes/"));
			archivos.forEach( p->{
				try {
					List<String> datos = Files.readAllLines(p);
					Cliente c = new Cliente(
							Integer.parseInt(datos.get(1)),
							datos.get(2), 
							datos.get(3), 
							datos.get(4));
					c.setId(Integer.parseInt(datos.get(0)));
					c.setDeuda(Double.parseDouble(datos.get(5)));
					c.setSaldo(Double.parseDouble(datos.get(6)));
					result.add(c);
				}catch (IOException e) {
					throw new Error(e.getMessage());
				}
				
			});
			archivos.close();
		} catch (IOException e) {
			throw new Error(e.getMessage());
		}
		return result;
	}

}
