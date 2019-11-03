package pe.edu.savbackend.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * EstudianteEvaluacion
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "estudiante_evaluaciones")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class EstudianteEvaluacion {

    //Llaves primarias y foráneas
    @Id
    @Column(name="id_estudiante")
    private Integer idEstudiante;

    @Column(name="id_evaluacion")
    private Integer idEvaluacion;

    @Column(name="id_area")
    private Integer idArea;
    
    //Atributos
	@Column(name="nota")
    private String nota;

    @Column(name="fecha_entrega")
    private LocalDateTime fechaEntrega;

    @Column(name="cod_estado_evaluacion")
    private String codigoEstadoEvaluacion;    
    
}