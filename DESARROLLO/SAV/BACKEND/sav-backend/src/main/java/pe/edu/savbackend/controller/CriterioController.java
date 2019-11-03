package pe.edu.savbackend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.CriterioDto;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/criterios")
public class CriterioController {

	
	@RequestMapping("/")
	public List<CriterioDto> getAll() {
		
		return Arrays.asList(CriterioDto.builder().build());
	}

}