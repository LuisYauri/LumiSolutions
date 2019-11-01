package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.savbackend.entity.Historial;
/**
 * HistorialDao
 */
public interface HistorialDao extends JpaRepository<Historial, Integer>{

    
}