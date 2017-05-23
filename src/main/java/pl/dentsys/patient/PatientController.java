package pl.dentsys.patient;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dentsys.patient.api.PatientSaveDto;

@RestController
public class PatientController {
    
    @RequestMapping(value = "/add-patient", method = RequestMethod.POST)
    void savePatients(@RequestBody PatientSaveDto patient) {
        
    }

}
