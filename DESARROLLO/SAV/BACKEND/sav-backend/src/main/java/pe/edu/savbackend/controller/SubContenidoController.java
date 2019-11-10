package pe.edu.savbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.ContenidoDto;
import pe.edu.savbackend.service.subcontenidos.SubcontenidosService;

/**
 *
 * UsuariosController
 */

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/subContenidos")
public class SubContenidoController {
  
	@Autowired
	SubcontenidosService subcontenido;
  
	@RequestMapping("") // ?idContenido={idContenido}
	public ContenidoDto filtrar(@RequestParam(required = false) Integer idContenido) {
		return subcontenido.getLsubContenido(idContenido);
	}
	

}