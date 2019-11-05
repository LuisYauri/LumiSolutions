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
 * Alternativa
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "alternativas")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Alternativa {
	//Llave primaria
    @Id
	@Column(name="id")
	private Integer idAlternativa;

	//Llave foránea
	@Column(name="id_pregunta")
	private Integer idPregunta;

	//Atributos
	@Column(name="descripcion")
	private String descripcion;
	
    
}