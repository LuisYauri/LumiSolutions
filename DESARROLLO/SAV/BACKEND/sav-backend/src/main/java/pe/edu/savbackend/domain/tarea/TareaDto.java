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
public class TareaDto {
	private Integer idTarea;
	private String titulo;
	private String cantidadPreguntas;
	private String fechaLimite;
	private String tiempoLimite;
	private String contenido;

	
	private Double duracion;
	
	private LocalDateTime fechaSolucion;
	private String fechaRealizada;
	private String horaRealizada;
	
	private Integer idEstudiante;
	private List<PreguntaDto> lsPreguntas;

	private EstadisticaDto estadistica;

	public TareaDto(Integer idTarea, String titulo, String contenido) {
		this.idTarea = idTarea;
		this.titulo = titulo;
		this.contenido = contenido;
	}
	
	public TareaDto(Integer idTarea, String titulo) {
		this.idTarea = idTarea;
		this.titulo = titulo;
	}
}
