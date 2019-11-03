package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.entity.Comentario;
/**
 * ComentarioDao
 */
public interface ComentarioDao extends JpaRepository<Comentario, Integer>{

	@Query(value = "select max(c.id)+ 1 from Comentario c")
	Integer nextId();
}