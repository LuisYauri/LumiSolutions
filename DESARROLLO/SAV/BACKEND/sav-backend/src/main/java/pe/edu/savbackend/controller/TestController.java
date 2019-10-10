package pe.edu.savbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.dao.TestDao;
import pe.edu.savbackend.domain.Test;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/test")
public class TestController {

//    private static final Logger log = LoggerFactory.getLogger(UsuariosController.class);
	@Autowired
	private TestDao r;
    
    @RequestMapping("/")
    public List<Test> get() {
    	System.out.println("Ingreso a get");
    	System.out.println(r.findAll());
        return r.findAll();
    }
    
    @RequestMapping("/{id}")
    public Test getById(@RequestParam Integer id) {
    	System.out.println("Ingreso a get");
//    	System.out.println(r.findAll());
        return r.getOne(id);
    }
    
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Rest de prueba", notes = "Hace un rest de prueba", nickname = "nickName")
    public Test register(@RequestBody Test er) {
    	
    	System.out.println("Ingreso a post " + er);
    	System.out.println(r.findAll());
        return r.save(er);
    }
    
    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//  @ApiOperation(value = "Rest de prueba", notes = "Hace un rest de prueba", nickname = "nickName")
	  public Test update(@RequestBody Test er) {
	  	      return r.save(er);
	  }
    
    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//  @ApiOperation(value = "Rest de prueba", notes = "Hace un rest de prueba", nickname = "nickName")
	  public void delete(@RequestParam Integer id) {
	  	      r.deleteById(id);
	  }
}