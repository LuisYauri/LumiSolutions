package pe.edu.savbackend.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContenidoDto {

	private Integer idContenido; 
	private String nombre;
	private String urlImagen;
	private String codGrado;

	// se utiliza solo para contenidoController
	private Integer idCriterio;
	private List<SubContenidoDto> lsSubContenido;
	public ContenidoDto(Integer idCriterio, Integer idContenido, String nombre, String urlImagen) {
		this.idCriterio = idCriterio;
		this.idContenido = idContenido;
		this.nombre = nombre;
		this.urlImagen = urlImagen;
	}
  
	
}
