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
 * Comentario
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "comentarios")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Comentario {
	//Llave primaria
    @Id
	@Column(name="id")
	private Integer idComentario;

	//Llaves foráneas
	@Column(name="id_recurso")
    private Integer idRecurso;
    
    @Column(name="id_estudiante")
	private Integer idEstudiante;
	
	//atributos
	@Column(name="descripcion")
	private String descripcion;
    
	@Column(name="fecha")
	private LocalDateTime fecha;
}