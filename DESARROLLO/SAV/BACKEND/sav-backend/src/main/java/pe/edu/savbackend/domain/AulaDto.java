package pe.edu.savbackend.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AulaDto {

	private Integer idAula;
	private String grupo;
	private Integer codigoGrado; 
	private Integer anio;

}
