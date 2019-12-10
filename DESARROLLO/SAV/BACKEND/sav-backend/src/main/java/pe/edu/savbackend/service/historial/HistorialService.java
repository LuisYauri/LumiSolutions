package pe.edu.savbackend.service.historial;

import java.time.LocalDate;

import pe.edu.savbackend.domain.tarea.EstadisticaDto;
import pe.edu.savbackend.domain.tarea.ExamenDto;
import pe.edu.savbackend.domain.tarea.HistorialDto;

public interface HistorialService {

	HistorialDto obtenerHistorialTareasExamenes(Integer idEstudiante, LocalDate fecha);
	
	ExamenDto obtenerHistorialPreguntas(Integer idEstudiante, Integer idEvaluacion);
	
	EstadisticaDto obtenerEstadisticaEvaluacion(Integer idEstudiante, Integer idEvaluacion);
	
	
}
