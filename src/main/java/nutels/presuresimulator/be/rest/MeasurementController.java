package nutels.presuresimulator.be.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import nutels.presuresimulator.be.endpionts.APIv1;
import nutels.presuresimulator.be.models.ErrorMassege;
import nutels.presuresimulator.be.models.Measurement;
import nutels.presuresimulator.be.models.Person;
import nutels.presuresimulator.be.service.MeasurementService;
import nutels.presuresimulator.be.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@Tag(name = "Measurements controller")
public class MeasurementController {

    private final MeasurementService measurementService;
    private final PersonService personService;

    @Autowired
    public MeasurementController(MeasurementService mesurementService, PersonService personService) {
        this.measurementService = mesurementService;
        this.personService = personService;
    }

    //Get measurments by personId
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = APIv1.API_URL_MEASUREMENTS +"/{personId}", method = RequestMethod.GET)
    @Operation
    public HttpEntity<Iterable<Measurement>> getPersonMeasurements(@PathVariable Long personId) {
        Iterable<Measurement> result = measurementService.getMeasurements(personId);
        return ResponseEntity
                .status((result != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(result);
    }

    //Post new measurement
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = APIv1.API_URL_MEASUREMENT +"/{personId}", method = RequestMethod.POST)
    @Operation
    public HttpEntity<Object> createMeasurement(@RequestBody Measurement measurement, @PathVariable Long personId) {
        Optional<Person> currentPerson = personService.getPersonById(personId);
        if(currentPerson.isPresent()){
            measurement.setPerson(currentPerson.get());
            measurementService.createNewMeasurement(measurement);
            System.out.println("Measurement ID:" + measurement.getId()+ " for " + measurement.getPerson().getFullname()+" created");
            return ResponseEntity.status(HttpStatus.CREATED).body(measurement);
        }else{
            ErrorMassege eMessage = new ErrorMassege("Person with id:"+personId+" not exist, can't write measurement");
            System.out.println(eMessage.error);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(eMessage);
        }

    }

    //delete all measurements for person
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = APIv1.API_URL_MEASUREMENTS +"/{personId}", method = RequestMethod.DELETE)
    @Operation
    public HttpEntity<String> deleteMeasurementsForPerson(@PathVariable Long personId) {
        measurementService.clearMeasurements(personId);
        System.out.println("All measurements for Person ID: " + personId + " are deleted");
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

