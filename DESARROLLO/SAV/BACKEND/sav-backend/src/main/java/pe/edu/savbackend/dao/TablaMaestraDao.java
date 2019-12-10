package pe.edu.savbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.savbackend.entity.TablaMaestra;


public interface TablaMaestraDao extends JpaRepository<TablaMaestra, Integer> {
}
