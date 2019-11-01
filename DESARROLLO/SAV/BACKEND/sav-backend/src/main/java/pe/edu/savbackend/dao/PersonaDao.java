package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.savbackend.entity.Persona;

/**
 * PersonaDao
 */
public interface PersonaDao extends JpaRepository<Persona, Integer> {

}