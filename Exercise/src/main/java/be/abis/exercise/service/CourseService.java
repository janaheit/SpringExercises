package be.abis.exercise.service;

import be.abis.exercise.model.Course;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CourseService {

    List<Course> findAllCourses();
    Course findCourse(int id);
    Course findCourse(String shortTitle);
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Course course);
}
