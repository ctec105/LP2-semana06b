/*
 * Created on 01/10/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aprendamos.java.dao;

public abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	public static final int DB2 = 3;
	public static final int SQLSERVER = 4;
	public static final int XML = 5;

	// Existirá un método get por cada DAO que pueda ser creado.
	// Ejemplo: public abstract ArticuloDAO getArticuloDAO();

	// Registramos nuestros daos
	public abstract UsuarioDAO getUsuarioDAO();

	// Nuestro DAOFactory también es un dao
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case MYSQL:
			return new MySqlDAOFactory();
		case SQLSERVER:
			return new SqlDAOFactory();
		case ORACLE:
			return new OracleDAOFactory();
		default:
			return null;
		}
	}

}