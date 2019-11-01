package pe.edu.savbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comentario {

	private Integer idComentario;
	private Integer idRecurso; // nombre apellido
	private Integer idEstudiante;
	private String descripcion;

}
