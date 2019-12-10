package pe.edu.savbackend.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Matricula
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "matriculas")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Matricula {

    //Llave primaria
    @Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idMatricula;
    
    //Llaves foráneas	
	@Column(name="id_estudiante")
	private Integer idEstudiante;
	
	@Column(name="id_grupo")
	private Integer idGrupo;	
	
	@Column(name="fecha_matricula")
	private LocalDateTime fechaMatricula;
}