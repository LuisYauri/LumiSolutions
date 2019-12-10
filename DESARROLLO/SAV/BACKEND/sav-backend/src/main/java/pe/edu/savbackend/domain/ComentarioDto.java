package pe.edu.savbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComentarioDto {

	private Integer idComentario;
	private Integer idRecurso; 
	private Integer idEstudiante;
	private String descripcion;

}
