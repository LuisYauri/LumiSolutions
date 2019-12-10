package pe.edu.savbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.savbackend.domain.comentario.ComentarioResponse;
import pe.edu.savbackend.entity.Comentario;
/**
 * ComentarioDao
 */
public interface ComentarioDao extends JpaRepository<Comentario, Integer>{


   @Query(value = "select new pe.edu.savbackend.domain.comentario.ComentarioResponse "
                 + "(c.idEstudiante, p.apellidoPaterno, p.nombre , c.descripcion) " 
                 + "from Comentario c " 
                 + "join Estudiante e on e.idEstudiante = c.idEstudiante "
                 + "join Persona p on p.idPersona = e.idPersona where c.idRecurso = ?1 ORDER BY c.fecha DESC"
           )
	List<ComentarioResponse> obtenerListaComentarios(Integer idRecurso);

	@Query(value = "select max(c.idComentario)+ 1 from Comentario c")
	Integer nextId();

}