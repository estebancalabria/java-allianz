package org.allianz.clasedos.model;

public class Cliente {
	private static int PROXIMO_NUMEROCL = 100;
	
	private int id;
	private String documento;
	private int numerocl;
	private String nombre;
	private String apellido;
	private double deuda = 0;
	private double saldo = 0;
	
	public Cliente(String documento, String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.numerocl = Cliente.PROXIMO_NUMEROCL;
		Cliente.PROXIMO_NUMEROCL++;
	}
	
	public Cliente(int numeroCl, String documento, String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.numerocl = numeroCl;
		Cliente.PROXIMO_NUMEROCL = numeroCl + 1;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public int getNumerocl() {
		return numerocl;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
    @Override
    public String toString() {
    	return "("+ this.getNumerocl() +")"
                +  this.getNombre() + " " + this.getApellido() 
                + "- DNI: " + this.getDocumento()
                +"[Deuda: "+ this.getDeuda()+"]";
    	
    }

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
