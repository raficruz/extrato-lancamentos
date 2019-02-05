package tk.raficruz.dataextractor.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ControleLancamento implements Serializable {

	private static final long serialVersionUID = -1809646971179554588L;

	private LancamentoContaCorrenteCliente lancamentoContaCorrenteCliente;

	private LocalDate dataEfetivaLancamento;

	private LocalDate dataLancamentoContaCorrenteCliente;

	private Long numeroEvento;
	private String descricaoGrupoPagamento;
	private Long codigoIdentificadorUnico;
	private String nomeBanco;
	private Long quantidadeLancamentoRemessa;
	private String numeroRaizCNPJ;
	private String numeroSufixoCNPJ;
	private Double valorLancamentoRemessa;

	private LocalDateTime dateLancamentoContaCorrenteCliente;// inicialmente representado em milissegundos

	private LocalDateTime dateEfetivaLancamento; // inicialmente representado em milissegundos
}
