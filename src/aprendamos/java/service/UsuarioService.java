package aprendamos.java.service;

import aprendamos.java.bean.UsuarioDTO;
import aprendamos.java.dao.DAOFactory;
import aprendamos.java.dao.UsuarioDAO;
import java.util.List;

// Un servicio es un componente que pertenece a la capa model de la arquitectura MVC (Model View Controller)
// Por cada caso de uso de nuestro modelo de analisis deberiamos tener un servicio
// Un servicio puede invocar a uno o mas DAOs

public class UsuarioService {

	// Para invocar a un DAO debemos seguir los siguientes pasos

	// 1. Recuperamos una fabrica especifica de daos
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL); // Fuente de Datos MYSQL

	// 2. Le pedimos a la fabrica especifica que nos de todos los daos que necesitemos
	UsuarioDAO objUsuarioDAO = fabrica.getUsuarioDAO();

	// 3. Invocar a nuestras operaciones
	public UsuarioDTO validaUsuario(String vusuario) throws Exception {
		System.out.println("Validamos usando DAO");
		UsuarioDTO objUsuario = null;
		objUsuario = objUsuarioDAO.validaUsuario(vusuario);
		return objUsuario;
	}

	public List<UsuarioDTO> listaPorNombre(String vnombre) throws Exception {
		System.out.println("Lista usando DAO");
		return objUsuarioDAO.listaPorNombre(vnombre);
	}

	public void registraUsuario(UsuarioDTO objUsuario) throws Exception {
		System.out.println("Registrar usando DAO");
		objUsuarioDAO.registra(objUsuario);
	}

	public void modificaUsuario(UsuarioDTO objUsuario) throws Exception {
		System.out.println("Modifca usando DAO");
		objUsuarioDAO.modifica(objUsuario);
	}

	public void eliminaPorUsuario(String vusuario) throws Exception {
		System.out.println("Elimina usando DAO");
		objUsuarioDAO.elimina(vusuario);
	}

}