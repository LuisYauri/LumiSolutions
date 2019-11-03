package pe.edu.savbackend.domain;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

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

	// se utiliza solo para contenidoController
	private Integer idCriterio;

	private List<SubContenidoDto> lsSubContenido;
}
