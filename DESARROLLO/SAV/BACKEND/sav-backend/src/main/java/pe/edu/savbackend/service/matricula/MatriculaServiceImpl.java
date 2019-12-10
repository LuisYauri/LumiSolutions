package pe.edu.savbackend.service.matricula;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.SimpleFormatter;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.MatriculaDao;
import pe.edu.savbackend.entity.Matricula;

@Service
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	private MatriculaDao matriculaDao;

	@Override
	@Transactional	
	public void matricular(Integer idAula, Integer[] idEstudiantes) {
		LocalDateTime fechaMatricula = LocalDateTime.now(ZoneId.of("America/Lima"));
		System.out.println(fechaMatricula);
		for(int i = 0 ; i < idEstudiantes.length ; i++) {
			matriculaDao.save(Matricula.builder().idGrupo(idAula).idEstudiante(idEstudiantes[i]).fechaMatricula(fechaMatricula).build());
		}
	}
	
	

}
