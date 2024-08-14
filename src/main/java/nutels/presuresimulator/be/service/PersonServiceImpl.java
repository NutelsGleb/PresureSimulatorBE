package nutels.presuresimulator.be.service;

import nutels.presuresimulator.be.models.Person;
import nutels.presuresimulator.be.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public List<Person> getAllPersons() {
        try {
            return personRepo.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Optional<Person> getPersonById(Long id) {
        try {
            return personRepo.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void createNewPerson(Person person) {
        person.setFullame();
        personRepo.save(person);
    }

    @Override
    public void deletePerson(Long id){
        personRepo.deleteById(id);
    }
}