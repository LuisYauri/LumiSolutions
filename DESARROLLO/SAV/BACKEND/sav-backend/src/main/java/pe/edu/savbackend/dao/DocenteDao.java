package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.entity.Docente;



/**
 * DocenteDao
 */
public interface DocenteDao extends JpaRepository<Docente, Integer>{

    
}