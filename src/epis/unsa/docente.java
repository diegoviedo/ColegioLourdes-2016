package epis.unsa;
import java.util.*;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class docente {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long id;
	
	@Persistent
	String codigo,contrasena,nombres,apellidos,direccion,sexo,tutorAnho,curso,correo,telefono,estado="ACTIVO";
	@Persistent
	ArrayList<String> cursos = new ArrayList<String>();
	@Persistent
	ArrayList<String> anhos = new ArrayList<String>();
	
	
	
	public docente(String codigo,String contrasena,String nombres,String apellidos,String direccion,String sexo,String correo,String telefono){
		this.codigo=codigo;
		this.contrasena=contrasena;
		this.nombres=nombres;
		this.apellidos=apellidos;
		this.sexo=sexo;
		this.direccion=direccion;
		this.correo=correo;
		this.telefono=telefono;
	}
	
	public Long getId(){
		return id;
	}
	
	
	public void setCodigo(String codigo){
		this.codigo=codigo;
	}
	
	public void setContrasena(String contrasena){
		this.contrasena = contrasena;
	}
	
	public void setNombres(String nombres){
		this.nombres = nombres;
	}
	
	public void setApellidos(String apellidos){
		this.apellidos = apellidos;
	}
	
	public void setDireccion(String direccion){
		this.direccion = direccion;
	}
	
	public void setCorreo(String correo){
		this.correo = correo;
	}
	
	public void setTelefono(String telefono){
		this.telefono = telefono;
	}
	
	public void setSexo(String sexo){
		this.sexo = sexo;
	}
	
	public void setCurso(String curso){
		cursos.add(curso);
	}
	
	public void setAnho(String anho){
		anhos.add(anho);
	}
	
	public void limpiarAnhosYCursos(){
		cursos.clear();
		anhos.clear();
	}
	
	
	public String getCodigo(){
		return codigo;
	}
	
	public String getContrasena(){
		return contrasena;
	}
	
	public String getNombres(){
		return nombres;
	}
	
	public String getApellidos(){
		return apellidos;
	}
	
	public String getDireccion(){
		return direccion;
	}
	
	public String getSexo(){
		return sexo;
	}
	
	
	
	
	public String getCorreo(){
		return correo;
	}
	
	public String getTelefono(){
		return telefono;
	}
	
	public ArrayList<String> getAnhos(){
		return anhos;
	}
	
	public ArrayList<String> getCursos(){
		return cursos;
	}
	
	
	
	
	public String getEstado(){
		return estado;
	}
	
	
	
	public void activarAlumno(){
		estado="ACTIVO";
	}
	
	public void desactivarAlumno(){
		estado="NO ACTIVO";
	}
	
	@Override
	public String toString() {
		String resp = "\t" ;  
		return resp;
	}
	
	
	
	
	
	
	
}
