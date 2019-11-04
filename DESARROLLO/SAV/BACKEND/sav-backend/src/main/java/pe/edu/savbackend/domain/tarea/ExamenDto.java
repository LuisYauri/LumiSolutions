package pe.edu.savbackend.domain.tarea;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamenDto {
	private Integer idExamen;
	private String titulo;
	private String cantidadPreguntas;
	private String fechaInico;
	private String horaInicio;
	private Integer duracion; // en minutos

	private LocalDateTime fechaSolucion;
	private String fechaRealizada;
	private String horaRealizada;
	
	private Integer idEstudiante;
	private List<PreguntaDto> lsPreguntas;

	
	private Integer idEvaluacion; // idEslaucio e idExamen contienen lo mismo


	public ExamenDto(Integer idExamen, String titulo) {
		this.idExamen = idExamen;
		this.titulo = titulo;
	}
	
	

}
