package tk.raficruz.datamanager.model.mapper;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

import org.springframework.stereotype.Component;

import tk.raficruz.datamanager.model.ControleLancamento;
import tk.raficruz.datamanager.model.DomicilioBancario;
import tk.raficruz.datamanager.model.LancamentoContaCorrenteCliente;
import tk.raficruz.datamanager.model.dto.LancamentoDTO;

@Component
public class LancamentoContaMapper extends BaseMapper<ControleLancamento, LancamentoDTO>{

	@Override
	public LancamentoDTO toDTO(ControleLancamento lancamento) {
		if(Objects.isNull(lancamento)) {
			return null;
		}

		LancamentoContaCorrenteCliente lancamentoCC = lancamento.getLancamentoContaCorrenteCliente();
		DomicilioBancario domicilioBancario = lancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario();

		return LancamentoDTO.builder()
				.dataLancamento(lancamento.getDataLancamentoContaCorrenteCliente().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
				.descricao(lancamentoCC.getNomeTipoOperacao())
				.numero(lancamentoCC.getNumeroRemessaBanco().toString())
				.situacao(lancamentoCC.getNomeSituacaoRemessa())
				.dataConfirmacao(lancamento.getDataEfetivaLancamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
				.dadosBancarios(lancamento.getNomeBanco() + 
						" Ag " + domicilioBancario.getNumeroAgencia() + 
						"CC " + domicilioBancario.getNumeroContaCorrente())
				.valorFinal( NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(lancamento.getValorLancamentoRemessa()) )
				.build();
	}

	@Override
	public ControleLancamento toEntity(LancamentoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}


}
