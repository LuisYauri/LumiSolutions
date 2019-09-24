package pe.edu.savbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import pe.edu.savbackend.dao.PersonaDao;
import pe.edu.savbackend.domain.Persona;
import pe.edu.savbackend.domain.request.ExampleRequest;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/persona")
public class PersonaController {

//    private static final Logger log = LoggerFactory.getLogger(UsuariosController.class);
	@Autowired
	private PersonaDao p;
    
    @RequestMapping("/")
    public List<Persona> get() {
    	System.out.println("Ingreso a get");
    	System.out.println(p.findAll());
        return p.findAll();
    }
    
    @PostMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Rest de prueba", notes = "Hace un rest de prueba", nickname = "nickName")
    public List<Persona> post(@RequestBody ExampleRequest er) {
    	
    	System.out.println("Ingreso a post " + er);
    	System.out.println(p.findAll());
        return p.findAll();
    }
}