package pe.edu.savbackend.service.evaluacion;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import pe.edu.savbackend.dao.AlternativaDao;
import pe.edu.savbackend.dao.ContenidoDao;
import pe.edu.savbackend.dao.EstudianteEvaluacionDao;
import pe.edu.savbackend.dao.EvaluacionDao;
import pe.edu.savbackend.dao.EvaluacionDetalleDao;
import pe.edu.savbackend.dao.HistorialDao;
import pe.edu.savbackend.dao.PreguntaDao;
import pe.edu.savbackend.domain.tarea.EstadisticaDto;
import pe.edu.savbackend.domain.tarea.ExamenDto;
import pe.edu.savbackend.domain.tarea.PreguntaDto;
import pe.edu.savbackend.domain.tarea.TareaDto;
import pe.edu.savbackend.domain.tarea.TipoResultadoDto;
import pe.edu.savbackend.entity.EstudianteEvaluacion;
import pe.edu.savbackend.entity.Evaluacion;
import pe.edu.savbackend.entity.Historial;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {

	@Autowired
	private EvaluacionDao evaluacionDao;
	@Autowired
	private EvaluacionDetalleDao evaluacionDetalleDao;
	@Autowired
	private PreguntaDao preguntaDao;	
	@Autowired
	private AlternativaDao alternativaDao;	
	@Autowired
	private HistorialDao historialDao;	
	@Autowired
	private EstudianteEvaluacionDao estudianteEvaluacionDao;	
	@Autowired
	private ContenidoDao contenidoDao;
	
	Gson gson = new Gson();

	@Override
	public List<TareaDto> getLsTareas(Integer idEstudiante) {
		//contar las tareas formatear la fecha 
		List<TareaDto> lsTarea = evaluacionDao.getLsTareas(idEstudiante);

		lsTarea.forEach(e->{
			LocalDateTime ldt = evaluacionDao.getOne(e.getIdTarea()).getFechaInicio();
			e.setCantidadPreguntas(evaluacionDetalleDao.cantidadPregunta(e.getIdTarea()).toString());
			e.setFechaLimite((ldt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
			e.setTiempoLimite((ldt.format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
		});
		
		return lsTarea;
	}

	@Override
	public List<ExamenDto> getLsExamenes(Integer idEstudiante) {
		//contar las tareas formatear la fecha 
		List<Evaluacion> lsEvaluaciones = evaluacionDao.getLsExamenesModel(idEstudiante);
		List<ExamenDto> lsExamenes = new ArrayList<>();
		lsEvaluaciones.forEach(e->{
			ExamenDto examenDto = new ExamenDto();
			LocalDateTime ldt = evaluacionDao.getOne(e.getIdEvaluacion()).getFechaInicio();
			examenDto.setIdExamen(e.getIdEvaluacion()); 
			examenDto.setTitulo(e.getTitulo());
			examenDto.setCantidadPreguntas(evaluacionDetalleDao.cantidadPregunta(e.getIdEvaluacion()).toString());
			long seg = e.getFechaFin().until(e.getFechaInicio(), ChronoUnit.SECONDS);
			examenDto.setDuracion((double)seg/3600);
			examenDto.setFechaInico((ldt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
			examenDto.setHoraInicio((ldt.format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
			lsExamenes.add(examenDto);
		});
		return lsExamenes;
	}
	
	@Override
	public TareaDto getPreguntasPorTarea(Integer idTarea) {
		Evaluacion tarea = evaluacionDao.getOne(idTarea);
		
		TareaDto tareaDto = new TareaDto(tarea.getIdEvaluacion(), tarea.getTitulo());
		if (tarea.getIdContenido()!= null) {
			tareaDto.setContenido(contenidoDao.getOne(tarea.getIdContenido()).getNombre());
			long seg = tarea.getFechaFin().until(tarea.getFechaInicio(), ChronoUnit.SECONDS);
			tareaDto.setDuracion((double)seg/3600);
		}
		
		
		List<PreguntaDto> lsPreguntas = preguntaDao.obtenerPreguntasPorIdTarea(idTarea);
		
		lsPreguntas.forEach(preg -> {
			List<String> lsAlternativas = alternativaDao.obtenerAlternativasPorIdPregunta(preg.getIdPregunta())
			.stream()
			.map(e->e.getDescripcion().toString()).collect(Collectors.toList());
			lsAlternativas.add(preg.getRespuestaCorrecta());
			Collections.shuffle(lsAlternativas);
			preg.setAlternativas(
					lsAlternativas.toArray(new String[lsAlternativas.size()])
				);
			
		});
		tareaDto.setLsPreguntas(lsPreguntas);
		return tareaDto;
	}
	
	@Override
	public ExamenDto getPreguntasPorExamen(Integer idExamen) {
		Evaluacion examen = evaluacionDao.getOne(idExamen);
		ExamenDto examenDto = new ExamenDto(examen.getIdEvaluacion(), examen.getTitulo());
		long seg = examen.getFechaFin().until(examen.getFechaInicio(), ChronoUnit.SECONDS);
		examenDto.setDuracion((double)seg/3600);
		List<PreguntaDto> lsPreguntas = preguntaDao.obtenerPreguntasPorIdTarea(idExamen);
		
		lsPreguntas.forEach(preg -> {
			List<String> lsAlternativas = alternativaDao.obtenerAlternativasPorIdPregunta(preg.getIdPregunta())
			.stream()
			.map(e->e.getDescripcion().toString()).collect(Collectors.toList());
			lsAlternativas.add(preg.getRespuestaCorrecta());
			Collections.shuffle(lsAlternativas);
			preg.setAlternativas(
					lsAlternativas.toArray(new String[lsAlternativas.size()])
				);
			
		});
		examenDto.setLsPreguntas(lsPreguntas);
		
		return examenDto;
	}
	
	//vabriables auxiliares para calcular las estadisticas
	private Integer correcto, incorrecto, vacio;
	@Override
	public EstadisticaDto finalizarTarea(TareaDto tareaDto) {
		correcto = 0; incorrecto = 0; vacio = 0;
		tareaDto.setFechaSolucion(LocalDateTime.now(ZoneId.of("America/Lima")));
		tareaDto.setCantidadPreguntas(tareaDto.getLsPreguntas().size() + "");

		tareaDto.getLsPreguntas().forEach(pregunta->{
			String rptaCorrecta = preguntaDao.getOne(pregunta.getIdPregunta()).getRespuestaCorrecta();
			if(pregunta.getRespuestaEstudiante() == null || pregunta.getRespuestaEstudiante().equals("")){
				vacio++;
			} else if (pregunta.getRespuestaEstudiante().equals(rptaCorrecta)) {
				correcto++;
			} else if(!pregunta.getRespuestaEstudiante().equals(rptaCorrecta)) {
				incorrecto++;
			}
			pregunta.setRespuestaCorrecta(rptaCorrecta);
		});
		
		Integer total = correcto+ incorrecto + vacio;
		List<TipoResultadoDto> lsTipoResultado =Arrays.asList(
				 TipoResultadoDto.builder().tipo("Correcto").porcentaje((int)Math.round(correcto*100.0/total)).cantidad(correcto).build()
				,TipoResultadoDto.builder().tipo("Incorrecto").porcentaje((int)Math.round(incorrecto*100.0/total)).cantidad(incorrecto).build()
				,TipoResultadoDto.builder().tipo("Sin responder").porcentaje((int)Math.round(vacio*100.0/total)).cantidad(vacio).build());
		
		EstadisticaDto estadistica = new EstadisticaDto();
		if(lsTipoResultado.get(0).getPorcentaje()>60){
			estadistica.setNota("A");
		} else if(lsTipoResultado.get(0).getPorcentaje()>40) {
			estadistica.setNota("B");
		} else {
			estadistica.setNota("C");
		}
		estadistica.setLsTiposResultados(lsTipoResultado);
		estadistica.setTotalPreguntas(Integer.parseInt(tareaDto.getCantidadPreguntas()));
		estadistica.setIdEstudiante(tareaDto.getIdEstudiante());
		estadistica.setIdEvaluacion(tareaDto.getIdTarea());
		estadistica.setTipo("T");
		
		EstudianteEvaluacion ee = estudianteEvaluacionDao.obtenerEstudianteEvaluacion(tareaDto.getIdEstudiante(), tareaDto.getIdTarea()) ;
//		System.out.println("ESTUDIANTE = " + ee);
		ee.setCodigoEstadoEvaluacion("2");
		estudianteEvaluacionDao.save(ee);
		//aaa
		
		Historial historial = new Historial();
		historial.setIdEstudiante(tareaDto.getIdEstudiante());
		historial.setIdEvaluacion(tareaDto.getIdTarea());
		historial.setJsonEstadistica(gson.toJson(estadistica));
		historial.setJsonCompleto(gson.toJson(tareaDto));
		historial.setFechaFinalizacion(tareaDto.getFechaSolucion());
		historial.setTipoEvaluacion("T");
		System.out.println(historial);
		historialDao.save(historial);
		return estadistica;
	}

	@Override
	public EstadisticaDto finalizarExamen(ExamenDto examenDto) {
		correcto = 0; incorrecto = 0; vacio = 0;
		examenDto.setFechaSolucion(LocalDateTime.now(ZoneId.of("America/Lima")));
		examenDto.setCantidadPreguntas(examenDto.getLsPreguntas().size() + "");
		
		examenDto.getLsPreguntas().forEach(pregunta->{
			String rptaCorrecta = preguntaDao.getOne(pregunta.getIdPregunta()).getRespuestaCorrecta();
			if(pregunta.getRespuestaEstudiante() == null){
				vacio++;
			} else if (pregunta.getRespuestaEstudiante().equals(rptaCorrecta)) {
				correcto++;
			} else if(!pregunta.getRespuestaEstudiante().equals(rptaCorrecta)) {
				incorrecto++;
			}
			pregunta.setRespuestaCorrecta(rptaCorrecta);
		});
		
		Integer total = correcto+ incorrecto + vacio;
		List<TipoResultadoDto> lsTipoResultado =Arrays.asList(
				 TipoResultadoDto.builder().tipo("Correcto").porcentaje((int)Math.round(correcto*100.0/total)).cantidad(correcto).build()
				,TipoResultadoDto.builder().tipo("Incorrecto").porcentaje((int)Math.round(incorrecto*100.0/total)).cantidad(incorrecto).build()
				,TipoResultadoDto.builder().tipo("Sin responder").porcentaje((int)Math.round(vacio*100.0/total)).cantidad(vacio).build());
		
		EstadisticaDto estadistica = new EstadisticaDto();
		if(lsTipoResultado.get(0).getPorcentaje()>60){
			estadistica.setNota("A");
		} else if(lsTipoResultado.get(0).getPorcentaje()>40) {
			estadistica.setNota("B");
		} else {
			estadistica.setNota("C");
		}
		estadistica.setLsTiposResultados(lsTipoResultado);
		estadistica.setTotalPreguntas(Integer.parseInt(examenDto.getCantidadPreguntas()));
		estadistica.setIdEstudiante(examenDto.getIdEstudiante());
		estadistica.setIdEvaluacion(examenDto.getIdExamen());
		estadistica.setTipo("E");
		
		EstudianteEvaluacion ee = estudianteEvaluacionDao.obtenerEstudianteEvaluacion(examenDto.getIdEstudiante(), examenDto.getIdExamen()) ;
//		System.out.println("ESTUDIANTE = " + ee);
		ee.setCodigoEstadoEvaluacion("2");
		estudianteEvaluacionDao.save(ee);
		
		Historial historial = new Historial();
		historial.setIdEstudiante(examenDto.getIdEstudiante());
		historial.setIdEvaluacion(examenDto.getIdExamen());
		historial.setJsonEstadistica(gson.toJson(estadistica));
		historial.setJsonCompleto(gson.toJson(examenDto));
		historial.setFechaFinalizacion(examenDto.getFechaSolucion());
		historial.setTipoEvaluacion("E");
		historialDao.save(historial);
		return estadistica;
	}

}
