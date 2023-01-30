package org.allianz.claseseis.models;

import lombok.*;

@RequiredArgsConstructor
public class Cliente {
	@Getter @Setter
	private int id;
	@Getter @NonNull
	private int numerocl;
	@Getter @NonNull
	private String documento;
	@Getter @NonNull
	private String nombre;
	@Getter @NonNull
	private String apellido;
	@Getter @Setter
	private double saldo;
	@Getter @Setter
	private double deuda;
	
	/*public Cliente(int numeroCl, String documento, String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.numerocl = numeroCl;
	}*/
}
