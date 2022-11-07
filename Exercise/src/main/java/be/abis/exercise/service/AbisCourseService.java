package be.abis.exercise.service;

import be.abis.exercise.exceptions.CourseAlreadyExistsException;
import be.abis.exercise.exceptions.CourseNotFoundException;
import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbisCourseService implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAllCourses();
    }

    @Override
    public Course findCourse(int id) throws CourseNotFoundException {
        return courseRepository.findCourse(id);
    }

    @Override
    public Course findCourse(String shortTitle) throws CourseNotFoundException {
        return courseRepository.findCourse(shortTitle);
    }

    @Override
    public void addCourse(Course course) throws CourseAlreadyExistsException {
        courseRepository.addCourse(course);
    }

    @Override
    public void updateCoursePrice(String id, double pricePerDay) throws CourseNotFoundException {
        courseRepository.updateCoursePrice(id, pricePerDay);
    }

    @Override
    public void deleteCourse(String id) throws CourseNotFoundException {
        courseRepository.deleteCourse(id);
    }
}
