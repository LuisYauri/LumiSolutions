package pe.edu.savbackend.domain.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDto {

	private Integer id; //idEstudiante
	private String username;
	private String apellidoPaterno;
	private String nombres;
	private String siglas;
	private String tipoPersona;
	private String codigoGrado;
	private String seccion;
	private Integer anio;
	
	public UsuarioDto(Integer id, String username, String apellidoPaterno, String nombres, String tipoPersona) {
		this.id = id;
		this.username = username;
		this.apellidoPaterno = apellidoPaterno;
		this.nombres = nombres;
		this.tipoPersona = tipoPersona;
	}
		
}
