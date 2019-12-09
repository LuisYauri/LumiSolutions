package pe.edu.savbackend.service.pregunta;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.PreguntaDao;

import pe.edu.savbackend.domain.PROFESOR.ProDetallePreguntaDto;
import pe.edu.savbackend.domain.PROFESOR.ProPreguntasDto;
import pe.edu.savbackend.entity.Pregunta;


@Service
public class PreguntaServiceImpl implements PreguntaService {

	@Autowired
	private PreguntaDao preguntaDao;

	@Override
	public HashMap<String, Boolean> getRespuesta(Integer idPregunta, String respuestaEstudiante) {
		// TODO Auto-generated method stub

		String resp = preguntaDao.findById(idPregunta).get().getRespuestaCorrecta();

		HashMap<String, Boolean> hm = new HashMap();

		if (respuestaEstudiante.equals(resp) == true) {
			hm.put("confirmacion", true);
			return hm;
		}
		hm.put("confirmacion", false);
		return hm;

	}

	@Override
	public List<ProPreguntasDto> filtrar(String grado, Integer idCriterio, Integer idContenido) {
		List<ProPreguntasDto> lsPreguntasDto = preguntaDao.obtenerTodos();
		return lsPreguntasDto.stream().filter(e -> grado == null || e.getGrado().equals(grado))
				.filter(e -> idCriterio == null || e.getIdCriterio() == idCriterio)
				.filter(e -> idContenido == null || e.getIdContenido() == idContenido).collect(Collectors.toList());
		// System.out.println(lsPreguntasDto);
		// return lsPreguntasDto;
	}

	@Override
	public ProDetallePreguntaDto obtenerPregunta(Integer idPregunta) {
		Pregunta pregunta = preguntaDao.getOne(idPregunta);
		return new ProDetallePreguntaDto(pregunta.getDescripcion (), pregunta.getUrlImagen());
	}

	

}
