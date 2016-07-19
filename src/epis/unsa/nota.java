package epis.unsa;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class nota {
	
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long id;
	
	
	
	@Persistent
	Long idAlumno,idCurso;
	@Persistent
	int nota;
	
	
	public nota(Long idAlumno,Long idCurso,int nota){
		this.idAlumno=idAlumno;
		this.idCurso=idCurso;
		this.nota=nota;
	}
	

	public void setNota(int nota){
		this.nota=nota;
	}
	
	public int getNota(){
		return nota;
	}
	
	public Long getIdAlumno(){
		return idAlumno;
	}
	
	public Long getIdCurso(){
		return idCurso;
	}
	
	
	
	
	
	
	
	@Override
	public String toString() {
		String resp = "\t" ;  
		return resp;
	}
	
	
	
	
	
	
	
}
