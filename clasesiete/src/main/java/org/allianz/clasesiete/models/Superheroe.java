package org.allianz.clasesiete.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class Superheroe {
	@Getter @Setter
	private int id;
	@Getter @Setter
	private String nombre;
	@Getter @Setter
	private String alterego;
	@Getter @Setter
	private int poder;
}
