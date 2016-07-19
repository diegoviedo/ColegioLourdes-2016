package epis.unsa;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import epis.unsa.PMF;

@SuppressWarnings("serial")
public class guardarModificacionDocente extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String idDocente = req.getParameter("idDocente");
		Long id = Long.parseLong(idDocente);
		String codigo = req.getParameter("codigo");
		String contrasena = req.getParameter("contrasena");
		String nombres = req.getParameter("nombres");
		String apellidos = req.getParameter("apellidos");
		String direccion = req.getParameter("direccion");
		String correo = req.getParameter("correo");
		String telefono = req.getParameter("telefono");
		String sexo = req.getParameter("sexo");
		String estado = req.getParameter("estado");
		String [] cursos = req.getParameterValues("cursos");
		String [] anhos = req.getParameterValues("anhos");
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try{
			docente a = pm.getObjectById(docente.class,id);
			a.setCodigo(codigo);
			a.setContrasena(contrasena);
			a.setNombres(nombres);
			a.setApellidos(apellidos);
			a.setDireccion(direccion);
			a.setSexo(sexo);
			a.setCorreo(correo);
			a.setTelefono(telefono);
			
			if(estado.equals("ACTIVO"))
				a.activarAlumno();
			else
				a.desactivarAlumno();
			
			a.limpiarAnhosYCursos();
			

			for(int i=0;i<cursos.length;i++)
				a.setCurso(cursos[i]);
			

			for(int i=0;i<anhos.length;i++)
				a.setAnho(anhos[i]);
			
			
			
			pm.makePersistent(a);
			
			
			resp.sendRedirect("comoAdministrador.jsp");
			
			
			
		}catch(Exception e){
			System.out.println(e);
			
		}finally{
			pm.close();
		}
		
		
		
	}
}
