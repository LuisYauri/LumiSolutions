package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.savbackend.entity.Contenido;
import pe.edu.savbackend.entity.Recurso;


public interface RecursoDao extends JpaRepository<Recurso, Integer> {
}
