package pe.edu.savbackend.domain.PROFESOR;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProEstudiantePorMatricularDto {

	private Boolean marcado;
	private Integer idEstudiante;
	private String nombre;
	private String apaterno;
	private String amaterno;
    private String usuario;
    
	public ProEstudiantePorMatricularDto(Integer idEstudiante, String nombre, String apaterno, String amaterno,
			String usuario) {
		this.marcado = false;
		this.idEstudiante = idEstudiante;
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.usuario = usuario;
	}
    
    
}
