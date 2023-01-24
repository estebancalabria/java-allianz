package org.allianz.clasedos.controller;

public interface AseguradoraController {
	public RespuestaHttp asegurar(String documento);
	public RespuestaHttp calcularDeuda(int numeroCliente);
	public RespuestaHttp pagar(int numeroCliente, double monto);
}
