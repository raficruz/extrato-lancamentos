package tk.raficruz.dataextractor.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tk.raficruz.dataextractor.model.ControleLancamento;
import tk.raficruz.dataextractor.util.MockUtil;

@Component
public class ControleLancamentoMock implements Mockable<ControleLancamento>{

	@Autowired
	private LancamentoContaCorrenteClienteMock lancamentoContaCorrenteClienteMock;

	@Override
	public ControleLancamento getMockInstance() {
		return ControleLancamento.builder()
			.lancamentoContaCorrenteCliente(lancamentoContaCorrenteClienteMock.getMockInstance())
			.dataLancamentoContaCorrenteCliente(LocalDate.now())
			.dateLancamentoContaCorrenteCliente(LocalDateTime.now())
			.dataEfetivaLancamento(LocalDate.now())
			.dateEfetivaLancamento(LocalDateTime.now())
			.numeroEvento(MockUtil.getRandomLongValue(8))
			.descricaoGrupoPagamento(MockUtil.getRandomString(2, false) + "-" + MockUtil.getRandomStringNumberValue(2))
			.codigoIdentificadorUnico(MockUtil.getRandomLongValue(8))
			.nomeBanco(MockUtil.getRandomString(15, true))
			.quantidadeLancamentoRemessa(MockUtil.getRandomLongValue(3))
			.numeroRaizCNPJ(MockUtil.getRandomStringNumberValue(8))
			.numeroSufixoCNPJ(MockUtil.getRandomStringNumberValue(4))
			.valorLancamentoRemessa(MockUtil.getRandomDoubleValue(5))
			.build();
	}

}
