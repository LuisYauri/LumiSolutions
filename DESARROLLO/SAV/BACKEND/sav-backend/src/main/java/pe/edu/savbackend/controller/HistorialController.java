package pe.edu.savbackend.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.Historial;
import pe.edu.savbackend.domain.tarea.Estadistica;
import pe.edu.savbackend.domain.tarea.Examen;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/historiales")
public class HistorialController {

	 //listar tareas sin preguntas
    @RequestMapping("?idEstudiante={idEstudiante}&fecha={fecha}")
    public Historial getAll(@PathVariable String idEstudiante) {
        return Historial.builder().build();//filtrar por estudiante
    }
    
    //listar tareas con preguntas
    @RequestMapping("/estadisticas?idEstudiante={idEstudiante}&idEvaluacion={idEvaluacion}")
    public Estadistica filtrarEstadisticas(@PathVariable Integer idEvaluacion) {
        return Estadistica.builder().build();
    }
    
    //listar tareas con preguntas
    @RequestMapping("/preguntas?idEstudiante={idEstudiante}&idEvaluacion={idEvaluacion}")
    public Examen filtrarHistorialPreguntas(@PathVariable Integer idEvaluacion) {
        return Examen.builder().build();
    }
//    
//    @PostMapping(value = "/{idExamen}/finalizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	  public Estadistica finalizar(@RequestBody Examen idExamen) {
//	  	System.out.println("Ingreso a post " + idExamen);
//	      return Estadistica.builder().build();
//	  }
    
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