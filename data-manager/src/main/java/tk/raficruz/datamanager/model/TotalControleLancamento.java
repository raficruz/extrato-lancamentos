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
@Table(name="TBL_TOTAL_CONTROLE_LANCAMENTO")
public class TotalControleLancamento implements Serializable {

	private static final long serialVersionUID = -3171277930476181978L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "qtd_lancamentos")
	private Long quantidadeLancamentos;
	
	@Column(name = "qtd_remessas")
	private Long quantidadeRemessas;

	@Column(name = "valor_lancamentos")
	private Double valorLancamentos;
}
