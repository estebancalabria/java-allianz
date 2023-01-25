package org.allianz.clasedos.service;

public interface AseguradoraServiceInterface {
	public void asegurar(String documento);
	public double calcularDeuda(int numeroCliente);
	public double saldoAFavor(int numeroCliente);
	public double pagar(int numeroCliente, double monto);
}
