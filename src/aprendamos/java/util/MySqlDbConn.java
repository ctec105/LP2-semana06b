package aprendamos.java.util;

import java.sql.*;

public class MySqlDbConn {

	/*
	 * Cargamos el driver de Mysql. Lo hacemos dentro de un bloque static ya que
	 * un bloque static se llama automáticamente al cargarse la clase a la
	 * memoria y a diferencia de un constructor que se llama por cada objeto,
	 * éste se llama una sola vez para toda la clase
	 */
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection obtenerConexion() {
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/lp2db?serverTimezone=UTC", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}

}