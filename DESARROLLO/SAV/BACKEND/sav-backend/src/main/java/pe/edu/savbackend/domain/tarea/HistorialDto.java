package pe.edu.savbackend.domain.tarea;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistorialDto {
	private List<TareaDto> lsTareas;
	private List<ExamenDto> lsExamenes;

}
