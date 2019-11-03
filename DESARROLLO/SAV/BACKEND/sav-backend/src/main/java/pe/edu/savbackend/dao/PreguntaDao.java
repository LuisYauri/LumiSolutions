package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.tarea.PreguntaDto;
import pe.edu.savbackend.entity.Pregunta;
/**
 * PreguntaDao
 */
public interface PreguntaDao extends JpaRepository<Pregunta, Integer>{


	@Query(value = "select new pe.edu.savbackend.domain.tarea.PreguntaDto(p.id, p.idRecurso,p.descripcion, p.urlImagen, p.tipo, p.respuestaCorrecta) from Pregunta p join EvaluacionDetalle ed on p.id = ed.idPregunta where ed.idEvaluacion = ?1")
	List<PreguntaDto> obtenerPreguntasPorIdTarea(Integer idTarea);
	
}