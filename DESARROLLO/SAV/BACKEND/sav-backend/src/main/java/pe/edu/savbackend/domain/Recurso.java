package pe.edu.savbackend.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recurso {
	private Integer idRecurso;
	private String nombre;
	private String descripcion;
	private String tipo;//PDF/VIDEO
	private String urlRecurso; //
	private Integer alumnoCalificacion;
	private Double promedioCalificacio;
	private List<ComentarioResponse> lsComentarios;
}
