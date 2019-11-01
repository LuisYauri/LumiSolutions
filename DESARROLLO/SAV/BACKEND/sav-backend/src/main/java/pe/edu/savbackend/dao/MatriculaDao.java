package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.savbackend.entity.Matricula;
/**
 * MatriculaDao
 */
public interface MatriculaDao extends JpaRepository<Matricula, Integer>{

    
}