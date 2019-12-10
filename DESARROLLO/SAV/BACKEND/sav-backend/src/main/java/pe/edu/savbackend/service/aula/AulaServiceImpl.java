package pe.edu.savbackend.service.aula;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.GrupoDao;
import pe.edu.savbackend.domain.AulaDto;
import pe.edu.savbackend.entity.Grupo;

@Service
public class AulaServiceImpl implements AulaService {

	@Autowired
	GrupoDao grupoDao;

	@Override
	public List<AulaDto> getLsAulas() {
		List<Grupo> listaGrupos = grupoDao.obtenerListaGrupos();
		List<AulaDto> listaAulas = new ArrayList<>();
		listaGrupos.forEach(g -> {
			listaAulas.add(new AulaDto(g.getIdGrupo(), g.getNombre(), Integer.parseInt(g.getCodigoGrado()),
			g.getAnio()));
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
		grupo.setAnio(aula.getAnio());
		return grupoDao.save(grupo);
	}

	@Override
	public Grupo actualizarAula(AulaDto aula) {
		Grupo grupo = grupoDao.getOne(aula.getIdAula());
		if(!aula.getGrupo().equals(grupo.getNombre()))
		{
			if(grupoDao.existe(aula.getGrupo()) != 0) 
			{
				throw new RuntimeException("El nombre de grupo ya existe");
			}
			grupo.setNombre(aula.getGrupo());
		}
		
		grupo.setCodigoGrado(String.valueOf(aula.getCodigoGrado()));
		grupo.setAnio(aula.getAnio());
		return grupoDao.save(grupo);
	}

	@Override
	public Boolean eliminarAula(Integer idArea) {
		try{
			Grupo grupo = grupoDao.getOne(idArea);
			grupo.setCodigoEstado("0");
			grupoDao.save(grupo);
			return true;	
		}catch(Exception e){
			throw new RuntimeException("El id grupo no existe");
		}	
	}

}
