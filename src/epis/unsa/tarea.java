package epis.unsa;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class tarea {
	
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long id;
	
	
	
	@Persistent
	String nombreDocente,anho,tarea,dia,mes,hora,minuto,fecha;
	@Persistent
	Long idCurso;
	
	
	public tarea(String nombreDocente,String anho,Long idCurso,String tarea,String mes,String dia,String hora,String minuto,String fecha){
		this.nombreDocente=nombreDocente;
		this.anho=anho;
		this.idCurso=idCurso;
		this.dia=dia;
		this.mes=mes;
		this.hora=hora;
		this.minuto=minuto;
		this.tarea=tarea;
		this.fecha=fecha;
	}

	
	public void setAnho(String anho){
		this.anho=anho;
	}
	
	public void setIdCurso(Long idCurso){
		this.idCurso=idCurso;
	}
	
	public void setTarea(String tarea){
		this.tarea=tarea;
	}
	
	public void setFecha(String fecha){
		this.fecha=fecha;
	}
	
	public void setMes(String mes){
		this.mes=mes;
	}
	
	public void setDia(String dia){
		this.dia=dia;
	}
	
	public void setHora(String hora){
		this.hora=hora;
	}
	
	public void setMinuto(String minuto){
		this.minuto=minuto;
	}
	
	
	
	
	public Long getId(){
		return id;
	}
	
	
	
	public String getFecha(){
		return fecha;
	}

	
	public String getNombreDocente(){
		return nombreDocente;
	}
	
	public String getAnho(){
		return anho;
	}
	
	public Long getidCurso(){
		return idCurso;
	}
	
	public String getDia(){
		return dia;
	}
	
	public String getMes(){
		return mes;
	}
	
	public String getHora(){
		return hora;
	}
	
	public String getMinuto(){
		return minuto;
	}
	
	public String getTarea(){
		return tarea;
	}
	
	
	
	
	
	@Override
	public String toString() {
		String resp ="\t" + dia;  
		return resp;
	}
	
	
	
	
	
	
	
}
