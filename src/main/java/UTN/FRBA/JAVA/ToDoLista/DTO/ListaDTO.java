package UTN.FRBA.JAVA.ToDoLista.DTO;

import java.util.Date;

public class ListaDTO {

	Integer id;
	Date   fechaCreacion,fechaLimite,fechaRealizacion;
	
	String descripcion;
	int asisnadaid;
	
	public int getAsisnadaid() {
		return asisnadaid;
	}

	public void setAsisnadaid(int asisnadaid) {
		this.asisnadaid = asisnadaid;
	}

	Boolean realizada;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}

	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getRealizada() {
		return realizada;
	}

	public void setRealizada(Boolean realizada) {
		this.realizada = realizada;
	}


	
	
	
	
	
}
