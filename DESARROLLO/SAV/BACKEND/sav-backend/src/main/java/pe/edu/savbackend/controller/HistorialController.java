package pe.edu.savbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.tarea.EstadisticaDto;
import pe.edu.savbackend.domain.tarea.ExamenDto;
import pe.edu.savbackend.domain.tarea.HistorialDto;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/historiales")
public class HistorialController {

	
	@RequestMapping("")//?idEstudiante={idEstudiante}&fecha={fecha}
	public HistorialDto getAll(@RequestParam(required = false) String idEstudiante, @RequestParam(required = false) String fecha) {
		return HistorialDto.builder().build(); 
	}

	@RequestMapping("/estadisticas")//?idEstudiante={idEstudiante}&idEvaluacion={idEvaluacion}
	public EstadisticaDto filtrarEstadisticas(@RequestParam(required = false) String idEstudiante, @RequestParam(required = false) String idEvaluacion) {
		return EstadisticaDto.builder().build();
	}

	@RequestMapping("/preguntas")//?idEstudiante={idEstudiante}&idEvaluacion={idEvaluacion}
	public ExamenDto filtrarHistorialPreguntas(@RequestParam(required = false) String idEstudiante, @RequestParam(required = false) String idEvaluacion) {
		return ExamenDto.builder().build();
	}

}