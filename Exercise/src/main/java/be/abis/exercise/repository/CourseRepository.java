package be.abis.exercise.repository;

import be.abis.exercise.exceptions.CourseAlreadyExistsException;
import be.abis.exercise.exceptions.CourseNotFoundException;
import be.abis.exercise.model.Course;

import java.util.List;


public interface CourseRepository {

	List<Course> findAllCourses();
	Course findCourse(int id) throws CourseNotFoundException;
	Course findCourse(String shortTitle) throws CourseNotFoundException;
	void addCourse(Course course) throws CourseAlreadyExistsException;
	void deleteCourse(String id) throws CourseNotFoundException;
	void updateCoursePrice(String id, double pricePerDay) throws CourseNotFoundException;

}
