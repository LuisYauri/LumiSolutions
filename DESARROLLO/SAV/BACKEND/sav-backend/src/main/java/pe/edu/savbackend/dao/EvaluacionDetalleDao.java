package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.entity.EvaluacionDetalle;
/**
 * EvaluacionDetalleDao
 */
public interface EvaluacionDetalleDao extends JpaRepository<EvaluacionDetalle, Integer>{

        @Query(value = "select count(*) from EvaluacionDetalle ed where ed.idEvaluacion = ?1")
        Integer cantidadPregunta(Integer idEvaluacion);
}