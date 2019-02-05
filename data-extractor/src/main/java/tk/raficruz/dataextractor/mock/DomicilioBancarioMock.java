package tk.raficruz.dataextractor.mock;

import org.springframework.stereotype.Component;

import tk.raficruz.dataextractor.model.DomicilioBancario;
import tk.raficruz.dataextractor.util.MockUtil;

@Component
public class DomicilioBancarioMock implements Mockable<DomicilioBancario>{

	@Override
	public DomicilioBancario getMockInstance() {
		return DomicilioBancario.builder()
				.codigoBanco(MockUtil.getRandomLongValue(3))
				.numeroAgencia(MockUtil.getRandomLongValue(1))
				.numeroContaCorrente(MockUtil.getRandomStringNumberValue(14))
				.build();
	}

}
