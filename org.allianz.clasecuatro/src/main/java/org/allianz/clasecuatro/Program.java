package org.allianz.clasecuatro;

import java.sql.*;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hola Mundo Maven....");
		System.out.println("Ejemplo de Conexion con Base De Datos");
		String url = "jdbc:sqlite:sample.db";
		try {
			Connection connection = DriverManager.getConnection(url);
			try {
				System.out.println("Conectado a la base de datos "+ url);
	
				//Creo una tabla si no existe
				String sqlCreateTable = "CREATE TABLE Nombre(valor text not null)";
				Statement sql = connection.createStatement();
				sql.execute(sqlCreateTable);
				System.out.println("Tabla Nombre creada");
				
				String sqlInsert = "INSERT INTO Nombre (valor) values (?)";
				PreparedStatement sql2 = connection.prepareStatement(sqlInsert);
				sql2.setString(1,"Pedro");
				sql2.executeUpdate();
				System.out.println("Datos Insertados");
				
				String sqlSelect = "Select valor from Nombre";
				Statement sql3 = connection.createStatement();
				ResultSet res = sql3.executeQuery(sqlSelect);
				while (res.next()) {
					String nombre = res.getString("valor");
					System.out.println(nombre);
				}
				
			}finally {
				System.out.println("Cerrando la conexion");
				connection.close();
			}			
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
		}	
		
	}

}
