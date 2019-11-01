package pe.edu.savbackend.domain.tarea;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.savbackend.domain.tarea.Tarea.TareaBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoResultado {
	private String tipo; // "Correcto, Incorrecto, Sin responder
	private Integer porcentaje;
	private Integer cantidad;
}
