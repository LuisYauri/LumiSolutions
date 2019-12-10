package pe.edu.savbackend.domain.PROFESOR;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProEstudianteDto {
	private Integer idEstudiante;
	private String nombre;
	private String apaterno;
	private String amaterno;
	private String username;
	private String fechaMatricula; // "20/12/19"
//	public ProEstudianteDto(Integer idEstudiante, String nombre, String apaterno, String amaterno, String username,String fechaMatricula) {
//		this.idEstudiante = idEstudiante;
//		this.nombre = nombre;
//		this.apaterno = apaterno;
//		this.amaterno = amaterno;
//		this.username = username;
//		this.fechaMatricula = fechaMatricula;
//	}

}
