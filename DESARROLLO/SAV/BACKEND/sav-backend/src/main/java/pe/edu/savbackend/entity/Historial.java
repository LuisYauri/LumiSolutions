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
 * Historial
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "historiales")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Historial {

    //Llave primaria y foráneas
    @Id
	@Column(name="id_estudiante")
    private Integer idEstudiante;

    @Column(name="id_evaluacion")
    private Integer idEvaluacion;
    
    //Atributos
	@Column(name="json_completo")
	private String jsonCompleto;
    
    @Column(name="json_estadistica")
    private String jsonEstadistica;
    
    @Column(name="fecha_finalizacion")
	private LocalDateTime fechaFinalizacion;
}