package pe.edu.savbackend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.Recurso;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/recursos")
public class RecursoController {

	@RequestMapping("/{idRecurso}")
	public Recurso getById(@PathVariable Integer idRecurso) {
		return Recurso.builder().build(); // devolver un recurso con lista de alumnos
	}

	@RequestMapping("?idSubContenido={idSubContenido}")
	public List<Recurso> filtrar(@PathVariable Integer idSubContenido) {
		return Arrays.asList(Recurso.builder().build()); // devolver un recurso con lista de alumnos
	}

//    //listar tareas con preguntas
//    @RequestMapping("/{idTest}/preguntas")
//    public List<Tarea> getPreguntasPorTarea(@PathVariable Integer idTest) {
//        return Arrays.asList(Tarea.builder().build());
//    }

//    
//    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Test register(@RequestBody Test er) {
//    	System.out.println("Ingreso a post " + er);
//        return testService.register(er);
//    }
//    
//    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public Test update(@RequestBody Test er) {
//    	
//	  	return testService.update(er);
//	}
//    
//    @DeleteMapping(value = "/{idTest}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public void delete(@PathVariable Integer idTest) {
//	  	 testService.delete(idTest);
//	}
}