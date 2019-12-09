package pe.edu.savbackend.domain.PROFESOR;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProTareaDto {
	private Integer idTarea;
	private String titulo;
	private Integer idCompetencia;
	private String competencia;
	private Integer idContenido;
	private String contenido; 
	private String fechaInicio;  
	private String fechaLimite; //"20/12/19"
	private String tiempoLimite;
	private Integer cantidad;
	private Integer cantidadPreguntas;

}
