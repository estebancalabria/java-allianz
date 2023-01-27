package org.allianz.clasedos;

import java.util.*;
import java.util.function.Consumer;

import  org.allianz.clasedos.model.*;
import org.allianz.clasedos.repository.*;
import org.allianz.clasedos.service.*;


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente("1234","Juan","Perez"));
        clientes.add(new Cliente("3443","Jordi","Donada"));
        clientes.add(new Cliente("5454","Esteban","Calabria"));
        clientes.add(new Cliente("6545","Wendy","Calderon"));
        
        System.out.println("Mis Clientes Son");
        /*for (int i=0; i<clientes.size(); i++) {
        	Cliente cli = clientes.get(i);
        	System.out.println(cli);
        }*/
        
        //foreach
        /*for (Cliente cliente:clientes) {
        	System.out.println(cliente);
        }*/
        
        //Expresion Lambda
        //clientes.forEach( (cli) -> { System.out.println(cli); } );
        
        //Expresion Lambda - Forma Alternativa
        //clientes.forEach(System.out::println);
        
        //Expresion Lambda - Procedimiento en variable;
        /*Consumer<Cliente> func = (cli) -> { System.out.println(cli); }; 
        clientes.forEach(func);*/
        
		//Aqui estoy declarando una variable del tipo de la interfaz
		//pero al momento de instanciar utilizo una clase que implementa la interfaz
        /*ClienteRepository repo = new ClienteMockRepository();        
        repo.save(new Cliente("1234","Elon","Musk"));
        repo.save(new Cliente("3434","Lionel","Messi"));
        repo.save(new Cliente("6554","Fernando","Alonso"));
        repo.save(new Cliente("3232","El","Chiringuito"));
        
        System.out.println("Todos mis clientes:");
        repo.findAll().forEach(System.out::println);
        
        System.out.println("El cliente con Id:2");
        Cliente c2 = repo.findById(2);
        System.out.println(c2);
        
        System.out.println("El ciente con numero 102");
        Cliente cn102 = repo.findByNumerocl(102);
        System.out.println(cn102);
        
        System.out.println("Trando de recuperar un cliente que no existe");
        try {
        	Cliente c = repo.findByNumerocl(4379437);
        	System.out.println("(Esta linea no deberia mostrarse nunca) Ups.. el cliente existe!");
        }catch(Error e) {
        	System.err.println("Efectivamente el cliente no existe");
        	System.err.println(e.getMessage());
        }
        
        System.out.println("Vamos a eliminar al cliente con ID 4");
        repo.delete(4);
        System.out.println("La lista queda");
        repo.findAll().forEach(System.out::println);*/
		
		/*
		//Creo unos datos por defecto para probar el servicio
		ClienteMockRepository repo = new ClienteMockRepository(); 
		//Tambien es valido hacer
		//ClienteRepository repo = new ClienteMockRepository();
		Cliente conDeuda = new Cliente("DNI-1","Pedro","Moroso");
		conDeuda.setDeuda(1000);
		repo.save(conDeuda);
		
		Cliente sinDeuda = new Cliente("DNI-2", "Juan", "Aldia");
		sinDeuda.setSaldo(100); 
		repo.save(sinDeuda);

		//Estoy "inyectando la dependecia" entre el servicio y el repositorio
		AseguradoraServiceInterface service = new AseguradoraService(repo);
		System.out.println("La deuda de " + conDeuda);
		System.out.println(service.calcularDeuda(100));
		System.out.println("La deuda de " + sinDeuda);
		System.out.println(service.calcularDeuda(101));
		
		System.out.println("Ahora ambos pagan 1000 euros");
		service.pagar(100, 1000);
		service.pagar(101, 1000);
		System.out.println(conDeuda);
		System.out.println("Deuda: " + service.calcularDeuda(100) + " Saldo: " + service.saldoAFavor(100));
		System.out.println(sinDeuda);
		System.out.println("Deuda: " + service.calcularDeuda(101) + " Saldo: " + service.saldoAFavor(101));
		*/
		
		/*ClienteRepository repo = new ClienteFileRepository();
		//repo.save(new Cliente("DNI1","Juan", "Perez"));
		//Cliente c = repo.findById(0);
		//System.out.println(c);
		repo.findAll().forEach(System.out::println);*/
		
		ClienteRepository repo = new ClienteDbRepository();
		//Cliente elon = new Cliente("1234","Elon","Musk");
		//repo.save(elon);
		
		//Cliente mark = new Cliente(302,"534","Mark","Zuckemberg");
		//repo.save(mark);
		
		//repo.findAll().forEach(System.out::println);
		try {
		Cliente c = repo.findById(1);
		System.out.println(c);
		}catch(Error e) {
			if (e.getMessage().contains("Not FOUND")) {
				System.out.println("N");
			}
		}
		
		System.out.println("Programa ejecutado Ok");
	}

}
