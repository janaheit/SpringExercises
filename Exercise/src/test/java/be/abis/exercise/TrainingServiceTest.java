package be.abis.exercise;


import be.abis.exercise.exceptions.EnrollException;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void enrollJohnForWorkshopSQL() throws EnrollException {
        Person p = service.getPersonService().findPerson(1);
        Course c = service.getCourseService().findCourse(7900);

        // check manually
        service.enrollForSession(p, c, LocalDate.now().plusDays(1));
    }

    @Test
    void enrollJohnInPastThrowsException(){
        Person p = service.getPersonService().findPerson(1);
        Course c = service.getCourseService().findCourse(7900);

        assertThrows(EnrollException.class, () -> service.enrollForSession(p, c, LocalDate.now().minusDays(1)));
    }
}
