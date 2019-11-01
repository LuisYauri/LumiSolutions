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
 * Pregunta
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "preguntas")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Pregunta {

	//Llave primaria
    @Id
	@Column(name="id")
	private Integer id;
	
	//Llaves foráneas
	@Column(name="id_recurso")
    private Integer idRecurso;

	@Column(name="id_profesor")
	private Integer idProfesor;

	@Column(name="id_contenido")
	private Integer idContenido;
	
	//Atributos
	@Column(name="descripcion")
	private String descripcion;

	@Column(name="puntaje")
	private String puntaje;

	@Column(name="cod_estado")
	private String codigoEstado;
	
	@Column(name="respuestaCorrecta")
	private String respuestaCorrecta;
	
	@Column(name="url_imagen")
	private String urlImagen;
}