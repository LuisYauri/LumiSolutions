package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.savbackend.entity.Contenido;


public interface ContenidoDao extends JpaRepository<Contenido, Integer> {
}
