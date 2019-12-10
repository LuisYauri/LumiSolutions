package pe.edu.savbackend.service.matricula;

public interface MatriculaService {
 
	void matricular(Integer idAula, Integer[] idEstudiantes);

	void eliminarAlumnoDeMatricula(Integer idEstudiante, Integer idAula);

}
