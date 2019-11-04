package pe.edu.savbackend.controller;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.tarea.EstadisticaDto;
import pe.edu.savbackend.domain.tarea.ExamenDto;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/examenes")
public class ExamenController {

	// listar examenes
	@RequestMapping("") // ?idEstudiante={idEstudiante}&fecha={fecha}
	public List<ExamenDto> filtrar(@RequestParam(required = false) String idEstudiante, @RequestParam(required = false) String fecha) {
		return Arrays.asList(ExamenDto.builder().build(), ExamenDto.builder().build());// filtrar por estudiante
	}

	// listar preguntas de examen
	@RequestMapping("/{idExamen}/preguntas")
	public ExamenDto getPreguntasPorExamen(@PathVariable Integer idExamen) {

		return ExamenDto.builder().build();
	}
	
	@PostMapping(value = "/{idExamen}/estudiante/{idEstudiante}/finalizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EstadisticaDto finalizar(@PathVariable Integer idExamen, @PathVariable Integer idEstudiante, @RequestBody ExamenDto examenDto) {

		return EstadisticaDto.builder().build();

	}

}