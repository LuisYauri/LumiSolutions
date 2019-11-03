package pe.edu.savbackend.service.pregunta;

import java.util.HashMap;
import java.util.List;

import pe.edu.savbackend.domain.ContenidoDto;

public interface PreguntaService {

	HashMap<String, Boolean> getRespuesta(Integer idPregunta, String respuestaEstudiante);
}
