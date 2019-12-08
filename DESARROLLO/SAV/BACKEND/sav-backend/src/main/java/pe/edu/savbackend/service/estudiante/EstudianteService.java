package pe.edu.savbackend.service.estudiante;

import java.util.List;

import pe.edu.savbackend.domain.EstudianteDto;
import pe.edu.savbackend.entity.Estudiante;

public interface EstudianteService {
 
	List<EstudianteDto> getLsEstudiantes();

	Estudiante registrarEstudiante(EstudianteDto estudiante);
	
	Estudiante actualizarEstudiante(EstudianteDto estudiante);
	
	Boolean eliminarEstudiante(Integer idEstudiante);
}
