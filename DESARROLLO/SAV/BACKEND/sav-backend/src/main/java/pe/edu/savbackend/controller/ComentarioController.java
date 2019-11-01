package pe.edu.savbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.Comentario;


@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

//    @RequestMapping("/")
//    public List<Pregunta> getAll() {
//        return Arrays.asList(
//        		Pregunta.builder().build(),
//        		Pregunta.builder().build());
//    }
    
//    //comprobar pregunta
//    @PostMapping(value = "/{idPregunta}/comprobar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Boolean comprobarPregunta(@RequestBody Pregunta er) {
//        return true;
//    }
    
    
//    @RequestMapping("/{idTest}")
//    public Tarea getById(@PathVariable Integer idTest) {
//        return Tarea.builder().build();
//    }
//    
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Comentario register(@RequestBody Comentario er) {
        return null;
    }
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