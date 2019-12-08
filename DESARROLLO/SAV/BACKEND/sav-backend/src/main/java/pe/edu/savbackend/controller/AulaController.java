package pe.edu.savbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.AulaDto;
import pe.edu.savbackend.entity.Grupo;
import pe.edu.savbackend.service.aula.AulaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/aulas")
public class AulaController {

	//cambios
	@Autowired
	AulaService aulaService;
    
    @RequestMapping("")
	public List<AulaDto> listaAulas() {
		return aulaService.getLsAulas(); 
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Grupo registrarAula(@RequestBody AulaDto aula) {
		return aulaService.registrarAula(aula);
	}

	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Grupo actualizarAula(@RequestBody AulaDto aula) {
		return aulaService.actualizarAula(aula);
	}

	@PatchMapping(value = "/{idAula}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean eliminarAula(@PathVariable Integer idAula) {
		return aulaService.eliminarAula(idAula);
	}
}