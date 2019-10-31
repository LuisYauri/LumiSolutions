package pe.edu.savbackend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.tarea.Estadistica;
import pe.edu.savbackend.domain.tarea.Examen;
import pe.edu.savbackend.domain.tarea.Tarea;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/examenes")
public class ExamenController {

	 //listar tareas sin preguntas
    @RequestMapping("?idEstudiante={idEstudiante}&fecha={fecha}")
    public List<Examen> getAll(@PathVariable String idEstudiante) {
        return Arrays.asList(
        		Examen.builder().build(),
        		Examen.builder().build());//filtrar por estudiante
    }
    
    //listar tareas con preguntas
    @RequestMapping("/{idTareas}/preguntas")
    public Examen getPreguntasPorTarea(@PathVariable Integer idTareas) {
        return Examen.builder().build();
    }
//    
    @PostMapping(value = "/{idExamen}/finalizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public Estadistica finalizar(@RequestBody Examen idExamen) {
	  	System.out.println("Ingreso a post " + idExamen);
	      return Estadistica.builder().build();
	  }
    
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