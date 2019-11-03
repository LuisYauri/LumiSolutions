package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.savbackend.entity.Grupo;

/**
 * DocenteDao  ctrl + shift + o sirve para importar
 */
public interface GrupoDao extends JpaRepository<Grupo, Integer>{

    
}