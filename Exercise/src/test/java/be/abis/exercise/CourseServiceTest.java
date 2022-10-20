package be.abis.exercise;

import be.abis.exercise.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CourseServiceTest {

    @Autowired
    private CourseService service;

    @Test
    void findTitleOfCourseID7900(){
        assertEquals("Workshop SQL", service.findCourse(7900).getShortTitle());
    }

    @Test
    void findIDOfCourseNameWorkshopSQL(){
        assertEquals("7900", service.findCourse("Workshop SQL").getCourseId());
    }

    @Test
    void findAllCoursesGives3(){
        assertEquals(5, service.findAllCourses().size());
    }
}
