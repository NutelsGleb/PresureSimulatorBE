package nutels.presuresimulator.be.rest;

//import com.google.common.collect.Iterables;
import nutels.presuresimulator.be.endpionts.APIv1;
import nutels.presuresimulator.be.models.ErrorMassege;
import nutels.presuresimulator.be.models.Person;
import nutels.presuresimulator.be.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //Get all persons
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = APIv1.API_URL_PERSONS, method = RequestMethod.GET)
    public HttpEntity<Iterable<Person>> getPeople() {

        Iterable<Person> result = personService.getAllPersons();
        return ResponseEntity
                .status((result != null /*&& Iterables.size(result) > 0*/) ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(result);
    }

    //Post new person
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = APIv1.API_URL_PERSON, method = RequestMethod.POST)
    public HttpEntity<Object> createPerson(@RequestBody Person person) {
        Iterable<Person> listOfPersons = personService.getAllPersons();
        for (Person existingPerson : listOfPersons) {
            if (existingPerson.equals(person)) {
                ErrorMassege eMessage = new ErrorMassege("This person already exist");
                System.out.println(eMessage.error);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(eMessage);
            }
        }
        personService.createNewPerson(person);
        System.out.println("Person with ID:" + person.getId() + " created");
        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }

    //Get person by id
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = APIv1.API_URL_PERSON + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Person>> getPerson(@PathVariable Long id) {
        Optional<Person> result = personService.getPersonById(id);
        return ResponseEntity
                .status((result != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(result);
    }

    //Delete person by id
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = APIv1.API_URL_PERSON+ "/{id}", method = RequestMethod.DELETE)
    public HttpEntity<String> deletePerson(@PathVariable Long id) {
        System.out.println("deleted Person ID: " + id);
        personService.deletePerson(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //todo Patch person by id
}

