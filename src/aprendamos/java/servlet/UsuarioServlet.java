package aprendamos.java.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aprendamos.java.bean.UsuarioDTO;
import aprendamos.java.service.UsuarioService;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuarioServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Instanciamos nuestro servicio
	UsuarioService servicio = new UsuarioService();

	// Sobreescribimos el metodo service.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperamos el parametro operacion del request
		String voperacion = request.getParameter("operacion");
		if (voperacion.equals("lista")) {
			this.lista(request, response);
		}
		if (voperacion.equals("registra")) {
			this.registra(request, response);
		}
		if (voperacion.equals("elimina")) {
			this.elimina(request, response);
		}
		if (voperacion.equals("cargaModifica")) {
			this.cargaModifica(request, response);
		}
		if (voperacion.equals("modifica")) {
			this.modifica(request, response);
		}
	}

	protected void lista(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Recuperamos el parametro nombre
		String vnombre = req.getParameter("nombre");

		// Invocamos a componente de la capa model
		List<UsuarioDTO> usuarios = null;
		try {
			usuarios = servicio.listaPorNombre(vnombre);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Cargamos en el request los usuarios obtenidos
		req.setAttribute("li_usuarios", usuarios);

		// Invocamos a componente de la capa de presentacion utilizando Request Dispatcher
		req.getRequestDispatcher("/listadoDeUsuarios.jsp").forward(req, resp);
	}
	
	protected void registra(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Recuperamos los parametros que llegan del request
		String vnombre = req.getParameter("nombre");
		String vdireccion = req.getParameter("direccion");
		String vdistrito = req.getParameter("distrito");
		String vtelefono = req.getParameter("telefono");
		String vfecnac = req.getParameter("fecnac");
		String vusuario = req.getParameter("usuario");
		String vclave = req.getParameter("clave");

		// Invocamos al componente de la capa model
		List<UsuarioDTO> usuarios = null;
		try {
			// Padamos los valores recuperados del request
			UsuarioDTO objUsuario = new UsuarioDTO();
			objUsuario.setNombre(vnombre);
			objUsuario.setDireccion(vdireccion);
			objUsuario.setDistrito(vdistrito);
			objUsuario.setTelefono(vtelefono);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			objUsuario.setFecnac(sdf.parse(vfecnac)); // Usando sdf convertimos la cadena a un objeto Date
			objUsuario.setUsuario(vusuario);
			objUsuario.setClave(vclave);
			servicio.registraUsuario(objUsuario);
			
			// Listar usuarios
			usuarios = servicio.listaPorNombre("");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Cargamos en el request los usuarios obtenidos
		req.setAttribute("li_usuarios", usuarios);

		// Invocamos a componente de la capa de presentacion utilizando Request Dispatcher
		req.getRequestDispatcher("/listadoDeUsuarios.jsp").forward(req, resp);
	}

	protected void elimina(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Recuperamos el parametro usuario
		String vusuario = req.getParameter("usuario");

		// Invocamos a componente de la capa model
		List<UsuarioDTO> usuarios = null;
		try {
			servicio.eliminaPorUsuario(vusuario);
			
			// Listar usuarios
			usuarios = servicio.listaPorNombre("");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Cargamos en el request los usuarios obtenidos
		req.setAttribute("li_usuarios", usuarios);

		// Invocamos a componente de la capa de presentacion utilizando Request Dispatcher
		req.getRequestDispatcher("/listadoDeUsuarios.jsp").forward(req, resp);
	}

	protected void cargaModifica(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Recuperamos el parametro usuario
		String vusuario = req.getParameter("usuario");

		// Invocamos a componente de la capa model
		UsuarioDTO usuario = null;
		try {
			usuario = servicio.validaUsuario(vusuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Cargamos en el request los usuarios obtenidos
		req.setAttribute("b_usuario", usuario);

		// Invocamos a componente de la capa de presentacion utilizando Request Dispatcher
		req.getRequestDispatcher("/modificaUsuario.jsp").forward(req, resp);
	}

	private void modifica(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Recuperamos los parametros que llegan del request
		String vnombre = req.getParameter("nombre");
		String vdireccion = req.getParameter("direccion");
		String vdistrito = req.getParameter("distrito");
		String vtelefono = req.getParameter("telefono");
		String vfecnac = req.getParameter("fecnac");
		String vusuario = req.getParameter("usuario");
		String vclave = req.getParameter("clave");

		// Invocamos al componente de la capa model
		List<UsuarioDTO> usuarios = null;
		try {
			// Padamos los valores recuperados del request
			UsuarioDTO objUsuario = new UsuarioDTO();
			objUsuario.setNombre(vnombre);
			objUsuario.setDireccion(vdireccion);
			objUsuario.setDistrito(vdistrito);
			objUsuario.setTelefono(vtelefono);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			objUsuario.setFecnac(sdf.parse(vfecnac)); // Usando sdf convertimos la cadena a un objeto Date
			objUsuario.setUsuario(vusuario);
			objUsuario.setClave(vclave);
			servicio.modificaUsuario(objUsuario);
			
			// Listar usuarios
			usuarios = servicio.listaPorNombre("");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Cargamos en el request los usuarios obtenidos
		req.setAttribute("li_usuarios", usuarios);

		// Invocamos a componente de la capa de presentacion utilizando Request Dispatcher
		req.getRequestDispatcher("/listadoDeUsuarios.jsp").forward(req, resp);
	}

}