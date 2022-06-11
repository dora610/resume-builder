package link.karurisuro.resumeportal;

import link.karurisuro.resumeportal.models.Education;
import link.karurisuro.resumeportal.models.Job;
import link.karurisuro.resumeportal.models.User;
import link.karurisuro.resumeportal.models.UserProfile;
import link.karurisuro.resumeportal.repository.EducationRepository;
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
import java.util.Optional;

@SpringBootApplication
public class ResumePortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResumePortalApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner initializeDb(UserRepository userRepository,
                                          UserProfileRepository userProfileRepository,
                                          JobRepository jobRepository,
                                          EducationRepository educationRepository) {
        return (x) -> {
            userRepository.save(new User("binod", "{noop}binod", true, "USER"));
			UserProfile userProfile = new UserProfile("binod", 3, "It\'s all about Binod", "Binod", "Bonku", "binod@binod.com", "123123", "Asst. Manager");
            userProfile.setSkills(Arrays.asList("JavaScript", "NodeJs", "ReactJs", "NextJs", "Spring Boot", "mySql", "mongoDB", "TailwindCSS"));
            userProfileRepository.save(userProfile);
            Job job1 = new Job("Toto company","Asst. manager", LocalDate.now().minusYears(4L), LocalDate.now(), true, userProfile);
            Job job2 = new Job("Moto company","Trainee", LocalDate.now().minusYears(5L), LocalDate.now().minusYears(7L), false,userProfile);
            job1.setResponsibilities(Arrays.asList("Lorem ipsum dolor sit amet consectetur adipisicing elit.Consequatur quaerat, facere dolores, enim inventore aperiam ad assumenda rerum praesentium fugiat sed veniam quos at obcaecati maiores, atque error dicta minima.", "Lorem ipsum dolor sit amet consectetur adipisicing elit.Consequatur quaerat"));
            job2.setResponsibilities(Arrays.asList("Lorem ipsum dolor sit amet consectetur adipisicing elit", "Lorem ipsum dolor sit amet consectetur"));
            jobRepository.saveAll(Arrays.asList(job1, job2));
            Education edu1 =  new Education("B.E", "IITK", 9.12f, LocalDate.of(2007, Month.JUNE, 01), LocalDate.of(2011, Month.MAY, 01), userProfile);
            Education edu2 =  new Education("Higher Secondary", "MBSI", 92.5f, LocalDate.of(2009, 05, 01), LocalDate.of(2007, 04, 01), userProfile);
            Education edu3 =  new Education("Secondary", "MBSI", 96.4f, LocalDate.of(2007, 05, 01), LocalDate.of(2009, 05, 01), userProfile);
            educationRepository.saveAll(Arrays.asList(edu1, edu2, edu3));
        };
    }*/
}
