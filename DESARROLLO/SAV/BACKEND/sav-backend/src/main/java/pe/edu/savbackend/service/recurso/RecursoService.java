package pe.edu.savbackend.service.recurso;

import java.util.List;

import pe.edu.savbackend.domain.comentario.RecursoDto;

public interface RecursoService {

	RecursoDto obtenerRecursoPorId(Integer idRecurso, Integer idEstudiante);
	
	List<RecursoDto> filtrarPorIdSubcontenido(Integer idSubContenido);
}
