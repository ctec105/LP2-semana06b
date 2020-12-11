package aprendamos.java.dao;

import java.util.List;

import aprendamos.java.bean.UsuarioDTO;

public interface UsuarioDAO {

	public abstract UsuarioDTO validaUsuario(String vusuario) throws Exception;

	public abstract List<UsuarioDTO> listaPorNombre(String vnombre) throws Exception;

	public abstract void registra(UsuarioDTO objUsuario) throws Exception;

	public abstract void modifica(UsuarioDTO objUsuario) throws Exception;

	public abstract void elimina(String vusuario) throws Exception;

}