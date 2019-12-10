package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.entity.Calificacion;


public interface CalificacionDao extends JpaRepository<Calificacion, Integer> {
	
	@Query(value = "select avg(c.calificacion) from Calificacion c where c.idRecurso = ?1")
	Double obtenerCalificacionPromedio(Integer idRecurso);
	
	@Query(value = "select c.calificacion from Calificacion c where c.idRecurso = ?1 and c.idEstudiante = ?2")
	Integer obtenerCalificacionPorEstudiante(Integer idRecurso,Integer idEstudiante);
}
