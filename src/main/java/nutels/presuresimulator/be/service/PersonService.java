package nutels.presuresimulator.be.service;

import nutels.presuresimulator.be.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getAllPersons();
    Optional<Person> getPersonById(Long id);
    void createNewPerson(Person person);
    void deletePerson(Long id);
}
