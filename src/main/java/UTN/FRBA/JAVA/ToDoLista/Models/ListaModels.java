package UTN.FRBA.JAVA.ToDoLista.Models;

import java.util.*;

import javax.persistence.*;


@Entity
public class ListaModels {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	

	Integer ID;
	Date   fechaCreacion,fechaLimite,fechaRealizacion;
	
	String asisnadaid,descripcion;
	
	Boolean realizada;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
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

	public String getAsisnadaid() {
		return asisnadaid;
	}

	public void setAsisnadaid(String asisnadaid) {
		this.asisnadaid = asisnadaid;
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
