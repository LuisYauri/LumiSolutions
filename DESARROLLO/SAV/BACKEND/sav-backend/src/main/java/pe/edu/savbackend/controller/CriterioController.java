package pe.edu.savbackend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.CriterioDto;
import pe.edu.savbackend.domain.Test;
import pe.edu.savbackend.service.test.TestService;

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