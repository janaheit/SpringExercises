package be.abis.exercise.service;

import be.abis.exercise.exceptions.CourseAlreadyExistsException;
import be.abis.exercise.exceptions.CourseNotFoundException;
import be.abis.exercise.model.Course;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CourseService {

    List<Course> findAllCourses();
    Course findCourse(int id) throws CourseNotFoundException;
    Course findCourse(String shortTitle) throws CourseNotFoundException;
    void addCourse(Course course) throws CourseAlreadyExistsException;
    void updateCoursePrice(String id, double pricePerDay) throws CourseNotFoundException;
    void deleteCourse(String id) throws CourseNotFoundException;
}
