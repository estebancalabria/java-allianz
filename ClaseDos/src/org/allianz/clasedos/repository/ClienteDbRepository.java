package org.allianz.clasedos.repository;

import java.util.*;
import java.sql.*;

import org.allianz.clasedos.model.Cliente;

public class ClienteDbRepository implements ClienteRepository {
	
	private String url= "jdbc:sqlite:allianz.db";

	public ClienteDbRepository() {
		try {
			Connection connection = DriverManager.getConnection(url);
			try {
				String createTable = "CREATE TABLE IF NOT EXISTS Cliente(" +
									 "   id integer PRIMARY KEY," +
									 "   documento text not null,"+
									 "   numerocl integer NOT NULL," +
									 "   nombre text not null, " +
									 "   apellido text not null, "+
									 "   deuda real not null,"+
									 "   saldo real not null)";
				Statement sql = connection.createStatement();
				sql.execute(createTable);
			}finally {
				connection.close();
			}
		}
		catch (Exception ex) {
			throw new Error(ex.getMessage());
		}
	}
	
	@Override
	public void save(Cliente cliente) {
		try {
			Connection connection = DriverManager.getConnection(url);
			try {
				String insert = "INSERT INTO Cliente (documento, numerocl, nombre, apellido, deuda, saldo) values (?,?,?,?,?,?)";
				PreparedStatement statement = connection.prepareStatement(insert);
				statement.setString(1, cliente.getDocumento());
                statement.setInt(2, cliente.getNumerocl());
                statement.setString(3, cliente.getNombre());
                statement.setString(4, cliente.getApellido());
                statement.setDouble(5, cliente.getDeuda());
                statement.setDouble(6, cliente.getSaldo());
                statement.executeUpdate();
			}finally {
				connection.close();
			}
		}
		catch (Exception ex) {
			throw new Error(ex.getMessage());
		}	
	}

	@Override
	public void update(Cliente cliente) {
		try {
			Connection connection = DriverManager.getConnection(url);
			try {
				String update = "UPDATE Cliente "+
								"SET deuda=?, "+
								"saldo=? "+
								"WHERE id=?";
				PreparedStatement statement = connection.prepareStatement(update);
                statement.setDouble(1, cliente.getDeuda());
                statement.setDouble(2, cliente.getSaldo());
                statement.setInt(3, cliente.getId());
                statement.executeUpdate();
			}finally {
				connection.close();
			}
		}
		catch (Exception ex) {
			throw new Error(ex.getMessage());
		}	
	}

	@Override
	public void delete(int id) {
		try {
			Connection connection = DriverManager.getConnection(url);
			try {
				String delete = "DELETE FROM Cliente WHERE id=?";
				PreparedStatement statement = connection.prepareStatement(delete);
                statement.setInt(1, id);
                statement.executeUpdate();
			}finally {
				connection.close();
			}
		}
		catch (Exception ex) {
			throw new Error(ex.getMessage());
		}	
		
	}

	@Override
	public Cliente findById(int id) {
		try {
			Connection connection = DriverManager.getConnection(url);
			try {
				String sqlSelect = "Select id,documento, numerocl, nombre, apellido, deuda, saldo "+
								   "from Cliente where id="+id;
				Statement sql = connection.createStatement();
				ResultSet resultSet = sql.executeQuery(sqlSelect);
				if (resultSet.next()) {
					Cliente c = new Cliente(
								resultSet.getInt("numerocl"),
								resultSet.getString("documento"),
								resultSet.getString("nombre"),
								resultSet.getString("apellido")
							);
					c.setId(resultSet.getInt("id"));
					c.setDeuda(resultSet.getDouble("deuda"));
					c.setSaldo(resultSet.getDouble("saldo"));
					return c;
				}
				
				throw new Error("Not FOUND");
			}finally {
				connection.close();
			}
		}
		catch (Exception ex) {
			throw new Error(ex.getMessage());
		}			
	}

	@Override
	public Cliente findByNumerocl(int numerocl) {
		try {
			Connection connection = DriverManager.getConnection(url);
			try {
				String sqlSelect = "Select id,documento, numerocl, nombre, apellido, deuda, saldo "+
								   "from Cliente where numerocl="+numerocl;
				Statement sql = connection.createStatement();
				ResultSet resultSet = sql.executeQuery(sqlSelect);
				if (resultSet.next()) {
					Cliente c = new Cliente(
								resultSet.getInt("numerocl"),
								resultSet.getString("documento"),
								resultSet.getString("nombre"),
								resultSet.getString("apellido")
							);
					c.setId(resultSet.getInt("id"));
					c.setDeuda(resultSet.getDouble("deuda"));
					c.setSaldo(resultSet.getDouble("saldo"));
					return c;
				}
				
				throw new Error("Not FOUND");
			}finally {
				connection.close();
			}
		}
		catch (Exception ex) {
			throw new Error(ex.getMessage());
		}			
	}

	@Override
	public List<Cliente> findAll() {
		try {
			Connection connection = DriverManager.getConnection(url);
			try {
				List<Cliente> result = new ArrayList<Cliente>();
                
				String sqlSelect = "Select id,documento, numerocl, nombre, apellido, deuda, saldo "+
								   "from Cliente";
				Statement sql = connection.createStatement();
				ResultSet resultSet = sql.executeQuery(sqlSelect);
				while (resultSet.next()) {
					Cliente c = new Cliente(
								resultSet.getInt("numerocl"),
								resultSet.getString("documento"),
								resultSet.getString("nombre"),
								resultSet.getString("apellido")
							);
					c.setId(resultSet.getInt("id"));
					c.setDeuda(resultSet.getDouble("deuda"));
					c.setSaldo(resultSet.getDouble("saldo"));
					result.add(c);
				}
				
				return result;
			}finally {
				connection.close();
			}
		}
		catch (Exception ex) {
			throw new Error(ex.getMessage());
		}			
	}
}
