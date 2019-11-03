package pe.edu.savbackend.service.criterio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.CriterioDao;
import pe.edu.savbackend.domain.CriterioDto;

@Service
public class CriterioServiceImpl implements CriterioService {

	@Autowired
	private CriterioDao criterioDao;
	
	@Override
	public List<CriterioDto> getLsTareas(Integer idArea) {
		// TODO Auto-generated method stub
		return criterioDao.getLsCriterio(idArea);
	}

}
