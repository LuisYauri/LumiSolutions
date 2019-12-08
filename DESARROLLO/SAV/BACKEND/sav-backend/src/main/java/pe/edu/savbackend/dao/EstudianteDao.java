package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.EstudianteDto;
import pe.edu.savbackend.entity.Estudiante;

public interface EstudianteDao extends JpaRepository<Estudiante, Integer> {

    @Query(value = "select new pe.edu.savbackend.domain.EstudianteDto(e.idEstudiante, p.nombre, p.apellidoPaterno, "
                 + "p.apellidoMaterno, u.username, u.password) from Estudiante e "
                 + "inner join Persona p on e.idPersona = p.idPersona "
                 + "inner join Usuario u on u.id = p.idUsuario"
          )
    List<EstudianteDto> obtenerListaAlumnos();

    @Query(value = "select max(e.idEstudiante) + 1 from Estudiante e")
    Integer nextId();
}
