package link.karurisuro.resumeportal;

import link.karurisuro.resumeportal.models.User;
import link.karurisuro.resumeportal.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResumePortalApplication {
	public static void main(String[] args) {
		SpringApplication.run(ResumePortalApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner initializeDb(UserRepository userRepository){
		return (x)->{
			userRepository.save(new User(1L, "binod", "binod", true, "USER"));
			userRepository.save(new User(2L, "sam", "sam", true, "USER"));


			userRepository.findAll().forEach(System.out::println);
		};
	}*/
}
