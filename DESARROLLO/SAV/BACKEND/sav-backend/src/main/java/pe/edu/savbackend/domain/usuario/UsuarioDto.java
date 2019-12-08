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

	private Integer id;
	private String username;
	private String apellidoPaterno;
	private String nombres;
	private String siglas;
	private String tipoPersona;
	private Integer codigoGrado;
	private String seccion;
	private String anio;
	
	public UsuarioDto(Long id, String username, String apellidoPaterno, String nombres, String tipoPersona) {
		this.id = id.intValue();
		this.username = username;
		this.apellidoPaterno = apellidoPaterno;
		this.nombres = nombres;
		this.tipoPersona = tipoPersona;
	}
		
}
