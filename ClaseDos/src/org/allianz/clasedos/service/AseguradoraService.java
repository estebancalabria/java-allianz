package org.allianz.clasedos.service;

import org.allianz.clasedos.model.Cliente;
import org.allianz.clasedos.repository.ClienteRepository;

public class AseguradoraService implements AseguradoraServiceInterface {

	private ClienteRepository repo;
	
	public AseguradoraService(ClienteRepository repo) {
		//El servicio no hace un "new" del respositorio sino
		//que lo recibe como aprametro desde afuera
		this.repo = repo;
	}
	
	@Override
	public void asegurar(String documento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calcularDeuda(int numeroCliente) {
		Cliente cliente = this.repo.findByNumerocl(numeroCliente);
		//Si la resta es negativa devuelve 0
		return Math.max(cliente.getDeuda() - cliente.getSaldo(), 0);
	}

	@Override
	public double pagar(int numeroCliente, double monto) {
		Cliente cliente = this.repo.findByNumerocl(numeroCliente);	
		
		if (cliente.getDeuda()>=monto) {
			cliente.setDeuda( cliente.getDeuda() - monto);
		}else {
			cliente.setSaldo(cliente.getSaldo() + monto - cliente.getDeuda());
			cliente.setDeuda(0);
		}
		
		return cliente.getDeuda();
	}

	@Override
	public double saldoAFavor(int numeroCliente) {
	     Cliente cliente = this.repo.findByNumerocl(numeroCliente);
	     return cliente.getSaldo() - cliente.getDeuda();
	   
	}
}
