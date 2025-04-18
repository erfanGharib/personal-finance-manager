package ir.erfangharib.personal_finance_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PersonalFinanceManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalFinanceManagerApplication.class, args);
	}

}
