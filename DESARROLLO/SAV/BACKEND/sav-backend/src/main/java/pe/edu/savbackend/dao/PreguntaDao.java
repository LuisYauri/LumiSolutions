package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.savbackend.entity.Pregunta;
/**
 * PreguntaDao
 */
public interface PreguntaDao extends JpaRepository<Pregunta, Integer>{

    
}