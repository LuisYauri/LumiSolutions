package pe.edu.savbackend.domain.request;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.savbackend.domain.Test.TestBuilder;
import pe.edu.savbackend.domain.tarea.Pregunta;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComprobarPreguntaInput {
	private String respuesta;
}
