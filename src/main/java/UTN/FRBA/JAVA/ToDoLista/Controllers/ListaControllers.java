package UTN.FRBA.JAVA.ToDoLista.Controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

import UTN.FRBA.JAVA.ToDoLista.DTO.*;
import UTN.FRBA.JAVA.ToDoLista.Models.*;
import UTN.FRBA.JAVA.ToDoLista.Repositories.*;



 //atributos

@RestController
@RequestMapping("Lista")

public class ListaControllers {

	@Autowired
	private ListaRepository listaRepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	//Metodos
	
@GetMapping("/persona")	
public ArrayList <ListaDTO> ListaDTO() {

	
	ListaModels  unaLista;
    
	ListaDTO  listaDTO;
	
	ArrayList <ListaDTO> respuesta = new ArrayList <ListaDTO>();

   Iterable<ListaModels> listaHacer ;
		
	   listaHacer =  this.listaRepository.findAll();
		
	Iterator<ListaModels> it = listaHacer.iterator();
	while(it.hasNext()) {
		 
	unaLista = it.next();
	
	if(unaLista.getBorrado() != true) {
	
	listaDTO = new ListaDTO();
	
	listaDTO.setAsisnadaid(unaLista.getAsisnadaid());
	listaDTO.setDescripcion(unaLista.getDescripcion());
	listaDTO.setFechaCreacion(unaLista.getFechaCreacion());
	listaDTO.setFechaLimite(unaLista.getFechaLimite());
	listaDTO.setFechaRealizacion(unaLista.getFechaRealizacion());
	listaDTO.setRealizada(unaLista.getRealizada());
	
	respuesta.add(listaDTO);
	}
	}
	return respuesta;
		
	}
	
	
@GetMapping("/persona/{id}")
public PersonaDTO traerPersona(@PathVariable Integer id) 
{
	System.out.println("hola");
	
	PersonaDTO respuesta = new PersonaDTO();
	PersonaModel unaPersona = personaRepository.findById(id).orElse(null);
	
	
	if (unaPersona==null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada");
    }
	respuesta.setNombre(unaPersona.getNombre());
	
	
	return respuesta;
	
	
}	

	@GetMapping("/tarea/{id}")
	public ListaDTO listaUno(@PathVariable Integer id) 
	{
		
		ListaDTO respuesta = new ListaDTO();
		ListaModels unaLista = listaRepository.findById(id).orElse(null);
		
		
		if (unaLista==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada");
        }
		respuesta.setAsisnadaid(unaLista.getAsisnadaid());
		respuesta.setDescripcion(unaLista.getDescripcion());
		respuesta.setFechaCreacion(unaLista.getFechaCreacion());
		respuesta.setFechaLimite(unaLista.getFechaLimite());
		respuesta.setFechaRealizacion(unaLista.getFechaRealizacion());
		respuesta.setRealizada(unaLista.getRealizada());
		
		return respuesta;
		
	
	}	
	@PostMapping("/nuevatarea")
	public ListaDTO guardar (@RequestBody ListaDTO body) {
		
		ListaDTO respuesta = new ListaDTO();
		
		ListaModels guardarLista = new ListaModels();
		System.out.println("llegue aca");
		guardarLista.setAsisnadaid(body.getAsisnadaid());
		guardarLista.setDescripcion(body.getDescripcion());
		guardarLista.setFechaCreacion(body.getFechaCreacion());
		guardarLista.setFechaLimite(body.getFechaLimite());
		guardarLista.setFechaRealizacion(body.getFechaRealizacion());
		guardarLista.setRealizada(body.getRealizada());
		
		this.listaRepository.save(guardarLista);
		
		respuesta.setAsisnadaid(guardarLista.getAsisnadaid());
		respuesta.setDescripcion(guardarLista.getDescripcion());
		respuesta.setFechaCreacion(guardarLista.getFechaCreacion());
		respuesta.setFechaLimite(guardarLista.getFechaLimite());
		respuesta.setFechaRealizacion(guardarLista.getFechaRealizacion());
		respuesta.setRealizada(guardarLista.getRealizada());

		return respuesta;
		
	}
	@PutMapping("/modificar/{id}")
	public ListaDTO modificar (@PathVariable Integer id, @RequestBody ListaDTO body) {
		ListaDTO respuesta = new ListaDTO();
		
		ListaModels listaParaModificar;
		
		listaParaModificar = this.listaRepository.findById(id).orElse(null);
		
		if(listaParaModificar == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "tarea no encontrada");
		}
		
		listaParaModificar.setAsisnadaid(body.getAsisnadaid());
		listaParaModificar.setDescripcion(body.getDescripcion());
		listaParaModificar.setFechaCreacion(body.getFechaCreacion());
		listaParaModificar.setFechaLimite(body.getFechaLimite());
		listaParaModificar.setFechaRealizacion(body.getFechaRealizacion());
		listaParaModificar.setRealizada(body.getRealizada());
		
		this.listaRepository.save(listaParaModificar);
		
		respuesta.setAsisnadaid(listaParaModificar.getAsisnadaid());
		respuesta.setDescripcion(listaParaModificar.getDescripcion());
		respuesta.setFechaCreacion(listaParaModificar.getFechaCreacion());
		respuesta.setFechaLimite(listaParaModificar.getFechaLimite());
		respuesta.setFechaRealizacion(listaParaModificar.getFechaRealizacion());
		respuesta.setRealizada(listaParaModificar.getRealizada());
		
		return respuesta;
		
		
	}
	
	@DeleteMapping("/borrar/{id}")
	public String borrar (@PathVariable Integer id) {
	ListaModels lista = listaRepository.findById(id).orElse(null);
	if (lista==null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada");
    }
	
	lista.setBorrado(true);
			
			return "ok";
		
	}
	
	
}
