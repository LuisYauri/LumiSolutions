package pe.edu.savbackend.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pe.edu.savbackend.domain.Persona;
import pe.edu.savbackend.domain.Persona.PersonaBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExampleRequest {
	private String nombre;
	private String apellido;
}
