package be.abis.exercise.service;

import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import be.abis.exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AbisPersonService implements PersonService{

    @Autowired
    private PersonRepository repository;

    @Override
    public Person findPerson(int id) {
        return repository.findPerson(id);
    }

    @Override
    public Person findPerson(String emailAddress, String passWord) {
        return repository.findPerson(emailAddress, passWord);
    }

    @Override
    public List<Person> findAllPersons() {
        return repository.getAllPersons();
    }

    @Override
    public void addPerson(Person person) throws IOException {
        repository.addPerson(person);
    }

    @Override
    public void updatePerson(Person person, String newPassword) throws IOException {
        repository.changePassword(person, newPassword);
    }

    @Override
    public void deletePerson(int id) {
        repository.deletePerson(id);
    }
}
