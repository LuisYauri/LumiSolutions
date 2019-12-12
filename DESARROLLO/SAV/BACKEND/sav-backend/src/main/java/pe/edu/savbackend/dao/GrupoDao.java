package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.entity.Grupo;

/**
 * DocenteDao  ctrl + shift + o sirve para importar
 */
public interface GrupoDao extends JpaRepository<Grupo, Integer>{
    
    @Query(value = "select c from Grupo c where c.codigoEstado = 1")
    List<Grupo> obtenerListaGrupos();
    
    @Query(value = "select max(c.idGrupo)+ 1 from Grupo c")
    Integer nextId();
    
    @Query(value = "select count(c) from Grupo c where c.nombre = ?1 and c.anio=?2 and c.codigoGrado=?3")
    Integer existe(String nombreGrupo, Integer anio, String codigoGrado);
    
}