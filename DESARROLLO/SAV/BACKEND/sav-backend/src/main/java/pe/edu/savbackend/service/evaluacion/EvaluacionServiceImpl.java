package pe.edu.savbackend.service.evaluacion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.EvaluacionDao;
import pe.edu.savbackend.dao.EvaluacionDetalleDao;
import pe.edu.savbackend.domain.tarea.TareaDto;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {

	@Autowired
	private EvaluacionDao evaluacionDao;
	@Autowired
	private EvaluacionDetalleDao evaluacionDetalleDao;

	@Override
	public List<TareaDto> getLsTareas(Integer idEstudiante) {
		//contar las tareas formatear la fecha 
		List<TareaDto> lsTarea = evaluacionDao.getLsTareas(idEstudiante);
		lsTarea.forEach(e->{
			LocalDateTime ldt = evaluacionDao.getOne(e.getIdTarea()).getFechaInicio();
			e.setCantidadPreguntas(evaluacionDetalleDao.cantidadPregunta(e.getIdTarea()).toString());
			e.setFechaLimite((ldt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
			e.setTiempoLimite((ldt.format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
		});
		return lsTarea;
	}

	

}
