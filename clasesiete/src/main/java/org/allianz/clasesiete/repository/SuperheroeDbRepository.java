package org.allianz.clasesiete.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.allianz.clasesiete.models.Superheroe;
import org.springframework.stereotype.Service;

@Service
public class SuperheroeDbRepository implements SuperheroeRepository {

	private String url = "jdbc:sqlite:allianz.db";

	public SuperheroeDbRepository() {
		try {
			Connection connection = DriverManager.getConnection(url);
			try {
				String createTable = "CREATE TABLE IF NOT EXISTS Superheroe(" + "   id integer PRIMARY KEY,"
						+ "   nombre text not null, " + "   alterego text not null, " + "   poder integer NOT NULL)";
				Statement sql = connection.createStatement();
				sql.execute(createTable);
			} finally {
				connection.close();
			}
		} catch (Exception ex) {
			throw new Error(ex.getMessage());
		}
	}

	@Override
	public void add(Superheroe heroe) {
		try {
			Connection connection = DriverManager.getConnection(url);
			try {
				String insert = "INSERT INTO Superheroe (nombre,alterego,poder) values (?,?,?)";
				PreparedStatement statement = connection.prepareStatement(insert);
				statement.setString(1, heroe.getNombre());
				statement.setString(2, heroe.getAlterego());
				statement.setInt(3, heroe.getPoder());
				statement.executeUpdate();
			} finally {
				connection.close();
			}
		} catch (Exception ex) {
			throw new Error(ex.getMessage());
		}
	}

	@Override
	public List<Superheroe> findAll() {
		try {
			Connection connection = DriverManager.getConnection(url);
			try {
				List<Superheroe> result = new ArrayList<Superheroe>();

				String sqlSelect = "Select id,nombre,alterego,poder from Superheroe";
				Statement sql = connection.createStatement();
				ResultSet resultSet = sql.executeQuery(sqlSelect);
				while (resultSet.next()) {
					Superheroe c = new Superheroe(resultSet.getInt("id"), resultSet.getString("nombre"),
							resultSet.getString("altergo"), resultSet.getInt("poder"));
					result.add(c);
				}

				return result;
			} finally {
				connection.close();
			}
		} catch (Exception ex) {
			throw new Error(ex.getMessage());
		}
	}

}
