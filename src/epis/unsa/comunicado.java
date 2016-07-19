package epis.unsa;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class comunicado {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long id;
	
	
	
	
	@Persistent
	String comunicado,fecha,nombresAdm,apellidosAdm;
	
	public comunicado(String nombresAdm,String apellidosAdm, String comunicado,String fecha){
		this.nombresAdm = nombresAdm;
		this.apellidosAdm=apellidosAdm;
		this.comunicado=comunicado;
		this.fecha=fecha;
		
	}
	
	
	
	public Long getId(){
		return id;	
	}
	
	
	public String getNombresAdm(){
		return nombresAdm;
	}
	
	public String getApellidosAdm(){
		return apellidosAdm;
	}
	
	
	
	public String getComunicado(){
		return comunicado;
	}
	
	public String getFecha(){
		return fecha;
	}
	
	
	public void setComunicado(String comunicado){
		this.comunicado=comunicado;
	}
	
	public void setFecha(String fecha){
		this.fecha=fecha;
	}
	
	
	
	
	
	@Override
	public String toString() {
		String resp = comunicado + "\n "+ "PUBLICADO POR "+ nombresAdm+"   " +apellidosAdm +"\t"+"FECHA:  "+ fecha ;  
		return resp;
	}
	
	
	
	
	
	
	
}
