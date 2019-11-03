package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.comentario.ComentarioResponse;
import pe.edu.savbackend.entity.Pregunta;
/**
 * PreguntaDao
 */
public interface PreguntaDao extends JpaRepository<Pregunta, Integer>{

}