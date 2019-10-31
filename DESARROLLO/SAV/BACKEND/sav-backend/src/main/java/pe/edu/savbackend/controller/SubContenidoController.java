package pe.edu.savbackend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.SubContenido;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/subContenidos")
public class SubContenidoController {


    
    @RequestMapping("?idContenido={idContenido}")
    public List<SubContenido> filtrar(@PathVariable Integer idCriterio) {
        return Arrays.asList(SubContenido.builder().build());
    }
    
//    @RequestMapping("/{idTest}")
//    public Test getById(@PathVariable Integer idTest) {
//    	System.out.println("Ingreso a get");
//        return testService.get(idTest);
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