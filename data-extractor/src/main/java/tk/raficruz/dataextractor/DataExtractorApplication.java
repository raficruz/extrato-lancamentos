package tk.raficruz.dataextractor;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAsync
@EnableRabbit
@EnableScheduling
public class DataExtractorApplication {

	@Value("${queue.name}")
    private String queueName;
	
	@Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }

	public static void main(String[] args) {
		SpringApplication.run(DataExtractorApplication.class, args);
	}
}
