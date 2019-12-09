package pe.edu.savbackend.domain.PROFESOR;

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
	private Integer cantidadPreguntas;

	public ProTareaDto (Integer idTarea, String titulo, Integer idCompetencia, String competencia, 
	Integer idContenido, String contenido, Integer cantidadPreguntas)
	{
		this.idTarea = idTarea;
		this.titulo = titulo;
		this.idCompetencia = idCompetencia;
		this.competencia = competencia;
		this.idContenido = idContenido;
		this.contenido = contenido;
		this.cantidadPreguntas = cantidadPreguntas;
	}
}
