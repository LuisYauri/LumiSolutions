package pe.edu.savbackend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.Contenido;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/contenidos")
public class ContenidoController {

	@RequestMapping("")//"?idCriterio={idCriterio}&codigoGrado={codigoGrado}"
	public List<Contenido> filtrar(@RequestParam(required = false) String idCriterio, @RequestParam(required = false) String codigoGrado) {
		System.out.println("idCriterio = " + idCriterio);
		System.out.println("codigoGrado = " + codigoGrado);
		return Arrays.asList(Contenido.builder().nombre("contenido 2").build());
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