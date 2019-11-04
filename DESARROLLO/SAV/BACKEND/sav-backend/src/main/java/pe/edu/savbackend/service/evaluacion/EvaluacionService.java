package pe.edu.savbackend.service.evaluacion;

import java.util.List;

import pe.edu.savbackend.domain.tarea.EstadisticaDto;
import pe.edu.savbackend.domain.tarea.ExamenDto;
import pe.edu.savbackend.domain.tarea.TareaDto;

public interface EvaluacionService {
 
	List<TareaDto> getLsTareas(Integer idEstudiante);
	List<ExamenDto> getLsExamenes(Integer idEstudiante);
	
	TareaDto getPreguntasPorTarea(Integer idTarea);
	
	EstadisticaDto finalizarTarea(TareaDto tareaDto);
}
