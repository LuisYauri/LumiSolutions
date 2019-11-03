package pe.edu.savbackend.service.evaluacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.EvaluacionDao;
import pe.edu.savbackend.domain.tarea.TareaDto;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {

	@Autowired
	private EvaluacionDao evaluacionDao;

	@Override
	public List<TareaDto> getLsTareas(Integer idEstudiante) {
		//contar las tareas formatear la fecha 
		
		return evaluacionDao.getLsTareas(idEstudiante);
	}

	

}
