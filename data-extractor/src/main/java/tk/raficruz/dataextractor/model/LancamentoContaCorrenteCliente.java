package tk.raficruz.dataextractor.model;

import java.io.Serializable;

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
public class LancamentoContaCorrenteCliente implements Serializable {

	private static final long serialVersionUID = 6000909284421799881L;

	private Long numeroRemessaBanco;
	private String nomeSituacaoRemessa;
	private DomicilioBancario dadosDomicilioBancario;
	private String nomeTipoOperacao;
}
