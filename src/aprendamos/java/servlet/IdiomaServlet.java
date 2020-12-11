package aprendamos.java.servlet;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

public class IdiomaServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperamos el idioma y/o país seleccionado por el usuario
		String vidioma = request.getParameter("idioma");
		String vpais = request.getParameter("pais");
		
		// En Java, podemos representar un idioma y/o páis utilizando la clase Locale
		Locale locale = new Locale(vidioma);
		
		if (vpais != null){
			locale = new Locale(vidioma, vpais);
		}
		
		// Utilizando el Locale, indicamos a JSTL cuál es el idioma/país seleccionado por el usuario
		// Esta información lo almacenamos en la sesión web
		HttpSession lasesion = request.getSession(false);
		Config.set(lasesion, Config.FMT_LOCALE, locale);
		
		// Invocamos finalmente a la página de bienvenida
		request.getRequestDispatcher("/bienvenida.jsp").forward(request, response);
	}
}