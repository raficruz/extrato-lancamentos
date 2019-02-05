package tk.raficruz.datamanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_DOMICILIO_BANCARIO")
public class DomicilioBancario implements Serializable {

	private static final long serialVersionUID = 3306578969826014693L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "codigo_banco")
	private Long codigoBanco;

	@Column(name = "numero_agencia")
	private Long numeroAgencia;

	@Column(name = "numero_conta_corrente")
	private String numeroContaCorrente;
}
