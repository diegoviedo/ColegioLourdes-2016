package epis.unsa;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class curso {
	
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long id;
	
	
	
	@Persistent
	String nombreCurso,estado="ACTIVO";
	
	public curso(String nombreCurso){
		this.nombreCurso=nombreCurso;
	}
	
	
	public void setNombreCurso(String nombreCurso){
		this.nombreCurso=nombreCurso;
	}
	
	
	public Long getId(){
		return id;
	}
	
	
	public String getEstado(){
		return estado;
	}
	
	
	public String getNombreCurso(){
		return nombreCurso;
	}
	
	
	
	
	
	public void activarCurso(){
		estado="ACTIVO";
	}
	
	public void desactivarCurso(){
		estado="NO ACTIVO";
	}
	
	
	
	
	@Override
	public String toString() {
		String resp =  "\t" ;  
		return resp;
	}
	
	
	
	
	
	
	
}
