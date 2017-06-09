package pl.dentsys.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dentsys.common.Dict;
import pl.dentsys.doctor.api.DoctorDto;
import pl.dentsys.doctor.api.DoctorSearchCriteria;
import pl.dentsys.doctor.api.DoctorSimpleDto;
import pl.dentsys.doctor.service.DoctorService;

@RestController
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
    
    @RequestMapping(value = "/doctor",  produces = "application/json",method = RequestMethod.POST)
    public void saveDoctor(@RequestBody DoctorSimpleDto doctor) {

    	doctorService.addDoctor(doctor);
    	
    }
    
    @RequestMapping(value = "/doctor/{doctorId}", method = RequestMethod.PUT)
    public void updateDoctor(@RequestBody DoctorSimpleDto doctor,@PathVariable Long doctorId) {
    	
    	doctorService.updateDoctor(doctor, doctorId);
        
    }
    
    @RequestMapping(value = "/doctor/{doctorId}", method = RequestMethod.GET)
    public DoctorDto getDoctor(@PathVariable Long doctorId) {
    	
    	return doctorService.getDoctor(doctorId);
        
    }
    
    @RequestMapping(value = "/doctor/{doctorId}", method = RequestMethod.DELETE)
    public void deleteDoctor(@PathVariable Long doctorId) {
        
    	doctorService.deleteDoctor(doctorId);
    }
    
    @RequestMapping(value = "/doctor-list", method = RequestMethod.GET)
    public List<DoctorDto> getDoctorList(@ModelAttribute DoctorSearchCriteria searchCriteria) {
    	
    	return doctorService.searchDoctor(searchCriteria);
        
    }
    
   
    @RequestMapping(value = "/doctor/specialization/dict", method = RequestMethod.GET)
    public List<Dict> getSpecializationDict() {
  	
    	return doctorService.getSpecializationDict();
      
    }
    
    @RequestMapping(value = "/doctor/specialization/dict/{specializationId}", method = RequestMethod.GET)
    public Dict getSingleSpecialization(@PathVariable Long specializationId) {
  	
    	return doctorService.getSingleSpecialization(specializationId);
      
    }

}
