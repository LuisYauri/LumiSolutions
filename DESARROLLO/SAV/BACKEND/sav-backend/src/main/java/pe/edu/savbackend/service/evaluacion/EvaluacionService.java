package pe.edu.savbackend.service.evaluacion;

import java.util.List;

import pe.edu.savbackend.domain.tarea.TareaDto;

public interface EvaluacionService {

	List<TareaDto> getLsTareas(Integer idEstudiante);
}
