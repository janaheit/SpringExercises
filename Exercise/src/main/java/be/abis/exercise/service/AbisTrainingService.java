package be.abis.exercise.service;

import be.abis.exercise.exceptions.EnrollException;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AbisTrainingService implements TrainingService {

    @Autowired
    private PersonService personService;
    @Autowired
    private CourseService courseService;
    @Value("Welcome to this course!")
    private String welcomeMessage;

    @Override
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    @Override
    public List<Course> showFollowedCourses(Person person) {
        return null;
    }

    @Override
    public void enrollForSession(Person person, Course course, LocalDate date) throws EnrollException {

    }
}
