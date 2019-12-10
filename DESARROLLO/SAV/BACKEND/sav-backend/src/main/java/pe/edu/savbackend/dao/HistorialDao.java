package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.entity.Historial;
/**
 * HistorialDao
 */
public interface HistorialDao extends JpaRepository<Historial, Integer>{
	@Query(value = "select h "
			+ " from Historial h "
			+ "where h.idEstudiante = ?1 and h.idEvaluacion = ?2")
	Historial obtenerPorIds(Integer idEstudiante, Integer idEvaluacion);
	
	@Query(value = "select h "
			+ " from Historial h "
			+ "where h.idEstudiante = ?1")
	List<Historial> obtenerPorIdEstudiante(Integer idEstudiante);
}