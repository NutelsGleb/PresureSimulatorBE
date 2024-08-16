package nutels.presuresimulator.be.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import nutels.presuresimulator.be.endpionts.APIv1;
import nutels.presuresimulator.be.models.GeneratedPresure;
import nutels.presuresimulator.be.service.GeneratedPresureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Tag(name = "Generator controller")
public class PresureGeneratorController {

    private final ApplicationContext context;

    @Autowired
    public PresureGeneratorController(ApplicationContext context) {
        this.context = context;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = APIv1.API_URL_PRESURE_GENERATOR, method = RequestMethod.GET)
    @Operation
    public HttpEntity <GeneratedPresure> getGeneratedPresure(){

        GeneratedPresure result = context.getBean(GeneratedPresure.class);
        return ResponseEntity
                .status((result != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(result);
    }
}
