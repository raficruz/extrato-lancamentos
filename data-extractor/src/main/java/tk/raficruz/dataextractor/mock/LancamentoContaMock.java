package tk.raficruz.dataextractor.mock;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tk.raficruz.dataextractor.model.LancamentoConta;
import tk.raficruz.dataextractor.util.MockUtil;

@Component
public class LancamentoContaMock implements Mockable<LancamentoConta> {
	private static final Logger LOGGER = LoggerFactory.getLogger(LancamentoConta.class);
	
	@Autowired
	public ControleLancamentoMock controleLancamentoMock;

	@Autowired
	public TotalControleLancamentoMock totalControleLancamentoMock;

	@Override
	public LancamentoConta getMockInstance() {
		return LancamentoConta.builder()
			.indice(MockUtil.getRandomLongValue(1))
			.listaControleLancamento(controleLancamentoMock.getMockInstanceList(new Random().nextInt(6)))
			.tamanhoPagina(MockUtil.getRandomLongValue(2))
			.totalControleLancamento(totalControleLancamentoMock.getMockInstance())
			.totalElements(MockUtil.getRandomLongValue(2))
		.build();
	}

}
