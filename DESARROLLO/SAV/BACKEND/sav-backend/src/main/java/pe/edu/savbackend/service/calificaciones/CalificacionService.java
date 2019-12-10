package pe.edu.savbackend.service.calificaciones;

import pe.edu.savbackend.entity.Calificacion;

public interface CalificacionService {

	Double registrarCalificacion(Calificacion calificacion);
	
	Integer obtenerCalificacionPorEstudiante(Integer idEstudiante, Integer idRecurso);
	
	Double obtenerCalificacionPromedio(Integer idRecurso);
}
