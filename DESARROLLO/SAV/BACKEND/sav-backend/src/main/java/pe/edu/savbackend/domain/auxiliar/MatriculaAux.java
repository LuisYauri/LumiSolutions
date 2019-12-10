package pe.edu.savbackend.domain.auxiliar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatriculaAux {

	private Integer idEstudiante;
	private String nombre;
	private String codGrado;
	private Integer anio;
	private String codEstado;
	public MatriculaAux(Integer idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	
//	descomentar si se agrega algun atributo
//	public MatriculaAux(Integer idEstudiante, String nombre, String codGrado, Integer anio, String codEstado) {
//		this.idEstudiante = idEstudiante;
//		this.nombre = nombre;
//		this.codGrado = codGrado;
//		this.anio = anio;
//		this.codEstado = codEstado;
//	}
	
	

}
