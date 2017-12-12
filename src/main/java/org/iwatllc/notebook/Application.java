package org.iwatllc.notebook;

import org.iwatllc.notebook.infrastructure.person.PersonClassificationRepository;
import org.iwatllc.notebook.infrastructure.person.PersonRepository;
import org.iwatllc.notebook.infrastructure.user.UserRepository;
import org.iwatllc.notebook.model.person.Person;
import org.iwatllc.notebook.model.person.PersonClassification;
import org.iwatllc.notebook.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PersonRepository personRepository, PersonClassificationRepository classificationRepository, UserRepository userRepository) {
		
		return (args) -> {
			
				userRepository.save(new User("user", "$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu", true));
			
				PersonClassification low = classificationRepository.save(new PersonClassification("Low"));
				PersonClassification middle = classificationRepository.save(new PersonClassification("Middle"));
				PersonClassification upper = classificationRepository.save(new PersonClassification("Upper"));
				
				personRepository.save(new Person("Seymour", "Johnson", low));
				personRepository.save(new Person("Sandra", "Johnson", middle));
				personRepository.save(new Person("Larry", "Peters", upper));
				personRepository.save(new Person("Justin", "Smith", low));
				personRepository.save(new Person("Don", "Smith", upper));
				personRepository.save(new Person("Erin", "Peters", middle));
				
				log.info("Persons found with findAll()");
				log.info("----------------------------");
				for(Person p : personRepository.findAll()) {
					log.info(p.toString());
				}
				log.info("");
				
				//fetch an individual person by ID
				Person p = personRepository.findOne(1L);
				log.info("Person found with findOne(1)");
				log.info("----------------------------");
				log.info(p.toString());
				log.info("");
				
				//find persons by last name
				log.info("Person found with findByLastName('Smith')");
				log.info("-----------------------------------------");
				for(Person smith : personRepository.findByLastName("Smith")) {
					log.info(smith.toString());;
				}
				log.info("");
				
				//find persons by first name
				log.info("Person found with findByFirstName('Greg')");
				log.info("-----------------------------------------");
				for(Person smith : personRepository.findByFirstName("Greg")) {
					log.info(smith.toString());;
				}
				log.info("");
				
				
		};
	}
}
