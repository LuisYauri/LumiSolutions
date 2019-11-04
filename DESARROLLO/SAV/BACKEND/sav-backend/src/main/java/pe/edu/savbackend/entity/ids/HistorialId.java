package pe.edu.savbackend.entity.ids;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistorialId implements Serializable{

	private Integer idEstudiante;
	private Integer idEvaluacion;
	
}
