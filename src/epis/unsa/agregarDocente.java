package epis.unsa;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import epis.unsa.PMF;

@SuppressWarnings("serial")
public class agregarDocente extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String codigo = req.getParameter("codigo");
		String contrasena = req.getParameter("contrasena");
		String nombres = req.getParameter("nombres");
		String apellidos = req.getParameter("apellidos");
		String direccion = req.getParameter("direccion");
		String correo = req.getParameter("correo");
		String telefono = req.getParameter("telefono");
		String sexo = req.getParameter("sexo");
		
		String [] cursos = req.getParameterValues("cursos");
		String [] anhos = req.getParameterValues("anhos");
		
		
		
		docente d = new docente(codigo,contrasena,nombres,apellidos,direccion,sexo,correo,telefono);

		for(int i=0;i<cursos.length;i++)
			d.setCurso(cursos[i]);
		

		for(int i=0;i<anhos.length;i++)
			d.setAnho(anhos[i]);
		
		
		
		resp.getWriter().print("<!DOCTYPE html>"		 
				+ "<html><body>");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(d);
			resp.getWriter().println("Datos grabados correctamente");
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrió un error, <a href='index.jsp'>vuelva a intentarlo</a>");
		}finally{
			pm.close();
		}
		
		
		resp.getWriter().print("<form action='comoAdministrador.jsp'>"+
		
				"<input type='submit' value='REGRESAR AL MENU'></form>");
		
	}
}
