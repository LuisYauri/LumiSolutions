package pe.edu.savbackend.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class CriterioDto {

	private Integer idCriterio;
	private String nombre;
	private String urlImagen;
	
	public CriterioDto(Integer idCriterio, String nombre, String urlImagen) {
		this.idCriterio = idCriterio;
		this.nombre = nombre;
		this.urlImagen = urlImagen;
	}

	
}
