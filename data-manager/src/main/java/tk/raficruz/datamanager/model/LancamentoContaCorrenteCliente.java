package tk.raficruz.datamanager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tk.raficruz.datamanager.util.StringArrayToStringConverter;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBL_LANCAMENTO_CC_CLIENTE")
public class LancamentoContaCorrenteCliente implements Serializable {

	private static final long serialVersionUID = 6000909284421799881L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "numero_remessa_banco")
	private Long numeroRemessaBanco;

	@Column(name = "dados_analiticos")
	@Convert(converter=StringArrayToStringConverter.class)
	private List<String> dadosAnaliticoLancamentoFinanceiroCliente;
	
	@Column(name = "situacao_remessa")
	private String nomeSituacaoRemessa;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "domicilio_bancario_id")
	private DomicilioBancario dadosDomicilioBancario;
	
	@Column(name = "tipo_operacao")
	private String nomeTipoOperacao;
}
