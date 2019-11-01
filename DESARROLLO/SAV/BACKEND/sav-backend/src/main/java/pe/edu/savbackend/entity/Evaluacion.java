package pe.edu.savbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "evaluaciones")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Evaluacion {
    @Id
    private Integer id;
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="descripcion")
	private String descripcion;
	
    @Column(name="fecha_inicio")
    private String fechaInicio;
    
    @Column(name="fecha_fin")
    private Integer fechaFin;
    
    @Column(name="cod_tipo_evaluacion")
	private String codTipoEvaluacion;
    
    @Column(name="id_docente")
	private Integer idDocente;
    
    @Column(name="cantidad")
	private Integer cantidad;

}