package pe.edu.savbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.tarea.EstadisticaDto;
import pe.edu.savbackend.domain.tarea.TareaDto;
import pe.edu.savbackend.service.evaluacion.EvaluacionService;

/**
 * UsuariosController
 */

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/tareas")
public class TareaController {

	@Autowired
	EvaluacionService evaluacionService;
	
	
	@RequestMapping("")//?idEstudiante={idEstudiante}&fecha={fecha}
	public List<TareaDto> filtrar(@RequestParam(required = false) Integer idEstudiante, @RequestParam(required = false) String fecha) {
		return evaluacionService.getLsTareas(idEstudiante);// filtrar por estudiante
	}

	@RequestMapping("/{idTarea}/preguntas")
	public TareaDto getPreguntasPorTarea(@PathVariable Integer idTarea) {
		return evaluacionService.getPreguntasPorTarea(idTarea);
	}

	@PostMapping(value = "/{idEvaluacion}/estudiante/{idEstudiante}/finalizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EstadisticaDto finalizar(@PathVariable Integer idEvaluacion, @PathVariable Integer idEstudiante, @RequestBody TareaDto tareaDto) {
		tareaDto.setIdTarea(idEvaluacion);
		tareaDto.setIdEstudiante(idEstudiante);
		return evaluacionService.finalizarTarea(tareaDto);
	}

}