package epis.unsa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class iniciarSesion extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		String codigo = req.getParameter("codigo");
		String contrasena = req.getParameter("pass");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		resp.setContentType("text/html");
		
		Query q = pm.newQuery(alumno.class);
		Query q1 = pm.newQuery(docente.class);
		Query q2 = pm.newQuery(administrador.class);
		
		boolean esta = false;
		
		try{
			
			List<alumno> alumnos = (List<alumno>) q.execute();
			
			for(alumno a: alumnos){
				if(a.getCodigo().equals(codigo)&&a.getContrasena().equals(contrasena)){
					esta=true;
					req.setAttribute("codigo", codigo);
					req.setAttribute("pass", contrasena);
					RequestDispatcher rd = req.getRequestDispatcher("iniciarSesionAlumno");
					rd.forward(req, resp);
					break;
				}
			}
			
			List<docente> docentes = (List<docente>) q1.execute();
			
			for(docente d: docentes){
				if(d.getCodigo().equals(codigo)&&d.getContrasena().equals(contrasena)){
					esta=true;
					req.setAttribute("codigo", codigo);
					req.setAttribute("pass", contrasena);
					RequestDispatcher rd = req.getRequestDispatcher("iniciarSesionDocente");
					rd.forward(req, resp);
					break;
				}
			}
			
			List<administrador> administradores = (List<administrador>) q2.execute();
			
			for(administrador c: administradores){
				if(c.getCodigo().equals(codigo)&&c.getContrasena().equals(contrasena)){
					esta=true;
					req.setAttribute("codigo", codigo);
					req.setAttribute("pass", contrasena);
					RequestDispatcher rd = req.getRequestDispatcher("iniciarSesionAdministrador");
					rd.forward(req, resp);
					break;
				}
			}
			
			
			
			
			
			
			
			if(!esta)
				resp.sendRedirect("/index.html");
			
			
		}catch(Exception e){
			System.out.println(e);
		}finally{
			pm.close();
			 q.closeAll();
	
		}
		
		
		
	
	}
}
