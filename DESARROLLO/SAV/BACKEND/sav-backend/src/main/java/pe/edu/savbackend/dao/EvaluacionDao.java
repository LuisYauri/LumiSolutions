package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.tarea.TareaDto;
import pe.edu.savbackend.entity.Evaluacion;

/**
 * EvaluacionDao
 */
public interface EvaluacionDao extends JpaRepository<Evaluacion, Integer>{
	@Query(value = "select new pe.edu.savbackend.domain.tarea.TareaDto(e.idEvaluacion,e.titulo) from Evaluacion e join EstudianteEvaluacion ee on e.idEvaluacion = ee.idEvaluacion where ee.idEstudiante = ?1")
	List<TareaDto> getLsTareas(Integer idEstudiante);
}