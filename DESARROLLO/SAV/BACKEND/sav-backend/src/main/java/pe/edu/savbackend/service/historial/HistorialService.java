package pe.edu.savbackend.service.historial;

import java.util.List;

import pe.edu.savbackend.domain.tarea.HistorialDto;

public interface HistorialService {

	List<HistorialDto> getAll(Integer idEstudiante, String fecha);
}
