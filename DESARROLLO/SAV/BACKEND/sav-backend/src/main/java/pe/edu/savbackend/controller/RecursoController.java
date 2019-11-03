package pe.edu.savbackend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.comentario.RecursoDto;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/recursos")
public class RecursoController {

	//ALISSON
	@RequestMapping("/{idRecurso}")
	public RecursoDto get(@PathVariable Integer idRecurso) {
		return RecursoDto.builder().build(); // devolver un recurso con lista de alumnos
	}
	//ALISSON
	@RequestMapping("") // ?idSubContenido={idSubContenido}
	public List<RecursoDto> filtrar(@RequestParam(required = false) String idSubContenido) {
		return Arrays.asList(RecursoDto.builder().build()); // devolver un recurso con lista de alumnos
	}

}