package epis.unsa;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class administrador {
	
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long id;
	
	
	
	@Persistent
	String contrasena,nombres,apellidos,codigo;
	
	public administrador(String codigo,String contrasena,String nombres,String apellidos){
		this.codigo=codigo;
		this.contrasena=contrasena;
		this.nombres=nombres;
		this.apellidos=apellidos;
		
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
	
	

	
	
	
	@Override
	public String toString() {
		String resp = nombres + "\t" + apellidos;  
		return resp;
	}
	
	
	
	
	
	
	
}
