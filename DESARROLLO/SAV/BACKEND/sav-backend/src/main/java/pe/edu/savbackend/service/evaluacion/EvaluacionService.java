package pe.edu.savbackend.service.evaluacion;

import java.util.List;

import pe.edu.savbackend.domain.tarea.EstadisticaDto;
import pe.edu.savbackend.domain.tarea.TareaDto;

public interface EvaluacionService {
 
	List<TareaDto> getLsTareas(Integer idEstudiante);
	
	TareaDto getPreguntasPorTarea(Integer idTarea);
	
	EstadisticaDto finalizarTarea(TareaDto tareaDto);
}
