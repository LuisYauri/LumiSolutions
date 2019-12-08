package pe.edu.savbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.dao.ContenidoDao;
import pe.edu.savbackend.domain.ContenidoDto;
import pe.edu.savbackend.entity.Contenido;
import pe.edu.savbackend.service.contenido.ContenidoService;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/contenidos")
public class ContenidoController {
  
	@Autowired
	ContenidoService contenidoService;
	//gabriel
	@RequestMapping("")//"?idCriterio={idCriterio}&codigoGrado={codigoGrado}"
	public List<ContenidoDto> filtrar(@RequestParam(required = false) Integer idCriterio, @RequestParam(required = false) String codigoGrado) {
		return contenidoService.getLsContenido(idCriterio, codigoGrado);
	}
	
	@Autowired
	ContenidoDao contenidoDao;
	@RequestMapping("/prueba/{idContenido}")//"?idCriterio={idCriterio}&codigoGrado={codigoGrado}"
	public Contenido prueba(@PathVariable Integer idContenido) {
		
		return contenidoDao.findById(idContenido).get();
	}

}