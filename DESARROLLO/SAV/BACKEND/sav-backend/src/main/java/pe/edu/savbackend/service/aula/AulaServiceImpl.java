package pe.edu.savbackend.service.aula;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.CalificacionDao;
import pe.edu.savbackend.dao.GrupoDao;
import pe.edu.savbackend.dao.RecursoDao;
import pe.edu.savbackend.domain.AulaDto;
import pe.edu.savbackend.entity.Calificacion;
import pe.edu.savbackend.entity.Grupo;

@Service
public class AulaServiceImpl implements AulaService {

	@Autowired
	GrupoDao grupoDao;

	@Override
	public List<AulaDto> getLsAulas() {
		// TODO Auto-generated method stub
		final List<Grupo> listaGrupos = grupoDao.obtenerListaGrupos();
		final List<AulaDto> listaAulas = new ArrayList<>();
		listaGrupos.forEach(g -> {
			listaAulas.add(new AulaDto(g.getIdGrupo(), g.getNombre(), Integer.parseInt(g.getCodigoGrado()),
			g.getAnio().getYear()));
		});
		return listaAulas;
	}

	@Override
	public Grupo registrarAula(AulaDto aula) {
		if(grupoDao.existe(aula.getGrupo()) != 0) {
			throw new RuntimeException("El nombre de grupo ya existe");
		}
		Grupo grupo = new Grupo();
		grupo.setIdGrupo(grupoDao.nextId());
		grupo.setNombre(aula.getGrupo());
		grupo.setIdDocente("1");
		grupo.setCodigoGrado(String.valueOf(aula.getCodigoGrado()));
		grupo.setCodigoEstado("1");
		grupo.setAnio(LocalDateTime.of(aula.getAnio(),1,1,0,0,0));
		return grupo;
	}

	@Override
	public Boolean actualizarAula(final AulaDto aula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminarAula(final Integer idArea) {
		// TODO Auto-generated method stub
		return null;
	}

}
