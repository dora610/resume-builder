package link.karurisuro.resumeportal;

import link.karurisuro.resumeportal.models.Job;
import link.karurisuro.resumeportal.models.User;
import link.karurisuro.resumeportal.models.UserProfile;
import link.karurisuro.resumeportal.repository.JobRepository;
import link.karurisuro.resumeportal.repository.UserProfileRepository;
import link.karurisuro.resumeportal.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class ResumePortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResumePortalApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner initializeDb(UserRepository userRepository,
                                          UserProfileRepository userProfileRepository,
                                          JobRepository jobRepository) {
        return (x) -> {
            userRepository.save(new User("binod", "{noop}binod", true, "USER"));
			UserProfile userProfile = new UserProfile("binod", 3, "It\'s all about Binod", "Binod", "Bonku", "binod@binod.com", "123123", "Asst. Manager");
            userProfile.setUgUniversity("IITB");
            userProfile.setUgFrom(LocalDate.of(2007, Month.JUNE, 01));
            userProfile.setUgTo(LocalDate.of(2011, Month.MAY, 01));
            userProfile.setUgCGPA(9.00f);
            userProfile.setHigherSecondary("MBSI");
            userProfile.setHsFrom(LocalDate.of(2009, 05, 01));
            userProfile.setHsTo(LocalDate.of(2011, 04, 01));
            userProfile.setHsPercentage(85.5f);
            userProfile.setSecondary("MBSI");
            userProfile.setSFrom(LocalDate.of(2007, 05, 01));
            userProfile.setSTo(LocalDate.of(2009, 05, 01));
            userProfile.setSPercentage(95.0f);
            userProfileRepository.save(userProfile);
            Job job1 = new Job("Toto company","Asst. manager", LocalDate.now().minusYears(4L), LocalDate.now(), true, userProfile);
            Job job2 = new Job("Moto company","Trainee", LocalDate.now().minusYears(5L), LocalDate.now().minusYears(7L), false,userProfile);
            job1.setResponsibilities(Arrays.asList("Lorem ipsum dolor sit amet consectetur adipisicing elit.Consequatur quaerat, facere dolores, enim inventore aperiam ad assumenda rerum praesentium fugiat sed veniam quos at obcaecati maiores, atque error dicta minima.", "Lorem ipsum dolor sit amet consectetur adipisicing elit.Consequatur quaerat"));
            job2.setResponsibilities(Arrays.asList("Lorem ipsum dolor sit amet consectetur adipisicing elit", "Lorem ipsum dolor sit amet consectetur"));
            jobRepository.saveAll(Arrays.asList(job1, job2));
        };
    }*/
}
