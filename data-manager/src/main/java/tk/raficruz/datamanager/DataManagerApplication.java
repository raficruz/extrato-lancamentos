package tk.raficruz.datamanager;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.OPTIONS;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.web.cors.CorsConfiguration.ALL;

import java.util.Arrays;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAsync
@EnableRabbit
public class DataManagerApplication {

	@Value("${queue.name}")
    private String queueName;
	
	@Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }

	public static void main(String[] args) {
		SpringApplication.run(DataManagerApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin(ALL);

		config.setAllowedHeaders(Arrays.asList(HttpHeaders.CONTENT_TYPE, HttpHeaders.USER_AGENT, HttpHeaders.ORIGIN,
				HttpHeaders.AUTHORIZATION, HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS,
				HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS));

		config.setAllowedMethods(Arrays.asList(GET.name(), POST.name(), PUT.name(), DELETE.name(), OPTIONS.name()));

		config.addExposedHeader(AUTHORIZATION.toLowerCase());
		source.registerCorsConfiguration("/**", config);

		return new CorsFilter(source);
	}
}

