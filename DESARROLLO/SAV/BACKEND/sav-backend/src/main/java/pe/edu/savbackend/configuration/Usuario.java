package pe.edu.savbackend.configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.savbackend.domain.Calificacion;
import pe.edu.savbackend.domain.Calificacion.CalificacionBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
	private String usuario;
	private String contrasena;
}
