package pe.edu.savbackend.controller.profesor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.PROFESOR.ProCrearTareaDto;
import pe.edu.savbackend.domain.PROFESOR.ProTareaDto;
import pe.edu.savbackend.entity.Evaluacion;
import pe.edu.savbackend.service.evaluacion.EvaluacionService;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("profesor/tareas")
public class ProTareaController {

	@Autowired
	EvaluacionService evaluacionService;
	
	@RequestMapping("")//profesor/tareas?idAula={idAula}
	public List<ProTareaDto> filtrar(@RequestParam(required = false) Integer idAula) {
		return evaluacionService.getLsTareasAsignadas(idAula);// filtrar por estudiante
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Evaluacion registrarTarea(@RequestBody ProCrearTareaDto tarea) {
		return evaluacionService.registrarTarea(tarea);
	}

	@PatchMapping(value = "/{idTarea}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean eliminarTarea(@PathVariable Integer idTarea) {
		return evaluacionService.eliminarTarea(idTarea);
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