package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.savbackend.entity.Estudiante;

public interface EstudianteDao extends JpaRepository<Estudiante, Integer> {
	
}
