package pe.edu.savbackend.service.calificaciones;

import java.util.Map;

import pe.edu.savbackend.entity.Calificacion;

public interface CalificacionService {

	Double registrarCalificacion(Calificacion calificacion);
	
	Integer obtenerCalificacionPorEstudiante(Integer idEstudiante, Integer idRecurso);
}
