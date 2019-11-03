package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.ContenidoDto;
import pe.edu.savbackend.entity.Calificacion;


public interface CalificacionDao extends JpaRepository<Calificacion, Integer> {
	
	@Query(value = "select max(c.idCalificacion)+ 1 from Calificacion c")
	Integer nextId();

}
