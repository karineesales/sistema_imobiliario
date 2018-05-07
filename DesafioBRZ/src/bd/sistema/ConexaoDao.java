package bd.sistema;

import java.sql.*;

public class ConexaoDao {

	public  Connection conector() {
		java.sql.Connection conexao = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/imobiliaria_bd";
		String user = "root";
		String password = "root";
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
		}catch(Exception e) {
			return null;
		}
		
		
	}
	
}
