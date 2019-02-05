package tk.raficruz.datamanager.queue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tk.raficruz.datamanager.model.LancamentoConta;
import tk.raficruz.datamanager.repository.LancamentoContaRepository;
import tk.raficruz.datamanager.util.LocalDateConverter;
import tk.raficruz.datamanager.util.LocalDateTimeConverter;

@Component
public class QueueConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(QueueConsumer.class);

	@Autowired
	private LancamentoContaRepository repository;

	@RabbitListener(queues = { "${queue.name}" })
	public void receive(@Payload String json) {
		LOGGER.info("Recebendo mensagem do broker:" + json);

		Gson gson = new GsonBuilder()
						.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeConverter())
						.registerTypeAdapter(LocalDate.class, new LocalDateConverter())
					.create();

		LOGGER.info("Convertendo json para objeto");
		LancamentoConta lancamentoConta = gson.fromJson(json, LancamentoConta.class);
		LOGGER.info("Objeto convertido");
		
		LOGGER.info("Salvando Objeto");
		lancamentoConta = repository.save(lancamentoConta);
		
		LOGGER.info(lancamentoConta.getId() > 0L? "Objeto salvo com sucesso": "Salvamento falhou");
		
		Long total = repository.count();
		LOGGER.info("Objetos salvos: " + total);
	}
}