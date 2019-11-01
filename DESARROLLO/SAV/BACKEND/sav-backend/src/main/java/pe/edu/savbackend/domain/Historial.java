package pe.edu.savbackend.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.savbackend.domain.tarea.Examen;
import pe.edu.savbackend.domain.tarea.Tarea;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Historial {
	private List<Tarea> lsTareas;
	private List<Examen> lsExamenes;
}
