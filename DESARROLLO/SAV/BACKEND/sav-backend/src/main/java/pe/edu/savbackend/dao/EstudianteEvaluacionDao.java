package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.entity.EstudianteEvaluacion;
import pe.edu.savbackend.entity.Historial;
/**
 * EstudianteEvaluacionDao
 */
public interface EstudianteEvaluacionDao extends JpaRepository<EstudianteEvaluacion, Integer>{

	@Query(value = "select ee "
			+ " from EstudianteEvaluacion ee "
			+ "where ee.idEstudiante = ?1 and ee.idEvaluacion = ?2")
	EstudianteEvaluacion obtenerEstudianteEvaluacion(Integer idEstudiante, Integer idEvaluacion);
    
}