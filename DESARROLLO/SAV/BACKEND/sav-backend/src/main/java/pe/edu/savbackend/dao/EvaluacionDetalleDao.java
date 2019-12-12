package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.savbackend.entity.EvaluacionDetalle;
/**
 * EvaluacionDetalleDao
 */
public interface EvaluacionDetalleDao extends JpaRepository<EvaluacionDetalle, Integer>{

        @Query(value = "select count(*) from EvaluacionDetalle ed where ed.idEvaluacion = ?1")
        Integer cantidadPregunta(Integer idEvaluacion);

        @Modifying
        @Transactional
        @Query(value = "insert into evaluacion_detalles values (:id_evaluacion,:id_pregunta)", nativeQuery = true)
        void registrarEvaluacionDetalle(@Param("id_evaluacion") Integer idEvaluacion, @Param("id_pregunta") Integer idPregunta);

}