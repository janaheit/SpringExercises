package be.abis.exercise.repository;

import be.abis.exercise.exceptions.CourseAlreadyExistsException;
import be.abis.exercise.exceptions.CourseNotFoundException;
import be.abis.exercise.model.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class MemoryCourseRepository implements CourseRepository {
	
	private ArrayList<Course> courses = new ArrayList<Course>();
	
	
	public MemoryCourseRepository(){
		courses.add(new Course("7850","DB2, an overview","DB2, an overview",5,550.0));
		courses.add(new Course("7900","Workshop SQL","Workshop SQL",3,475.0));
		courses.add(new Course("8000","Java Prog","Java Programming",5,500.0));
		courses.add(new Course("8050","Maven","Maven",1,450.0));
		courses.add(new Course("8100","Spring","Programming with Spring",3,525.0));
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	
	@Override
	public List<Course> findAllCourses() {
		return courses;
	}

	@Override
	public Course findCourse(int id) throws CourseNotFoundException {
		return courses.stream().filter(c->c.getCourseId().equals(id+"")).findFirst().orElseThrow(() -> new CourseNotFoundException("This course does not exist."));
	}

	@Override
	public Course findCourse(String shortTitle) throws CourseNotFoundException {
		return courses.stream().filter(c->c.getShortTitle().equalsIgnoreCase(shortTitle)).findFirst().orElseThrow(() -> new CourseNotFoundException("This course does not exist."));
	}

	@Override
	public void addCourse(Course course) throws CourseAlreadyExistsException {
		if (this.courses.contains(course)) throw new CourseAlreadyExistsException("This course '"
				+ course.getShortTitle() + "' already exists.");

		this.courses.add(course);
	}

	@Override
	public void deleteCourse(String id) throws CourseNotFoundException {
		Iterator<Course> iterator = this.courses.iterator();

		Boolean found = false;

		while (iterator.hasNext()){
			Course c = iterator.next();
			if (c.getCourseId().equals(id)) {
				iterator.remove();
				found=true;
			}
		}

		if (!found) throw new CourseNotFoundException("The course with id " + id + " was not found and could therefore not be deleted.");
	}

	@Override
	public void updateCoursePrice(String id, double pricePerDay) throws CourseNotFoundException {
		boolean found = false;
		for (Course c:this.courses){
			if (c.getCourseId().equals(id)){
				c.setPricePerDay(pricePerDay);
				found = true;
			}
		}

		if (!found) throw new CourseNotFoundException("The course with id "
				+ id + " could not be found and therefore was not updated.");
	}


}
