package UTN.FRBA.JAVA.ToDoLista.Models;

import javax.persistence.*;

@Entity
public class PersonaModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	Integer id;
	
	String nombre;

	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
