import java.sql.*;

public class Program {

	public static void main(String[] args) {
		System.out.println("Ejemplo de Conexion con Base De Datos");
		String username = "allianz";
		String pass = "Pa55w.rd1234";
		//String url = "jdbc:mysql://mysqlallianz.mysql.database.azure.com:3306/allianz";
		String url = "jdbc:sqlite:sample.db";
		try {
			Connection connection = DriverManager.getConnection(url, username, pass);
			try {
				System.out.println("Conectado a la base de datos "+ url);
	
				//Creo una tabla si no existe
				//String sqlCreateTable = "CREATE TABLE Nombre(valor text not null)";
				//Statement sql = connection.createStatement();
				//sql.execute(sqlCreateTable);
				//System.out.println("Tabla Nombre creada");
				
				/*String sqlInsert = "INSERT INTO Nombre (valor) values (?)";
				PreparedStatement sql = connection.prepareStatement(sqlInsert);
				sql.setString(1,"Pedro");
				sql.executeUpdate();
				System.out.println("Datos Insertados");*/
				
				String sqlSelect = "Select valor from Nombre";
				Statement sql = connection.createStatement();
				ResultSet res = sql.executeQuery(sqlSelect);
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
		
		System.out.println("Finalizando el programa...");
	}
}
