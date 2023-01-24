package org.allianz.curso.modelo;

public class Cliente {
	private String nombre;
	private String apellido;
	private int prima = 1000;  //Inicializo la variable al momento de declarala (valor por defecto)
	private int riesgo;
	
	public String getApellido() {
		return apellido;
	}

	//public void setApellido(String apellido) {
	//	this.apellido = apellido;
	//}

	//Getter
	public String getNombre() {
		return this.nombre;
	}
	
	//Setter
	//public void setNombre(String valor) {
	//	this.nombre = valor;
	//}
	
	public String getNombreCompleto() {
		return this.nombre + " " + this.apellido;
	}
	
	//constructor
	public Cliente(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.setRiesgo(0);
	}

	public int getRiesgo() {
		return riesgo;
	}

	public void setRiesgo(int riesgo) {
		if ((riesgo<=100) && (riesgo>=0)) {
			this.riesgo = riesgo;	
		}else {
			throw new Error("El riesgo esta entre 0 y 100");
		}
	}

	public int getPrima() {
		return prima;
	}

	public void setPrima(int prima) {
		this.prima = prima;
	}

	//logica de negocios
    public int calcularCuotaMensual() {
    	
    	return  (this.riesgo>0) ? (this.getPrima() + (this.getPrima() * 1/this.getRiesgo())) : this.getPrima();		 
    	/*if (this.riesgo>0) {
    		return (this.getPrima() + (this.getPrima() * 1/this.getRiesgo()))
    	}
    	else {
    		return this.getPrima();
    	}*/
    }
	
}
