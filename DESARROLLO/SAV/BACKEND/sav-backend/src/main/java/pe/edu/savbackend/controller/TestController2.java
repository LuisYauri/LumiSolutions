package pe.edu.savbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.dao.EstudianteDao;
import pe.edu.savbackend.entity.Estudiante;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/estudiantes")
public class TestController2 {

	@Autowired
	EstudianteDao testService;

	@RequestMapping("/")
	public List<Estudiante> get() {
		return testService.findAll();
	}

	@RequestMapping("/{idTest}")
	public Estudiante getById(@PathVariable Integer idTest) {
		System.out.println("Ingreso a get");
		return testService.findById(idTest).get();
	}

//	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public Test register(@RequestBody Test er) {
//		System.out.println("Ingreso a post " + er);
//		return testService.register(er);
//	}
//
//	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public Test update(@RequestBody Test er) {
//
//		return testService.update(er);
//	}
//
//	@DeleteMapping(value = "/{idTest}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public void delete(@PathVariable Integer idTest) {
//		testService.delete(idTest);
//	}
}