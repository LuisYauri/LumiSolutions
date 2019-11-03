package pe.edu.savbackend.domain.tarea;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadisticaDto {

	private String nota; // mas de 70% = A, entre 50 y 70 es B y menos de 50 es C
	private String totalPreguntas;
	private List<TipoResultadoDto> lsTiposResultados;

	private String tipo; // puede ser examen o tarea
	// esto solo se envia para el historial de evaluaciones
	private Integer idEvaluacion;
	private Integer idEstudiante;
}
