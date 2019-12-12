package pe.edu.savbackend.service.pregunta;

import java.util.HashMap;
import java.util.List;

import pe.edu.savbackend.domain.PROFESOR.ProDetallePreguntaDto;
import pe.edu.savbackend.domain.PROFESOR.ProPreguntasDto;

public interface PreguntaService {

	HashMap<String, Boolean> getRespuesta(Integer idPregunta, String respuestaEstudiante);
	
	List<ProPreguntasDto> filtrar(String grado,Integer idCriterio,Integer idContenido);

	ProDetallePreguntaDto obtenerPregunta(Integer idPregunta);

}
