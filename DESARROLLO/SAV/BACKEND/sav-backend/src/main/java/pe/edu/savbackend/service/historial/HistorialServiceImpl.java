package pe.edu.savbackend.service.historial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.EvaluacionDao;
import pe.edu.savbackend.dao.HistorialDao;
import pe.edu.savbackend.domain.tarea.HistorialDto;
import pe.edu.savbackend.domain.tarea.TareaDto;

@Service
public class HistorialServiceImpl implements HistorialService {

	@Autowired
	private HistorialDao historialDao;

	@Override
	public List<HistorialDto> getAll(Integer idEstudiante, String fecha) {
		//contar las tareas formatear la fecha 
		
		return null;
	}


}
