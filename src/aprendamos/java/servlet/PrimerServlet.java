package aprendamos.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class PrimerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	// se seleccion dop + ctrl + space
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Dentro del doPost");

		// Recuperamos los parametros que llegan desde el jsp
		String vnombre = req.getParameter("nombre");
		String vdireccion = req.getParameter("direccion");
		String vdistrito = req.getParameter("distrito");
		String vsexo = req.getParameter("sexo");
		String vdiversion[] = req.getParameterValues("diversion");

		// Vamos a retornar como respuesta un mensaje de saludo
		// Le estamos indicando al cliente que tipo de dato le vamos a retornar
		resp.setContentType("text/html"); // mime - type con esto ya no se verian los <>
		//resp.setContentType("text/html"); // mime - type con esto saldria con todo esto <>

		PrintWriter salida = resp.getWriter();
		salida.println("<font color=red size=7>");
		salida.println("Sus datos son;)");
		salida.println("</font>");
		salida.println("<br></br>");
		salida.println("Nombre: " + vnombre + " <br/>");
		salida.println("Direccion: " + vdireccion + "<br/>");
		salida.println("Distrito: " + vdistrito + "<br/>");
		if (vsexo.equals("M")) {
			salida.println("Sexo: Masculino" + "<br/>");
		} else {
			salida.println("Sexo: Femenino" + "<br/>");
		}
		salida.println("Diversion: ");
		if (vdiversion != null) {
			for (String ladiversion : vdiversion) {
				salida.println(ladiversion + "<br/>");
			}
		} else {
			salida.println("No seleccionaste nada");
		}
		salida.println("<br/><br/>");
		salida.println("<a href=\"index.htm\"> Retornar<a/>");
		salida.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Dentro del método doGet");

		// Vamos a retornar como respuesta un mensaje de saludo
		// Le estamos indicando al client que tipo de dato le vamos a retornar
		resp.setContentType("text/html"); // mime - type con esto ya no se verian los <>
		// resp.setContentType("text/html"); // mime - type con esto saldria con todo esto <>

		PrintWriter salida = resp.getWriter();
		salida.println("<font color=green size=7>");
		salida.println("Hola mundo, welcome to java EE(we're on doGet)");
		salida.println("</font>");
		salida.close();
	}

}