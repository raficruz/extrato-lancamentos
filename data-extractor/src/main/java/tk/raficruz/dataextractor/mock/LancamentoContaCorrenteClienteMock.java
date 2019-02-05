package tk.raficruz.dataextractor.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tk.raficruz.dataextractor.model.LancamentoContaCorrenteCliente;
import tk.raficruz.dataextractor.util.MockUtil;

@Component
public class LancamentoContaCorrenteClienteMock implements Mockable<LancamentoContaCorrenteCliente> {

	@Autowired
	private DomicilioBancarioMock domicilioBancarioMock;

	@Override
	public LancamentoContaCorrenteCliente getMockInstance() {
		return LancamentoContaCorrenteCliente.builder()
			.numeroRemessaBanco(MockUtil.getRandomLongValue(11))
			.nomeSituacaoRemessa(MockUtil.getRandomNomeSituacaoRemessa())
			.dadosDomicilioBancario(domicilioBancarioMock.getMockInstance())
			.nomeTipoOperacao(MockUtil.getRandomNomeTipoOperacao())
			.build();
	}

}
