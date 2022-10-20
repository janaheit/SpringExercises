package be.abis.exercise.service;

import be.abis.exercise.exceptions.EnrollException;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;

import java.time.LocalDate;
import java.util.List;

public interface TrainingService {

    String getWelcomeMessage();
    List<Course> showFollowedCourses(Person person);
    void enrollForSession(Person person, Course course, LocalDate date) throws EnrollException;
    PersonService getPersonService();
    CourseService getCourseService();
    void setPersonService(PersonService personService);
    void setCourseService(CourseService courseService);
}
