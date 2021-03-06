package pe.edu.savbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubContenidoDto {

	private Integer idSubContenido;
	private String nombre;
	private String descripcion;
	private String urlImagen;

	// se utiliza solo para contenidoController
	// @RequestMapping("?idCriterio={idCriterio}&codigoGrado={codigoGrado}")
	private Integer idCriterio;

	public SubContenidoDto(Integer idSubContenido, String nombre, String descripcion, String urlImagen) {
		this.idSubContenido = idSubContenido;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.urlImagen = urlImagen; 
	}
	
}
