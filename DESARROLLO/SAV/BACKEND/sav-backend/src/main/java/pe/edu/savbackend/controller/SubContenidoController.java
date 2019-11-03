package pe.edu.savbackend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.SubContenidoDto;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/subContenidos")
public class SubContenidoController {

		//JORDAN SUB CONTENIDO
	@RequestMapping("") // ?idContenido={idContenido}
	public List<SubContenidoDto> filtrar(@RequestParam(required = false) String idContenido) {
		return Arrays.asList(SubContenidoDto.builder().build());
	}

}