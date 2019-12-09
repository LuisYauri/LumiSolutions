package pe.edu.savbackend.service.estudiante;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.EstudianteDao;
import pe.edu.savbackend.dao.PersonaDao;
import pe.edu.savbackend.dao.UsuarioDao;
import pe.edu.savbackend.domain.EstudianteDto;
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
	public Estudiante actualizarEstudiante(EstudianteDto estudiante) {
		/* Grupo grupo = estudianteDao.getOne(aula.getIdAula());
		if(!aula.getGrupo().equals(grupo.getNombre()))
		{
			if(estudianteDao.existe(aula.getGrupo()) != 0) 
			{
				throw new RuntimeException("El nombre de grupo ya existe");
			}
			grupo.setNombre(aula.getGrupo());
		}
		
		grupo.setCodigoGrado(String.valueOf(aula.getCodigoGrado()));
		grupo.setAnio(LocalDateTime.of(aula.getAnio(),1,1,0,0,0));
		return estudianteDao.save(grupo); */
		return null;
	}

	@Override
	public Boolean eliminarEstudiante(Integer idEstudiante) {
		/* try{
			Grupo grupo = estudianteDao.getOne(idArea);
			grupo.setCodigoEstado("0");
			estudianteDao.save(grupo);
			return true;	
		}catch(Exception e){
			throw new RuntimeException("El id grupo no existe");
		}	 */
		return null;
	}

}
