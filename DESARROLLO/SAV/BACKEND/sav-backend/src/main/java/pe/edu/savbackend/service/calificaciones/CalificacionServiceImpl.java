package pe.edu.savbackend.service.calificaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.savbackend.dao.CalificacionDao;
import pe.edu.savbackend.dao.RecursoDao;
import pe.edu.savbackend.entity.Calificacion;

@Service
public class CalificacionServiceImpl implements CalificacionService {
	
	@Autowired
	CalificacionDao calificacionDao;

	@Autowired
	RecursoDao recursoDao;

	@Override
	public Double registrarCalificacion(Calificacion calificacion) {
		// TODO Auto-generated method stub
		
		if(!(calificacion.getCalificacion() < 6 && calificacion.getCalificacion() > 0 )) {
			throw new RuntimeException("Debe mandarse una calificacion entre 1 y 5");
		}else {
			calificacionDao.save(calificacion);
			Double calificacionPromedio = calificacionDao.obtenerCalificacionPromedio(calificacion.getIdRecurso());
			calificacionPromedio = Math.floor(calificacionPromedio*100)/100;
			recursoDao.getOne(calificacion.getIdRecurso()).setPromedioCalificacion(calificacionPromedio);
			return calificacionPromedio;
		}
	}

	@Override
	public Integer obtenerCalificacionPorEstudiante(Integer idRecurso, Integer idEstudiante) {
		return calificacionDao.obtenerCalificacionPorEstudiante(idRecurso, idEstudiante);
	}


	

}
