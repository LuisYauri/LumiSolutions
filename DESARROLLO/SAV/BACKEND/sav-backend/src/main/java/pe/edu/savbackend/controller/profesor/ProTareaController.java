package pe.edu.savbackend.controller.profesor;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.AulaDto;
import pe.edu.savbackend.domain.PROFESOR.ProTareaDto;
import pe.edu.savbackend.domain.tarea.EstadisticaDto;
import pe.edu.savbackend.domain.tarea.TareaDto;
import pe.edu.savbackend.service.evaluacion.EvaluacionService;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("profesor/tareas")
public class ProTareaController {

//	@Autowired
//	EvaluacionService evaluacionService;
//	
//	
	@RequestMapping("")//profesor/tareas?idAula={idAula}
	public List<ProTareaDto> filtrar(@RequestParam(required = false) Integer idAula) {
		return Arrays.asList(ProTareaDto.builder().build());// filtrar por estudiante
	}
//
//	@RequestMapping("/{idTarea}/preguntas")
////	@Secured("ALUMNO")
//	public TareaDto getPreguntasPorTarea(@PathVariable Integer idTarea) {
//		return evaluacionService.getPreguntasPorTarea(idTarea);
//	}
//
//	@PostMapping(value = "/{idEvaluacion}/estudiante/{idEstudiante}/finalizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public EstadisticaDto finalizar(@PathVariable Integer idEvaluacion, @PathVariable Integer idEstudiante, @RequestBody TareaDto tareaDto) {
//		tareaDto.setIdTarea(idEvaluacion);
//		tareaDto.setIdEstudiante(idEstudiante);
//		return evaluacionService.finalizarTarea(tareaDto);
//	}


	
	
}