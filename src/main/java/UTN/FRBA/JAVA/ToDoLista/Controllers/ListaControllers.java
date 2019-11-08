package UTN.FRBA.JAVA.ToDoLista.Controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

import UTN.FRBA.JAVA.ToDoLista.DTO.*;
import UTN.FRBA.JAVA.ToDoLista.Models.ListaModels;
import UTN.FRBA.JAVA.ToDoLista.Repositories.*;




@RestController
@RequestMapping("lista")

public class ListaControllers {

	@Autowired
	private ListaRepository listaRepository;
	
@GetMapping("/")
	
	public Iterable<ListaModel> listarTodos() {
		
		
		return  this.listaRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ListaDTO listaUno(@PathVariable Integer id) 
	{
		
		ListaDTO respuesta = new ListaDTO();
		ListaModel unaPersona = listaRepository.findById(id).orElse(null);
		
		
		if (unaPersona==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada");
        }
		respuesta.setApellido(unaPersona.getApellido());
		respuesta.setNombre(unaPersona.getNombre());
		
		return respuesta;
		
	
	}	
	@PostMapping("/")
	public ListaDTO guardar (@RequestBody ListaDTO body) {
		
		ListaDTO respuesta = new ListaDTO();
		
		ListaModels personaGuardar = new ListaModels();
		
		personaGuardar.setApellido(body.getApellido());
		personaGuardar.setEdad(body.getEdad());
		personaGuardar.setEmail(body.getEmail());
		personaGuardar.setNombre(body.getNombre());
		personaGuardar.setTelefono(body.getTelefono());
		
		this.listaRepository.save(personaGuardar);
		
		respuesta.setApellido(personaGuardar.getApellido());
		respuesta.setEdad(personaGuardar.getEdad());
		respuesta.setEmail(personaGuardar.getEmail());
		respuesta.setNombre(personaGuardar.getNombre());
		respuesta.setTelefono(personaGuardar.getTelefono());
		respuesta.setId(personaGuardar.getId());
		
		return respuesta;
		
	}
	@PutMapping("/{id}")
	public ListaDTO modificar (@PathVariable Integer id, @RequestBody String body) {
		
		ListaDTO respuesta = new ListaDTO();
		
		
		return respuesta;
		
		
	}
	
	@DeleteMapping("/{id}")
	public Boolean borrar (@PathVariable Integer id) {
	
		return true;
		
	}
	
	
}
