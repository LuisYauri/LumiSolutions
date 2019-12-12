package pe.edu.savbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CalificacionDto {

	private Integer idCalificacion;
	private Integer calificacion;
	private Integer idRecurso; 
	private Integer idEstudiante;

}
