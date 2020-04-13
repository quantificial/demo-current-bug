package demo.democurrentbug;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class DemoCurrentBugApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCurrentBugApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner() {
		return args -> {
			log.info("running program");
		};
	}

}
