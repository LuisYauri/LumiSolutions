package pe.edu.savbackend.domain.comentario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComentarioResponse {

	private Integer idEstudiante;
	private String inicialesEstudiante; // nombre apellido en mayuscula
	private String apellidoPaternoEstudiante;
	private String nombreEstudiante;
	private String descripcion;

}
