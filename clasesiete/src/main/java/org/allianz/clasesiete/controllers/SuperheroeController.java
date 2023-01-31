package org.allianz.clasesiete.controllers;

import java.util.List;

import org.allianz.clasesiete.models.Superheroe;
import org.allianz.clasesiete.services.SuperheroeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SuperheroeController {
	
	private SuperheroeService service;
	public SuperheroeController(SuperheroeService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET, value = "listar")
	public ResponseEntity<List<Superheroe>> listar(){
		//return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	    try {
	    	System.out.println("Todo OK");
	    	return ResponseEntity.ok(this.service.listarTodos());
	    }catch(Error ex) {
	    	System.err.println(ex.getMessage());
	    	return ResponseEntity
	    			.internalServerError()
	    			.build();
	    	
	    }
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "agregar")
	public ResponseEntity<Superheroe> agregar(@RequestBody() Superheroe heroe){
		//return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		try {
			this.service.agregar(heroe);
			return ResponseEntity.ok(heroe);
		}catch(Error ex) {
	    	return ResponseEntity
	    			.internalServerError()
	    			.build();
	    	
	    }
	}
}
