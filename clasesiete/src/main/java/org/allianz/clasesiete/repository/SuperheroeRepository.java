package org.allianz.clasesiete.repository;

import java.util.List;
import org.allianz.clasesiete.models.Superheroe;

public interface SuperheroeRepository {
	public void add(Superheroe heroe);
	public List<Superheroe> findAll();
}
