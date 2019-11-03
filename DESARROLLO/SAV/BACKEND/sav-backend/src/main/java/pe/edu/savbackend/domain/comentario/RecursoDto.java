package pe.edu.savbackend.domain.comentario;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecursoDto {
	private Integer idRecurso;
	private String nombre;
	private String descripcion;
	private String tipo;// PDF/VIDEO
	private String urlRecurso; //
	private Integer alumnoCalificacion;
	private Double promedioCalificacion;
	private List<ComentarioResponse> lsComentarios;

	public RecursoDto(Integer idRecurso, String nombre, String descripcion, 
					  String tipo, String urlRecurso, Integer alumnoCalificacion, 
					  Double promedioCalificacion)
	{
		this.idRecurso = idRecurso;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.urlRecurso = urlRecurso; 
		this.alumnoCalificacion = alumnoCalificacion;
		this.promedioCalificacion = promedioCalificacion;
	}
	
}
