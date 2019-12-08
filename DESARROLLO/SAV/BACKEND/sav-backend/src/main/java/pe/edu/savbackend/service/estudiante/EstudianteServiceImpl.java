package pe.edu.savbackend.service.estudiante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.EstudianteDao;
import pe.edu.savbackend.domain.EstudianteDto;
import pe.edu.savbackend.entity.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	EstudianteDao estudianteDao;

	@Override
	public List<EstudianteDto> getLsEstudiantes() {
		/* List<Grupo> listaGrupos = estudianteDao.obtenerListaGrupos();
		List<AulaDto> listaAulas = new ArrayList<>();
		listaGrupos.forEach(g -> {
			listaAulas.add(new AulaDto(g.getIdGrupo(), g.getNombre(), Integer.parseInt(g.getCodigoGrado()),
			g.getAnio().getYear()));
		});
		return listaAulas; */
		return null;
	}

	@Override
	public Estudiante registrarEstudiante(EstudianteDto estudiante) {
		/* if(estudianteDao.existe(aula.getGrupo()) != 0) {
			throw new RuntimeException("El nombre de grupo ya existe");
		}
		Grupo grupo = new Grupo();
		grupo.setIdGrupo(estudianteDao.nextId());
		grupo.setNombre(aula.getGrupo());
		grupo.setIdDocente("1");
		grupo.setCodigoGrado(String.valueOf(aula.getCodigoGrado()));
		grupo.setCodigoEstado("1");
		grupo.setAnio(LocalDateTime.of(aula.getAnio(),1,1,0,0,0));
		return estudianteDao.save(grupo); */
		return null;
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
