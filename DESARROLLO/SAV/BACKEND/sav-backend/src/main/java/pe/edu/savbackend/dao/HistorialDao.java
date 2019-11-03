package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.tarea.HistorialDto;
import pe.edu.savbackend.entity.Historial;
/**
 * HistorialDao
 */
public interface HistorialDao extends JpaRepository<Historial, Integer>{

}