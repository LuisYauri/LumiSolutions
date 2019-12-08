package pe.edu.savbackend.domain.auxiliar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatriculaAux {

	private Integer id_estudiante;
	private String nombre;
	private String codGrado;
	private String anio;
	private String codEstado;
	
	public MatriculaAux(Integer id_estudiante, String nombre, String codGrado, String anio, String codEstado) {
		this.id_estudiante = id_estudiante;
		this.nombre = nombre;
		this.codGrado = codGrado;
		this.anio = anio;
		this.codEstado = codEstado;
	}
	
	

}
