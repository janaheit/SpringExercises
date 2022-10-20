package be.abis.exercise;


import be.abis.exercise.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrainingServiceTest {

    @Autowired
    private TrainingService service;

    @Test
    void getsWelcomeMessageCorrectly(){
        assertEquals("Welcome to this course!", service.getWelcomeMessage());
    }

    @Test
    void findNameByIDWorks(){
        assertEquals("John", service.getPersonService().findPerson(1).getFirstName());
    }

    @Test
    void findCourseByIDWorks(){
        assertEquals("Workshop SQL", service.getCourseService().findCourse(7900).getShortTitle());
    }
}
