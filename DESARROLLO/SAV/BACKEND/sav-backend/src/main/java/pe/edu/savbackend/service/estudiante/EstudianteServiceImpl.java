package pe.edu.savbackend.service.estudiante;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.EstudianteDao;
import pe.edu.savbackend.dao.PersonaDao;
import pe.edu.savbackend.dao.UsuarioDao;
import pe.edu.savbackend.domain.EstudianteDto;
import pe.edu.savbackend.domain.PROFESOR.ProEstudianteDto;
import pe.edu.savbackend.domain.PROFESOR.ProEstudiantePorMatricularDto;
import pe.edu.savbackend.entity.Estudiante;
import pe.edu.savbackend.entity.Persona;
import pe.edu.savbackend.entity.Usuario;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	EstudianteDao estudianteDao;

	@Autowired
	PersonaDao personaDao;

	@Autowired
	UsuarioDao usuarioDao;

	@Autowired
	BCryptPasswordEncoder encript;

	@Override
	public List<EstudianteDto> getLsEstudiantes() {
		return estudianteDao.obtenerListaAlumnos();
	}

	
	@Override
	@Transactional
	public Estudiante registrarEstudiante(EstudianteDto estudiante) {
			Usuario usuarioBD = new Usuario();
			usuarioBD.setUsername(estudiante.getUsuario());
			usuarioBD.setPassword(encript.encode(estudiante.getContrasenia()));
			usuarioBD.setEnabled(true);
			usuarioDao.save(usuarioBD);

			Persona personaBD = new Persona();
			personaBD.setIdPersona(personaDao.nextId());
			personaBD.setNombre(estudiante.getNombre());
			personaBD.setApellidoPaterno(estudiante.getApaterno());
			personaBD.setApellidoMaterno(estudiante.getAmaterno());
			personaBD.setCodigoTipoPersona("ALUMNO");
			personaBD.setIdUsuario(usuarioBD.getId());
			personaDao.save(personaBD);

			Estudiante estudianteBD = new Estudiante();
			estudianteBD.setIdEstudiante(estudianteDao.nextId());
			estudianteBD.setIdPersona(personaBD.getIdPersona());		
			estudianteDao.save(estudianteBD);
			return estudianteBD;
	}
	
	


	@Override
	public List<ProEstudianteDto> filtrar(Integer idAula) {
		
		
		return estudianteDao.filtrar(idAula);
	}


	@Override
	public List<ProEstudiantePorMatricularDto> listaAlumnosDisponibles(Integer idAula) {
		List<ProEstudiantePorMatricularDto> lsEstudiantesDisponibles = estudianteDao.listaAlumnosDisponibles(); //lista total de estudiantes
		List<Integer> idsEstudiantesMatriculadosAnioActual = estudianteDao.estudiantesMatriculadosAnioActual(LocalDate.now().getYear());
				
		System.out.println("2019="+idsEstudiantesMatriculadosAnioActual);
		lsEstudiantesDisponibles.removeIf(led -> idsEstudiantesMatriculadosAnioActual.contains(led.getIdEstudiante()));
		return lsEstudiantesDisponibles;
	}

}
