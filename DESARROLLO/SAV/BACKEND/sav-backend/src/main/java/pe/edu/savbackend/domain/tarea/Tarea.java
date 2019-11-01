package pe.edu.savbackend.domain.tarea;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.savbackend.domain.Test.TestBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tarea {
	private Integer idTarea;
	private String titulo;
	private String cantidadPreguntas;
	private String fechaLimite;
	private String tiempoLimite;
	private String contenido;

	private Date fechaSolucion;
	private Integer idEstudiante;
	private List<Pregunta> lsPreguntas;

	private Estadistica estadistica;
}
