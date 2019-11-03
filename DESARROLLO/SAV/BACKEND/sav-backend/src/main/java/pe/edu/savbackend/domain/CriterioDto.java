package pe.edu.savbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CriterioDto {

	private Integer idCriterio;
	private Integer nombre;
	private String urlImagen;

}
