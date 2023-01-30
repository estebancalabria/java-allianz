package org.allianz.claseseis.controllers;

import java.sql.*;
import org.allianz.claseseis.models.*;
import org.allianz.claseseis.services.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class AseguradoraController {
	
	private ClienteService clienteService;
	
	AseguradoraController(ClienteService clienteService){
		this.clienteService = clienteService;
		
		/*try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:allianz.db");
			try {
				String createTable = "CREATE TABLE IF NOT EXISTS Cliente(" +
									 "   id integer PRIMARY KEY," +
									 "   documento text not null,"+
									 "   numerocl integer NOT NULL," +
									 "   nombre text not null, " +
									 "   apellido text not null, "+
									 "   deuda real not null,"+
									 "   saldo real not null)";
				Statement sql = connection.createStatement();
				sql.execute(createTable);
			}finally {
				connection.close();
			}
		}
		catch (Exception ex) {
			throw new Error(ex.getMessage());
		}*/
	}

	@RequestMapping(value = "cliente", method = RequestMethod.GET )
	public Cliente getCliente(@RequestParam int id) {
		return this.clienteService.findById(id);
	}
}
