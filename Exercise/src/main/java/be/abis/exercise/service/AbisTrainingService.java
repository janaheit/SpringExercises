package be.abis.exercise.service;

import be.abis.exercise.exceptions.EnrollException;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

//@Service
public class AbisTrainingService implements TrainingService {

    //@Autowired
    private PersonService personService;
    //@Autowired
    private CourseService courseService;

    @Value("Welcome to this course!")
    private String welcomeMessage;

    @PostConstruct
    public void init(){
        System.out.println("AbisTrainingService is ready for work!");
    }

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
        if (date.isBefore(LocalDate.now())) throw new EnrollException("Date is in the past.");
        System.out.println(person.getFirstName() + " is now enrolled for the "
                                + course.getShortTitle() + " course on " + date);
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }
}
