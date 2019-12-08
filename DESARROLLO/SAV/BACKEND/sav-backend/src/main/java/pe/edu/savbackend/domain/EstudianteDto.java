package pe.edu.savbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstudianteDto {

	private Integer idEstudiante;
	private String nombre;
	private String aPaterno;
	private String aMaterno;
    private String usuario;
    private String contrasenia;
}
