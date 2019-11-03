package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.savbackend.entity.Comentario;
/**
 * ComentarioDao
 */
public interface ComentarioDao extends JpaRepository<Comentario, Integer>{

    
}