package tk.raficruz.dataextractor.job;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tk.raficruz.dataextractor.mock.LancamentoContaMock;
import tk.raficruz.dataextractor.queue.QueueSender;
import tk.raficruz.dataextractor.util.LocalDateConverter;
import tk.raficruz.dataextractor.util.LocalDateTimeConverter;

@Component
public class LancamentoContaMockJob {

	private static final Logger LOGGER = LoggerFactory.getLogger(LancamentoContaMockJob.class);

	@Autowired LancamentoContaMock lancamentoContaMock; 
	@Autowired QueueSender queueSender;

	@Scheduled(cron = "*/45 * * * * ?")
	public void execute() {
		LOGGER.info("-------------------- Executando job --------------------");
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeConverter())
				.registerTypeAdapter(LocalDate.class, new LocalDateConverter())
		 .create();
 
		String json = gson.toJson(lancamentoContaMock.getMockInstance());

		LOGGER.info("Enviando para a fila a mensagem: =>" + json);
		queueSender.send(json);

		LOGGER.info("-------------------- Finalizando job --------------------");
	}
}
