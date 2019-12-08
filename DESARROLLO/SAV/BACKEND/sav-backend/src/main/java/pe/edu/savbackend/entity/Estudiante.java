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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "estudiantes")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Estudiante {
	@Id
	@Column(name="id")
	private Integer idEstudiante;
	@Column(name="id_persona")
	private Integer idPersona;
	@Column(name="correo_apoderado")
	private String correoApoderado;
}
