package pe.edu.savbackend.domain.tarea;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.savbackend.domain.tarea.Tarea.TareaBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Examen {
	private Integer idExamen;
	private Integer idEvaluacion; // idEslaucio e idExamen contienen lo mismo
	private String titulo;
	private String cantidadPreguntas;
	private String fechaInico;
	private String horaInicio;
	private Integer duracion; // en minutos

	private Date fechaSolucion;
	private Integer idEstudiante;
	private List<Pregunta> lsPreguntas;

}
