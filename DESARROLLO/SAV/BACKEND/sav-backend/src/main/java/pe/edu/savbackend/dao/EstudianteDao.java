package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.entity.Estudiante;
import pe.edu.savbackend.domain.DatosEstudiante;

public interface EstudianteDao extends JpaRepository<Estudiante, Integer> {
	@Query(value = "select e.username from Estudiante e")
	List<DatosEstudiante> listEstudiante();
}
