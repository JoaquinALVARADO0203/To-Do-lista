package UTN.FRBA.JAVA.ToDoLista.Models;

import java.util.*;

import javax.persistence.*;


@Entity
public class ListaModels {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	Date fechaCreacion,fechaLimite,fechaRealizacion;
	
	String descripcion;
	int asisnadaid;
	Boolean borrado,realizada;

	
	
	
	
	
	public int getAsisnadaid() {
		return asisnadaid;
	}

	public void setAsisnadaid(int asisnadaid) {
		this.asisnadaid = asisnadaid;
	}

	public Boolean getBorrado() {
		return borrado;
	}

	public void setBorrado(Boolean borrado) {
		this.borrado = borrado;
	}

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
