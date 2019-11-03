package pe.edu.savbackend.domain.tarea;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoResultadoDto {
	private String tipo; // "Correcto, Incorrecto, Sin responder
	private Integer porcentaje;
	private Integer cantidad;
}
