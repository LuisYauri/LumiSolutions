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
@Table(name = "grupos")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Grupo {
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="cod_grado")
	private String codigoGrado;
	
	@Column(name="anio")
	private LocalDateTime anio;
	
	@Column(name="cod_estado")
	private String codigoEstado;
	
	@Column(name="id_docente")
	private String idDocente;
}
