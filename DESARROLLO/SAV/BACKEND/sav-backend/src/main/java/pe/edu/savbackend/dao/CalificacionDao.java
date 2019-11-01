package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.savbackend.entity.Calificacion;


public interface CalificacionDao extends JpaRepository<Calificacion, Integer> {
}
