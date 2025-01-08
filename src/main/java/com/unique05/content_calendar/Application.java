package com.unique05.content_calendar;

import com.unique05.content_calendar.config.ContentCalendarProperties;
import com.unique05.content_calendar.model.Content;
import com.unique05.content_calendar.model.Status;
import com.unique05.content_calendar.model.Type;
import com.unique05.content_calendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
//	@Bean
//	CommandLineRunner commandLineRunner(ContentRepository repository) { //A way to programmatically insert data to the database
//		return args -> {
//			Content c = new Content(null,
//					"Hello Chat GPT",
//					"All about Chat GPT",
//					Status.IDEA,
//					Type.ARTICLE,
//					LocalDateTime.now(),
//					null,
//					"");
//			repository.save(c);
//		};
//
//	}

}
