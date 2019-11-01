package pe.edu.savbackend.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.savbackend.domain.tarea.Examen;
import pe.edu.savbackend.domain.tarea.Tarea;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DatosEstudiante {
	private Integer id;
	
	private String nombre;
	
	private String apellido_paterno;
    
    private String apellido_materno;
    
    private Integer numero_celular;
    
    private String correo;
    
	private String username;

	private String correoApoderado;
}