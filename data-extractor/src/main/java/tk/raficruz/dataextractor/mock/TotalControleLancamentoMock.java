package tk.raficruz.dataextractor.mock;

import org.springframework.stereotype.Component;

import tk.raficruz.dataextractor.model.TotalControleLancamento;
import tk.raficruz.dataextractor.util.MockUtil;

@Component
public class TotalControleLancamentoMock implements Mockable<TotalControleLancamento>{

	@Override
	public TotalControleLancamento getMockInstance() {
		return TotalControleLancamento.builder()
			.quantidadeLancamentos(MockUtil.getRandomLongValue(3))
			.quantidadeRemessas(MockUtil.getRandomLongValue(2))
			.valorLancamentos(MockUtil.getRandomDoubleValue(6))
			.build();
	}

}
