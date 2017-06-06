package pl.dentsys.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dentsys.patient.api.PatientSimpleDto;
import pl.dentsys.patient.api.PatientDto;
import pl.dentsys.patient.api.PatientSearchCriteria;
import pl.dentsys.patient.service.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	private PatientService patientService;
    
    @RequestMapping(value = "/patient",  produces = "application/json",method = RequestMethod.POST)
    public void savePatient(@RequestBody PatientSimpleDto patient) {

    	patientService.addPatient(patient);
    	
    }
    
    @RequestMapping(value = "/patient/{patientId}", method = RequestMethod.PUT)
    public void updatePatient(@RequestBody PatientDto patient,@PathVariable Long patientId) {
    	
    	patientService.updatePatient(patient, patientId);
        
    }
    
    @RequestMapping(value = "/patient/{patientId}", method = RequestMethod.GET)
    public PatientSimpleDto getPatient(@PathVariable Long patientId) {
    	
    	return patientService.getPatient(patientId.longValue());
        
    }
    
    @RequestMapping(value = "/patient/{patientId}", method = RequestMethod.DELETE)
    public void deletePatient(@PathVariable Long patientId) {
        
    	patientService.deletePatient(patientId);
    }
    
    @RequestMapping(value = "/patient-list", method = RequestMethod.GET)
    public List<PatientDto> getPatientList(@ModelAttribute PatientSearchCriteria searchCriteria) {
    	
    	return patientService.searchPatient(searchCriteria);
        
    }

}
