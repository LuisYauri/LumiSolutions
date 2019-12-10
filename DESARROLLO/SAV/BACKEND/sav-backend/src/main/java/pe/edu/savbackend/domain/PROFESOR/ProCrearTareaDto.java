package pe.edu.savbackend.domain.PROFESOR;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProCrearTareaDto {
	private String titulo;
	private Integer idCompetencia;
	private Integer idContenido;
	private String fechaInicio;  
	private String fechaLimite; //"20/12/19"
    private String tiempoLimite;
    private Integer idAula;
	private List<Integer> lsPreguntas;

	/* public ProCrearTareaDto (Integer idTarea, String titulo, Integer idCompetencia, String competencia, 
	Integer idContenido, String contenido, Integer cantidadPreguntas)
	{
		this.idTarea = idTarea;
		this.titulo = titulo;
		this.idCompetencia = idCompetencia;
		this.competencia = competencia;
		this.idContenido = idContenido;
		this.contenido = contenido;
		this.cantidadPreguntas = cantidadPreguntas;
	} */
}
