package epis.unsa;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class alumno {
	
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long id;
	
	
	
	@Persistent
	String contrasena,nombres,apellidos,direccion,sexo,anho,codigo,estado="ACTIVO";
	
	public alumno(String codigo,String contrasena,String nombres,String apellidos,String direccion,String sexo,String anho){
		this.codigo=codigo;
		this.contrasena=contrasena;
		this.nombres=nombres;
		this.apellidos=apellidos;
		this.direccion=direccion;
		this.sexo=sexo;
		this.anho=anho;
		
	}
	

	public void setCodigo(String codigo){
		this.codigo=codigo;
	}
	
	public void setContrasena(String contra){
		contrasena=contra;
	}
	
	public void setNombres(String names){
		nombres=names;
	}
	
	public void setApellidos(String apell){
		apellidos=apell;
	}
	
	public void setDireccion(String dir){
		direccion=dir;
	}
	
	public void setSexo(String sex){
		sexo=sex;
	}
	
	public void setAnho(String a){
		anho=a;
	}

	public Long getId(){
		return id;
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

	public String getAnho(){
		return anho;
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
		String resp = nombres + "\t" + apellidos;  
		return resp;
	}
	
	
	
	
	
	
	
}
