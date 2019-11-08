package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.tarea.ExamenDto;
import pe.edu.savbackend.domain.tarea.TareaDto;
import pe.edu.savbackend.entity.Evaluacion;

/**
 * EvaluacionDao
 */
public interface EvaluacionDao extends JpaRepository<Evaluacion, Integer>{
	@Query(value = "select new pe.edu.savbackend.domain.tarea.TareaDto(e.idEvaluacion,e.titulo,c.nombre) "
			+ "from Evaluacion e "
			+ "join EstudianteEvaluacion ee on e.idEvaluacion = ee.idEvaluacion "
			+ "join Contenido c on c.idContenido= e.idContenido "
			+ "where ee.idEstudiante = ?1 "
			+ "and e.codTipoEvaluacion = 'T'")
	List<TareaDto> getLsTareas(Integer idEstudiante);
	
	@Query(value = "select new pe.edu.savbackend.domain.tarea.ExamenDto(e.idEvaluacion,e.titulo) "
			+ "from Evaluacion e "
			+ "join EstudianteEvaluacion ee on e.idEvaluacion = ee.idEvaluacion "
			+ "where ee.idEstudiante = ?1 "
			+ "and e.codTipoEvaluacion = 'E'")
	List<ExamenDto> getLsExamenes(Integer idEstudiante);
}