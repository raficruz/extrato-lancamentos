package tk.raficruz.datamanager.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tk.raficruz.datamanager.util.CnpjUtil;
import tk.raficruz.datamanager.util.LocalDateDeserializer;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "TBL_CONTROLE_LANCAMENTO")
public class ControleLancamento implements Serializable {

	private static final long serialVersionUID = -1809646971179554588L;

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "lancamento_cc_cliente_id")
	private LancamentoContaCorrenteCliente lancamentoContaCorrenteCliente;

	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@Column(name = "dt_efetiva_lancamento")
	private LocalDate dataEfetivaLancamento;

	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@Column(name = "dt_lancamento_cc_cliente")
	private LocalDate dataLancamentoContaCorrenteCliente;

	@Column(name = "numero_evento")
	private Long numeroEvento;

	@Column(name = "descricao_grupo_pgto")
	private String descricaoGrupoPagamento;

	@Column(name = "cod_identificao_unico")
	private Long codigoIdentificadorUnico;

	@Column(name = "nome_banco")
	private String nomeBanco;

	@Column(name = "qtd_lancamento_remessa")
	private Long quantidadeLancamentoRemessa;

	@Transient
	private String numeroRaizCNPJ;

	@Transient
	private String numeroSufixoCNPJ;

	@Column(name = "vlr_lancamento_remessa")
	private Double valorLancamentoRemessa;

	@Column(name = "cnpj")
	private String cnpj;

//	@Column(name = "date_lancamento_cc_cliente")
//	private LocalDateTime dateLancamentoContaCorrenteCliente;// inicialmente representado em milissegundos
//
//	@Column(name = "date_efetiva_lancamento")
//	private LocalDateTime dateEfetivaLancamento; // inicialmente representado em milissegundos

	public String getCnpj() {
		if (ObjectUtils.isEmpty(numeroRaizCNPJ) || ObjectUtils.isEmpty(numeroSufixoCNPJ)) {
			return "";
		}
		String value = numeroRaizCNPJ.concat(numeroSufixoCNPJ);
		return value.concat(CnpjUtil.calculaDVs(value));
	}

}
