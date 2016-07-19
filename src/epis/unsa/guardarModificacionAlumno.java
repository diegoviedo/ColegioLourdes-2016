package epis.unsa;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import epis.unsa.PMF;

@SuppressWarnings("serial")
public class guardarModificacionAlumno extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String idAlum = req.getParameter("idAlum");
		Long id = Long.parseLong(idAlum);
		String codigo = req.getParameter("codigo");
		String contrasena = req.getParameter("contrasena");
		String nombres = req.getParameter("nombres");
		String apellidos = req.getParameter("apellidos");
		String direccion = req.getParameter("direccion");
		String sexo = req.getParameter("sexo");
		String anho = req.getParameter("anho");
		String estado = req.getParameter("estado");
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			alumno a = pm.getObjectById(alumno.class,id);
			a.setCodigo(codigo);
			a.setContrasena(contrasena);
			a.setNombres(nombres);
			a.setApellidos(apellidos);
			a.setDireccion(direccion);
			a.setSexo(sexo);
			a.setAnho(anho);
			if(estado.equals("ACTIVO"))
				a.activarAlumno();
			else
				a.desactivarAlumno();
			pm.makePersistent(a);
			
			resp.sendRedirect("comoAdministrador.jsp");
			
			
			
		}catch(Exception e){
			System.out.println(e);
			
		}finally{
			pm.close();
		}
		
		
		
	}
}
