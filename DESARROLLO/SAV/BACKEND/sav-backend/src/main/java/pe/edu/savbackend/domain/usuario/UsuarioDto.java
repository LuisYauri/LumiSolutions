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
	private Integer codigoGrado; 
	private String apellidoPaterno;
	private String nombres;
	private String siglas;
	private String seccion;
	private String anio;
		
}
