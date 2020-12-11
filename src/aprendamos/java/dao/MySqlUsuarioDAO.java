package aprendamos.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import aprendamos.java.bean.UsuarioDTO;
import aprendamos.java.util.MySqlDbConn;
import java.util.*;

// DAO es un patron de diseño que nos permite acceder a diferentes origenes de datos
// Implementaremos este patron creando una clase y una interface DAO
// Por cada entidad de nuestro modelo de datos, normalmente tendremos un DAO
// La clase DAO tendra todas las operaciones que necesitemos realizar sobre nuestra entidad

public class MySqlUsuarioDAO implements UsuarioDAO {

	@Override
	public UsuarioDTO validaUsuario(String vusuario) throws Exception {
		UsuarioDTO objUsuario = null;
		// Obtener la conexióna a bd
		Connection cn = MySqlDbConn.obtenerConexion();
		// Definimos la sentencia a ejecutar
		String sql = "select * from tbusuario where usuario = ?";
		// La preparamos
		PreparedStatement st = cn.prepareStatement(sql);
		// Asignamos valores a las interrogantes
		st.setString(1, vusuario);
		// Ejecutamos la sentencia
		ResultSet rs = st.executeQuery();
		// Recuperamos los valores
		if (rs.next()) {
			// Caso de exito, existe el usuario
			objUsuario = new UsuarioDTO();
			objUsuario.setUsuario(rs.getString(1));
			objUsuario.setClave(rs.getString(2));
			objUsuario.setNombre(rs.getString(3));
			objUsuario.setFecnac(rs.getDate(4));
			objUsuario.setDireccion(rs.getString(5));
			objUsuario.setDistrito(rs.getString(6));
			objUsuario.setTelefono(rs.getString(7));
		}
		cn.close();
		return objUsuario;
	}

	@Override
	public List<UsuarioDTO> listaPorNombre(String vnombre) throws Exception {
		List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
		// Obtener la conexión
		Connection cn = MySqlDbConn.obtenerConexion();
		// Definimos la sentencia a ejecutar
		String sql = "select * from tbusuario where nombre like ?";
		// La preparamos
		PreparedStatement st = cn.prepareStatement(sql);
		// Asignamos valores a las interrogantes
		st.setString(1, "%" + vnombre + "%");
		// Ejecutamos la sentencia
		ResultSet rs = st.executeQuery();
		// Recuperamos los valores
		while (rs.next()) {
			// Caso de exito, existe el usuario
			UsuarioDTO objUsuario = new UsuarioDTO();
			objUsuario.setUsuario(rs.getString(1));
			objUsuario.setClave(rs.getString(2));
			objUsuario.setNombre(rs.getString(3));
			objUsuario.setFecnac(rs.getDate(4));
			objUsuario.setDireccion(rs.getString(5));
			objUsuario.setDistrito(rs.getString(6));
			objUsuario.setTelefono(rs.getString(7));
			// Añadimos a la lista
			usuarios.add(objUsuario);
		}
		// Cerrar la conexión
		cn.close();
		return usuarios;
	}

	@Override
	public void registra(UsuarioDTO objUsuario) throws Exception {
		// Obtenemos la conexión
		Connection cn = MySqlDbConn.obtenerConexion();
		// Definimos la sentencia a ejecutar
		String sql = "insert into tbusuario(usuario,clave,nombre,fecnac,direccion,distrito,telefono) "
				+ " values(?,?,?,?,?,?,?)";
		// La preparamos
		PreparedStatement st = cn.prepareStatement(sql);
		// Asignamos valores a las interrogantes
		st.setString(1, objUsuario.getUsuario());
		st.setString(2, objUsuario.getClave());
		st.setString(3, objUsuario.getNombre());
		java.sql.Date laFecha = new java.sql.Date(objUsuario.getFecnac().getTime());
		st.setDate(4, laFecha);
		st.setString(5, objUsuario.getDireccion());
		st.setString(6, objUsuario.getDistrito());
		st.setString(7, objUsuario.getTelefono());
		// Ejecutamos la sentencia
		st.executeUpdate();
		// Cerrar la conexión
		cn.close();
	}

	@Override
	public void modifica(UsuarioDTO objUsuario) throws Exception {
		// Obtenemos la conexión
		Connection cn = MySqlDbConn.obtenerConexion();
		// Definimos la sentencia a ejecutar
		String sql = "update tbusuario set clave=?,nombre=?,fecnac=?,direccion=?,distrito=?,telefono=? where usuario=?";
		// La preparamos
		PreparedStatement st = cn.prepareStatement(sql);
		// Asignamos valores a las interrogantes
		st.setString(1, objUsuario.getClave());
		st.setString(2, objUsuario.getNombre());
		st.setDate(3, new java.sql.Date(objUsuario.getFecnac().getTime()));
		st.setString(4, objUsuario.getDireccion());
		st.setString(5, objUsuario.getDistrito());
		st.setString(6, objUsuario.getTelefono());
		st.setString(7, objUsuario.getUsuario());
		// Ejecutamos la sentencia
		st.executeUpdate();
		// Cerrar la conexión
		cn.close();
	}

	@Override
	public void elimina(String vusuario) throws Exception {
		// Obtenemos la conexión
		Connection cn = MySqlDbConn.obtenerConexion();
		// Definimos la sentencia a ejecutar
		String sql = "delete from tbusuario where usuario = ?";
		// La preparamos
		PreparedStatement st = cn.prepareStatement(sql);
		// Asignamos valores a las interrogantes
		st.setString(1, vusuario);
		// Ejecutamos la sentencia
		st.executeUpdate();
		// Cerrar la conexión
		cn.close();
	}

}