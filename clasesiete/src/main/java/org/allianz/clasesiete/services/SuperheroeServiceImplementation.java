package org.allianz.clasesiete.services;

import java.util.List;

import org.allianz.clasesiete.models.Superheroe;
import org.allianz.clasesiete.repository.SuperheroeRepository;
import org.springframework.stereotype.Service;

@Service
public class SuperheroeServiceImplementation implements SuperheroeService {

	private SuperheroeRepository repository; 
	
	public SuperheroeServiceImplementation(SuperheroeRepository repo) {
		this.repository = repo;
	}
	
	@Override
	public void agregar(Superheroe heroe) {
		//TODO: Incoporar validaciones y Reglas de Negocio
		if (heroe.getNombre().length()==0) {
			throw new Error("El superheroe debe tener un nombre");
		}
		this.repository.add(heroe);
		
	}

	@Override
	public List<Superheroe> listarTodos() {
		return this.repository.findAll();
	}

}
