package pe.edu.savbackend.domain.tarea;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreguntaDto {
	private Integer idPregunta;
	private Integer idRecurso;
	private String descripcion;
	private String tipo; // tipo 0 es para completar, tipo 1 para llenar // se maneja 5 alternativas
	private String urlImagen;
	private String[] alternativas;

	private String respuestaEstudiante;
	private String respuestaCorrecta;
	
	public PreguntaDto(Integer idPregunta, Integer idRecurso, String descripcion, String urlImagen , String tipo, String respuestaCorrecta) {
		this.idPregunta = idPregunta;
		this.idRecurso = idRecurso;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.urlImagen = urlImagen;
		this.respuestaCorrecta = respuestaCorrecta;
	}

	
	

	
}
