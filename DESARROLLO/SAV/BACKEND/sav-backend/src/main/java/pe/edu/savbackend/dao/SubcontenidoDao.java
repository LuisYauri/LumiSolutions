package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.savbackend.entity.Contenido;
import pe.edu.savbackend.entity.Subcontenido;


public interface SubcontenidoDao extends JpaRepository<Subcontenido, Integer> {
}
