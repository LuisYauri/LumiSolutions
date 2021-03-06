package pe.edu.savbackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.AulaDto;
import pe.edu.savbackend.entity.Grupo;
import pe.edu.savbackend.service.aula.AulaService;

@RestController
@RequestMapping("/aulas")
public class AulaController {

	//cambios
	@Autowired
	AulaService aulaService;
    
    @RequestMapping("")
	public List<AulaDto> listaAulas() {
		return aulaService.getLsAulas().stream().sorted((c1,c2)-> c2.getIdAula().compareTo(c1.getIdAula())).collect(Collectors.toList()); 
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Grupo registrarAula(@RequestBody AulaDto aula) {
		return aulaService.registrarAula(aula);
	}

	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Grupo actualizarAula(@RequestBody AulaDto aula) {
		return aulaService.actualizarAula(aula);
	}

	@PatchMapping(value = "/{idAula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean eliminarAula(@PathVariable Integer idAula) {
		return aulaService.eliminarAula(idAula);
	}
}