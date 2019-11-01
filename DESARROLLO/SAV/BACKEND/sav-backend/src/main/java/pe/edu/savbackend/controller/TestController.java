package pe.edu.savbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.dao.DocenteDao;
import pe.edu.savbackend.dao.EstudianteDao;
import pe.edu.savbackend.dao.PersonaDao;
import pe.edu.savbackend.domain.DatosEstudiante;
import pe.edu.savbackend.domain.Test;
import pe.edu.savbackend.entity.Docente;
import pe.edu.savbackend.entity.Persona;
import pe.edu.savbackend.service.TestService;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	TestService testService;
	@Autowired
	EstudianteDao personaDao;


	@RequestMapping("/personas-prueba")
	public List<DatosEstudiante> getPersonas() {
		return personaDao.listEstudiante();
	}


	@RequestMapping("/")
	public List<Test> get() {
		return testService.getAll();
	}

	@RequestMapping("/{idTest}")
	public Test getById(@PathVariable Integer idTest) {
		System.out.println("Ingreso a get");
		return testService.get(idTest);
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Test register(@RequestBody Test er) {
		System.out.println("Ingreso a post " + er);
		return testService.register(er);
	}

	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Test update(@RequestBody Test er) {

		return testService.update(er);
	}

	@DeleteMapping(value = "/{idTest}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Integer idTest) {
		testService.delete(idTest);
	}
}