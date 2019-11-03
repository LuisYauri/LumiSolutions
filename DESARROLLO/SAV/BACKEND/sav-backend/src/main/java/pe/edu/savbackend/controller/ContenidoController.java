package pe.edu.savbackend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.ContenidoDto;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/contenidos")
public class ContenidoController {

	//gabriel
	@RequestMapping("")//"?idCriterio={idCriterio}&codigoGrado={codigoGrado}"
	public List<ContenidoDto> filtrar(@RequestParam(required = false) String idCriterio, @RequestParam(required = false) String codigoGrado) {
		return Arrays.asList(ContenidoDto.builder().nombre("contenido 2").build());
	}


}