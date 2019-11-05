package pe.edu.savbackend.service.historial;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import pe.edu.savbackend.dao.HistorialDao;
import pe.edu.savbackend.domain.tarea.EstadisticaDto;
import pe.edu.savbackend.domain.tarea.ExamenDto;
import pe.edu.savbackend.domain.tarea.HistorialDto;
import pe.edu.savbackend.domain.tarea.TareaDto;
import pe.edu.savbackend.entity.Historial;

@Service
public class HistorialServiceImpl implements HistorialService {

	@Autowired
	private HistorialDao historialDao;

	
	Gson gson = new Gson();

	
	@Override
	public HistorialDto obtenerHistorialTareasExamenes(Integer idEstudiante, LocalDate fecha) {
		HistorialDto historialDto = new HistorialDto();
		List<TareaDto> lsTareaDto = new ArrayList<>();
		List<ExamenDto> lsExamenDto= new ArrayList<>();
		historialDao.obtenerPorIdEstudiante(idEstudiante).forEach(historial -> {
		
			if(historial.getTipoEvaluacion().equals("T")){
				TareaDto tareaDto = gson.fromJson(historial.getJsonCompleto(), TareaDto.class);
				tareaDto.setLsPreguntas(null);
				tareaDto.setFechaRealizada(tareaDto.getFechaSolucion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				tareaDto.setHoraRealizada(tareaDto.getFechaSolucion().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
				lsTareaDto.add(tareaDto);
			} else if (historial.getTipoEvaluacion().equals("E")) {
				ExamenDto examenDto = gson.fromJson(historial.getJsonCompleto(), ExamenDto.class);
				examenDto.setLsPreguntas(null);
				examenDto.setFechaRealizada(examenDto.getFechaSolucion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				examenDto.setHoraRealizada(examenDto.getFechaSolucion().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
				lsExamenDto.add(examenDto);
			}
			
		});;
		historialDto.setLsExamenes(lsExamenDto);
		historialDto.setLsTareas(lsTareaDto);
		return historialDto;
	}
	
	@Override
	public ExamenDto obtenerHistorialPreguntas(Integer idEstudiante, Integer idEvaluacion) {
		Historial historial = historialDao.obtenerPorIds(idEstudiante, idEvaluacion);
		ExamenDto examenDto = gson.fromJson(historial.getJsonCompleto(), ExamenDto.class);
		examenDto.setIdEvaluacion(idEvaluacion);
		return examenDto;
	}

	@Override
	public EstadisticaDto obtenerEstadisticaEvaluacion(Integer idEstudiante, Integer idEvaluacion) {
		Historial historial = historialDao.obtenerPorIds(idEstudiante, idEvaluacion);
		return gson.fromJson(historial.getJsonEstadistica(), EstadisticaDto.class);
	}

	
}
