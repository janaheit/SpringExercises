package be.abis.exercise;

import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.CourseService;
import be.abis.exercise.service.PersonService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonServiceTest {

    @Autowired
    private PersonService service;

    @Test
    @Order(1)
    void findNameByID(){
        assertEquals("John", service.findPerson(1).getFirstName());
    }

    @Test
    @Order(2)
    void findIDByEmail(){
        assertEquals(1, service.findPerson("jdoe@abis.be",
                "def456").getPersonId());
    }

    @Test
    @Order(3)
    void findAllCoursesGives3(){
        assertEquals(3, service.findAllPersons().size());
    }

    @Test
    @Order(4)
    void addPerson() throws IOException {
        Address a = new Address("djgmq", "mqsd", "qdmlkg", 25);
        Company c = new Company("qsd", "25698", "dmq", a);
        Person p = new Person(4, "Jan", "Heitkemper", 24,"janheitkemper@web.de", "dqlkg", "DE", c);

        service.addPerson(p);
        List<String> lines = Files.readAllLines(Paths.get("/temp/javacourses/personsSpring.csv"));
        assertEquals(4, lines.size());
    }

    @Test
    @Order(5)
    void update4thPersonsPassword() throws IOException {
        Person p = service.findPerson(4);
        service.updatePerson(p, "123456");
    }

    @Test
    @Order(6)
    void deletePersonWithID4() throws IOException {

        service.deletePerson(4);

        List<String> lines = Files.readAllLines(Paths.get("/temp/javacourses/personsSpring.csv"));
        assertEquals(3, lines.size());
    }
}
