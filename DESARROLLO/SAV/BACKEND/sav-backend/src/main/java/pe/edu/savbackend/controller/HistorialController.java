package pe.edu.savbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.tarea.EstadisticaDto;
import pe.edu.savbackend.domain.tarea.ExamenDto;
import pe.edu.savbackend.domain.tarea.HistorialDto;
import pe.edu.savbackend.service.historial.HistorialService;

/**
 * UsuariosController
 */

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/historiales")
public class HistorialController {

	@Autowired
	HistorialService historialService;
	
	@RequestMapping("")//?idEstudiante={idEstudiante}&fecha={fecha}
	public HistorialDto getAll(@RequestParam(required = false) Integer idEstudiante, @RequestParam(required = false) String fecha) {
		
		return historialService.obtenerHistorialTareasExamenes(idEstudiante, null); 
	}

	@RequestMapping("/estadisticas")//?idEstudiante={idEstudiante}&idEvaluacion={idEvaluacion}
	public EstadisticaDto filtrarEstadisticas(@RequestParam(required = false) Integer idEstudiante, @RequestParam(required = false) Integer idEvaluacion) {
		return historialService.obtenerEstadisticaEvaluacion(idEstudiante, idEvaluacion);
	}

	@RequestMapping("/preguntas")//?idEstudiante={idEstudiante}&idEvaluacion={idEvaluacion}
	public ExamenDto filtrarHistorialPreguntas(@RequestParam(required = false) Integer idEstudiante, @RequestParam(required = false) Integer idEvaluacion) {
		return historialService.obtenerHistorialPreguntas(idEstudiante, idEvaluacion);
	}

}