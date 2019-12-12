package pe.edu.savbackend.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.PROFESOR.ProTareaDto;
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
			+ "and e.codTipoEvaluacion = 'T' "
			+ "and ee.codigoEstadoEvaluacion = 1 and e.fechaInicio <= ?2 and e.fechaFin >= ?2")
	List<TareaDto> getLsTareas(Integer idEstudiante, LocalDateTime fechaActual);
	
	@Query(value = "select new pe.edu.savbackend.domain.tarea.ExamenDto(e.idEvaluacion,e.titulo) "
			+ "from Evaluacion e "
			+ "join EstudianteEvaluacion ee on e.idEvaluacion = ee.idEvaluacion "
			+ "where ee.idEstudiante = ?1 "
			+ "and e.codTipoEvaluacion = 'E' "
			+ "and ee.codigoEstadoEvaluacion = 1")
	List<ExamenDto> getLsExamenes(Integer idEstudiante);

	@Query(value = "select e "
			+ "from Evaluacion e "
			+ "join EstudianteEvaluacion ee on e.idEvaluacion = ee.idEvaluacion "
			+ "where ee.idEstudiante = ?1 "
			+ "and e.codTipoEvaluacion = 'E' "
			+ "and ee.codigoEstadoEvaluacion = 1")
	List<Evaluacion> getLsExamenesModel(Integer idEstudiante);

	@Query(value = "select new pe.edu.savbackend.domain.PROFESOR.ProTareaDto( "
				 + "e.idEvaluacion, e.titulo, c.idCriterio, cr.nombre, "
				 + "c.idContenido, c.nombre, e.cantidad) From Evaluacion e "
				 + "inner join Contenido c on e.idContenido = c.idContenido " 
				 + "inner join Criterio cr on c.idCriterio = cr.idCriterio " 
				 + "where e.idGrupo = ?1 and e.codTipoEvaluacion = ?2 and e.codigoEstado= 1" 
	)
	List<ProTareaDto> getLsTareasAsignadas(Integer idAula, String tipoEvaluacion);

	@Query(value = "select e from Evaluacion e where e.idEvaluacion=?1")
	Evaluacion getEvaluacion(Integer idvaluacion);

	@Query(value = "select max(e.idEvaluacion)+ 1 from Evaluacion e")
	Integer nextId();
	
	@Query(value = "select e from Evaluacion e where e.idGrupo =?1")
	List<Evaluacion> getEvaluacionesGrupo(Integer idGrupo);
}