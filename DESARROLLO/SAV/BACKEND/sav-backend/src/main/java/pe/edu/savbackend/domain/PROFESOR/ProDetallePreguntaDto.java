package pe.edu.savbackend.domain.PROFESOR;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProDetallePreguntaDto {
	private String descripcion;
	private String urlImagen;

}
