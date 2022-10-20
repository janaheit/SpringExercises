package be.abis.exercise;

import be.abis.exercise.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
    public TrainingService trainingService(){
        TrainingService abisTrainingService = new AbisTrainingService();
        //abisTrainingService.setPersonService();
        return abisTrainingService;
    }
}
