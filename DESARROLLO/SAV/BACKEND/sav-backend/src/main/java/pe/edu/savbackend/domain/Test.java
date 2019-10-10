package pe.edu.savbackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "SAV_BD", name = "TEST")
public class Test {
	@Id
	@Column(name = "id_test")
	private Integer idTest;
	@Column(name = "campo")
	private String campo;
	@Column(name = "descripcion")
	private String descripcion;
}
