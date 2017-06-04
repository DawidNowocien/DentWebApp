package pl.dentsys.patient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dentsys.patient.api.PatientDto;
import pl.dentsys.patient.api.PatientSearchCriteria;
import pl.dentsys.patient.api.PatientUpdateDto;

@RestController
public class PatientController {
    
    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    void savePatient(@RequestBody PatientDto patient) {
        
    }
    
    @RequestMapping(value = "/patient", method = RequestMethod.PUT)
    void updatePatient(@RequestBody PatientDto patient) {
        
    }
    
    @RequestMapping(value = "/patient/{patientId}", method = RequestMethod.GET)
    void getPatient(@PathVariable Long patientId) {
        
    }
    
    @RequestMapping(value = "/patient/{patientId}", method = RequestMethod.DELETE)
    void deletePatient(@PathVariable Long patientId) {
        
    }
    
    @RequestMapping(value = "/patient-list", method = RequestMethod.GET)
    void getPatientList(@RequestBody PatientSearchCriteria searchCriteria) {
        
    }

}
