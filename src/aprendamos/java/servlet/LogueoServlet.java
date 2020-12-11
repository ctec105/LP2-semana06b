package aprendamos.java.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import aprendamos.java.bean.UsuarioDTO;
import aprendamos.java.service.UsuarioService;

public class LogueoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Sobreescribimos el metodo service.
	// Por lo tanto se pierde su funcionalidad por defecto
	// El metodo service atrapa los request sin importar si estos han nacido con
	// metodo post o metodo get

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Recuperamos los datos que llegan en el request
		String vusuario = req.getParameter("usuario");
		String vclave = req.getParameter("clave");

		// Instanciamos nuestro servicio
		UsuarioService servicio = new UsuarioService();

		// LLamamos al método validar usuario
		UsuarioDTO validado = null;
		try {
			validado = servicio.validaUsuario(vusuario);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (validado != null) {
			// Al menos el usuario existe
			 if (validado.getClave().equals(vclave)){
				// Caso de exito: Cargar datos del usuario al request e
				// invocaremos a la pagina de bienvenida
				

				// Verificamos si existe una sesion web
				
				/*
				 * getSession(true):
				 * Si existe una sesion previa, crea una variable que apunta a dicha sesion
				 * Si no existe una sesion previa, crea una nueva
				 * getSession(false): 
				 * Si existe una sesion previa, crea una variable que apunta a dicha sesion
				 * Si no existe una sesion previa, retorna null
				 * */
				if (req.isRequestedSessionIdValid()) {
					// hay una sesion web valida, la referenciamos y luego la matamos
					HttpSession temporal = req.getSession(false);
					temporal.invalidate();
				}
	
				// Creamos la sesión web
				HttpSession lasesion = req.getSession(true);
				System.out.println("id sesion: " + lasesion.getId());
				System.out.println("¿Es nueva la sesion? " + lasesion.isNew());
				System.out.println("Tiempo de expiracion: " + lasesion.getMaxInactiveInterval());
				
				// Cargamos datos del usuario validado en el request
				req.setAttribute("b_usuario1", validado);
	
				// Cargamos datos del usuario validado en la sesión web
				lasesion.setAttribute("b_usuario2", validado);
	
				// Despachamos a la página bienvenida.jsp
				RequestDispatcher rd = req.getRequestDispatcher("/bienvenida.jsp");
				rd.forward(req, res);
			} else {
				req.setAttribute("mensaje", "Lo sentimos, clave incorrecta!");
				req.getRequestDispatcher("/logueo.jsp").forward(req, res);
			}
		} else {
			// Caso de error: Cargamos atributos al request e invocaremos
			// nuevamente a la pagina de logueo

			// Cargamos un mensaje de error al request
			String vmensaje = "Error, el usuario " + vusuario + " es invalido!";
			req.setAttribute("mensaje", vmensaje);

			// Despachamos a logueo.jsp
			RequestDispatcher rd = req.getRequestDispatcher("/logueo.jsp");
			rd.forward(req, res);
		}
	}
}