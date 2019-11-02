package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.tarea.Tarea;
import pe.edu.savbackend.entity.Evaluacion;

/**
 * EvaluacionDao
 */
public interface EvaluacionDao extends JpaRepository<Evaluacion, Integer>{

    //select b.fname, b.lname from Users b JOIN Groups c where c.groupName = :groupName
    @Query(value = "select new pe.edu.savbackend.domain.tarea.Tarea(e.titulo, h.idEstudiante) from Evaluacion e join Historial h on e.id = h.idEvaluacion where h.idEstudiante = ?1")
    List<Tarea> ejemplo(Integer idEstudiante);
    
}