package org.allianz.clasesiete.services;

import java.util.List;
import org.allianz.clasesiete.models.Superheroe;

public interface SuperheroeService {
	public void agregar(Superheroe heroe);
	public List<Superheroe> listarTodos();
}
