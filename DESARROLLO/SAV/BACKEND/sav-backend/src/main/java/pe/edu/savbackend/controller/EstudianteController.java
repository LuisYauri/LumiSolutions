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

import pe.edu.savbackend.domain.EstudianteDto;
import pe.edu.savbackend.entity.Estudiante;
import pe.edu.savbackend.service.estudiante.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

	//cambios
	@Autowired
	EstudianteService estudianteService;
    
    @RequestMapping("")
	public List<EstudianteDto> listaEstudiantes() {
		return estudianteService.getLsEstudiantes(); 
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Estudiante registrarEstudiante(@RequestBody EstudianteDto estudiante) {
		return null;
		//return estudianteService.registrarEstudiante(estudiante);
	}

	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Estudiante actualizarEstudiante(@RequestBody EstudianteDto estudiante) {
		return null;
		//return estudianteService.actualizarEstudiante(estudiante);
	}

	@PatchMapping(value = "/{idAula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean eliminarEstudiante(@PathVariable Integer idEstudiante) {
		return null;
		//return estudianteService.eliminarEstudiante(idEstudiante);
	}
}