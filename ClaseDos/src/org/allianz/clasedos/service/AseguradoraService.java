package org.allianz.clasedos.service;

public interface AseguradoraService {
	public void asegurar(String documento);
	public double calcularDeuda(int numeroCliente);
	public double pagar(int numeroCliente, double monto);
}
