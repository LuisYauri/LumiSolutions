package pe.edu.savbackend.service.calificaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.CalificacionDao;
import pe.edu.savbackend.entity.Calificacion;

@Service
public class CalificacionServiceImpl implements CalificacionService {
	
	@Autowired
	CalificacionDao calificacionDao;
	
	@Override
	public Calificacion registrarCalificacion(Calificacion calificacion) {
		// TODO Auto-generated method stub
		
		if(!(calificacion.getCalificacion() < 5 && calificacion.getCalificacion() > 1 )) {
			throw new RuntimeException("Debe mandarse una calificacion entre 1 y 5");
		}else {
			if (calificacion.getIdCalificacion() == null) {
				calificacion.setIdCalificacion(calificacionDao.nextId());
				return calificacionDao.save(calificacion);
			}
			return calificacionDao.save(calificacion);
		}
	}


	

}
