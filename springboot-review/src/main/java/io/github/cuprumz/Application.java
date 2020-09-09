package io.github.cuprumz;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.cuprumz.dao.PersonRepository;
import io.github.cuprumz.model.Person;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner demo(PersonRepository personRepository) {
		return args -> {

			personRepository.deleteAll();

			Person greg = new Person("1", "Greg");
			Person roy = new Person("1", "Roy");
			Person craig = new Person("1", "Craig");

			List<Person> team = Arrays.asList(greg, roy, craig);

			personRepository.saveAll(team);
			log.info("Lookup each person by name...");
			team.stream().forEach(
					person -> log.info("\t" + personRepository.findByLastName(person.getLastName()).toString()));
		};
	}

}
