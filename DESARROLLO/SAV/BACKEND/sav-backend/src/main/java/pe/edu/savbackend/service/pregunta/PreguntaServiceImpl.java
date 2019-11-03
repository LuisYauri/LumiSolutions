package pe.edu.savbackend.service.pregunta;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.PreguntaDao;

@Service
public class PreguntaServiceImpl implements PreguntaService {

	@Autowired
	private PreguntaDao preguntaDao;
	
	@Override
	public HashMap<String, Boolean> getRespuesta(Integer idPregunta, String respuestaEstudiante) {
		// TODO Auto-generated method stub
		
		String resp = preguntaDao.findById(idPregunta).get().getRespuestaCorrecta();
		
		HashMap<String, Boolean> hm = new HashMap();
		
		if(respuestaEstudiante.equals(resp) == true) {
			hm.put("confirmacion", true);
			return hm;
		}
		hm.put("confirmacion", false);
		return hm;
		
	}


	

}
