package pe.edu.savbackend.domain.tarea;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.savbackend.domain.Test.TestBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pregunta {
	private String idPregunta;
	private String idRecurso;
	private String descripcion;
	private Integer tipo; // tipo 0 es para completar, tipo 1 para llenar // se maneja 5 alternativas
	private String urlImagen;
	private String[] alternativas;

	private String respuestaEstudiante;
	private String respuestaCorrecta;

}
