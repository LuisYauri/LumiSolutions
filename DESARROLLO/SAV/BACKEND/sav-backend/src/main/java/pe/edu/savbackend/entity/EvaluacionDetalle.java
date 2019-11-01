package pe.edu.savbackend.entity;

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
 * EvaluacionDetalle
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "evaluacion_detalles")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class EvaluacionDetalle {

    //Llaves primarias y foráneas
    @Id
	@Column(name="id_evaluacion")
    private Integer idEvaluacion;
	@Column(name="id_pregunta")
	private Integer idPregunta;
    
}