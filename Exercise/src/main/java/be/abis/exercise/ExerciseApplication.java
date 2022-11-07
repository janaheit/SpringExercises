package be.abis.exercise;

import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Some configs could go here...
 * the class that starts everything up -> all @ components won't work, if
 * they're not in this or lower in the directory tree
 */
@SpringBootApplication
public class ExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseApplication.class, args);
    }

    @Bean
    public TrainingService trainingService(PersonService ps, CourseService cs){
        TrainingService abisTrainingService = new AbisTrainingService();
        abisTrainingService.setPersonService(ps);
        abisTrainingService.setCourseService(cs);
        return abisTrainingService;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
