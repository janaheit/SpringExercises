package be.abis.exercise.controller;

import be.abis.exercise.apimodel.PriceUpdateModel;
import be.abis.exercise.apimodel.ShortTitleModel;
import be.abis.exercise.exceptions.CourseAlreadyExistsException;
import be.abis.exercise.exceptions.CourseNotFoundException;
import be.abis.exercise.model.Course;
import be.abis.exercise.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping(value="/course")
@Validated
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping()
    public List<Course> findAllCourses(){
        return courseService.findAllCourses();
    }

    @GetMapping("{id}")
    public Course findCourseByID(@PathVariable @Digits(integer = 4, fraction = 0) int id) throws CourseNotFoundException {
        return courseService.findCourse(id);
    }

    @GetMapping("/query")
    public Course findCourseByShortTitle(@RequestBody ShortTitleModel shortTitleModel) throws CourseNotFoundException {
        return courseService.findCourse(shortTitleModel.getShortTitle());
    }

    @PostMapping()
    public void addCourse(@RequestBody Course course) throws CourseAlreadyExistsException {
        courseService.addCourse(course);
    }

    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable String id) throws CourseNotFoundException {
        courseService.deleteCourse(id);
    }

    @PatchMapping("{id}")
    public void updateCoursePrice(@RequestBody PriceUpdateModel priceUpdateModel) throws CourseNotFoundException {
        courseService.updateCoursePrice(priceUpdateModel.getId(), priceUpdateModel.getPricePerDay());
    }

}
