package epis.unsa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class agregarAdministrador extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		
		// Obtengo los datos de la peticion
		
		String codigo = request.getParameter("codigo");
		String contrasena = request.getParameter("contrasena");
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		
		administrador p = new administrador(codigo,contrasena,nombres,apellidos);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(p);
			out.print("SE AGREGO : \n" +"CODIGO: "+p.getCodigo() +"\n"+
			"CONTRASENA:  "+p.getContrasena()+"\n"+
					"NOMBRES:   "+p.getNombres() + "\n"+
					"APELLIDOS:   "+p.getApellidos());
		}catch(Exception e){
			System.out.println(e);
		}finally{
			 pm.close();
		}
		
	}
}
