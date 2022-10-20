package be.abis.exercise.service;

import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;

import java.io.IOException;
import java.util.List;

/**
 * Our manager class: will find all courses a person is following, sign a person
 * up for a course, etc.
 */
public interface PersonService {

    Person findPerson(int id);
    Person findPerson(String emailAddress, String passWord);
    List<Person> findAllPersons();
    void addPerson(Person person) throws IOException;
    void updatePerson(Person person, String newPassword) throws IOException;
    void deletePerson(int id);
}
