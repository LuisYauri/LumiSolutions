package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.auxiliar.MatriculaAux;
import pe.edu.savbackend.entity.Matricula;

/**
 * MatriculaDao
 */
public interface MatriculaDao extends JpaRepository<Matricula, Integer> {
//	@Query(value = "select new pe.edu.savbackend.domain.auxiliar.MatriculaAux(m.idEstudiante, g.nombre, g.codGrado, g.anio, g.codEstado) "
//			+ " from Persona p "
//			+ " join Estudiante e on e.id_persona = p.id "
//			+ " join Matricula m on m.idEstudiante = e.id"
//			+ " join Grupo g on g.id = m.idGrupo "
//			+ " where p.idUsuario = ?1"
//			+ " and g.anio = ?2")
//	List<MatriculaAux> getMatriculasGrupos(Integer idUsuario, String anio);

}