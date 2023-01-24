package org.allianz.curso.gui;

import org.allianz.curso.modelo.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bienvenidos a mi primer sistema");
		
		//Los datos de un cliente
		Cliente cliente = new Cliente("Esteban", "Calabria");
		//cliente.setRiesgo(1000); este valor lanza una excepcion
		cliente.setRiesgo(0);
		cliente.setPrima(1000);  //No hace falta porque ya tiene un valor por defecto
		
		//cliente.setNombre("Esteban");
		//cliente.setApellido("Calabria");
		
		
		//Este codigo lo tengo que comentar porque el que hizo la clase cliente 
		//Ahora no quieren que modifiquen el nombre..
		//Cliente referencia = cliente;
		//referencia.setNombre("Juan");

		
		//System.out.println("Hola " + cliente.getNombre() + " " + cliente.getApellido());
		System.out.println("Hola " + cliente.getNombreCompleto());
		
		//Veo un problema: Si el riesgo es cero me va a dar un error
		System.out.println("Usted debe pagar por mes " + cliente.calcularCuotaMensual()); 
		    //+ (cliente.getPrima() + (cliente.getPrima() * 1/cliente.getRiesgo())));
				
		

	}

}
