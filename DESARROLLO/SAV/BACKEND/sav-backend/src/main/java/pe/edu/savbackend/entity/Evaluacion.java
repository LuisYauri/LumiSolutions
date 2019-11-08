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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "evaluaciones")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Evaluacion {
    @Id
    @Column(name="id")
    private Integer idEvaluacion;
    
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="descripcion")
	private String descripcion;
	
    @Column(name="fecha_inicio")
    private LocalDateTime fechaInicio;
    
    @Column(name="fecha_fin")
    private LocalDateTime fechaFin;
    
    @Column(name="cod_tipo_evaluacion")
	private String codTipoEvaluacion;
    
    @Column(name="id_docente")
	private Integer idDocente;
    
    @Column(name="cantidad")
	private Integer cantidad;

    @Column(name="id_contenido")
	private Integer idContenido;
}