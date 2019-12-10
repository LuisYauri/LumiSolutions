package pe.edu.savbackend.domain.PROFESOR;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProPreguntasDto {
	private Boolean marcado;
	private Integer idPregunta;
	private String descripcion;
	private Integer idCriterio;
	private String nombreCriterio;
	private Integer idContenido;
	private String nombreContenido;
	private String grado;

	public ProPreguntasDto(Integer idPregunta, String descripcion, Integer idCriterio, String nombreCriterio,
			Integer idContenido, String nombreContenido, String grado) {
		marcado = false;
		this.idPregunta = idPregunta;
		this.descripcion = descripcion;
		this.idCriterio = idCriterio;
		this.nombreCriterio = nombreCriterio;
		this.idContenido = idContenido;
		this.nombreContenido = nombreContenido;
		this.grado = grado;
	}

}
