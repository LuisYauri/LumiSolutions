package pe.edu.savbackend.service.evaluacion;

import java.util.List;

import pe.edu.savbackend.domain.PROFESOR.ProCrearTareaDto;
import pe.edu.savbackend.domain.PROFESOR.ProTareaDto;
import pe.edu.savbackend.domain.tarea.EstadisticaDto;
import pe.edu.savbackend.domain.tarea.ExamenDto;
import pe.edu.savbackend.domain.tarea.TareaDto;
import pe.edu.savbackend.entity.Evaluacion;

public interface EvaluacionService {
 
	List<TareaDto> getLsTareas(Integer idEstudiante);
	List<ExamenDto> getLsExamenes(Integer idEstudiante);
	
	TareaDto getPreguntasPorTarea(Integer idTarea);
	ExamenDto getPreguntasPorExamen(Integer idExamen);
	
	EstadisticaDto finalizarTarea(TareaDto tareaDto);
	EstadisticaDto finalizarExamen(ExamenDto examenDto);

	List<ProTareaDto> getLsTareasAsignadas(Integer idAula);

	Evaluacion registrarTarea(ProCrearTareaDto tarea);

	Boolean eliminarTarea(Integer idTarea);
}
