package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.savbackend.domain.Persona;

public interface PersonaDao extends JpaRepository<Persona,String>{

}
