package pl.dentsys.treatment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dentsys.treatment.api.TreatmentDict;
import pl.dentsys.treatment.service.TreatmentService;

@RestController
public class TreatmentController {
	
	@Autowired
	private TreatmentService treatService;
	
    @RequestMapping(value = "/treatment/dict", method = RequestMethod.GET)
    public List<TreatmentDict> getTreatmentDict() {
  	
    	return treatService.getTreatmentDict();
      
    }
    
    @RequestMapping(value = "/treatment/dict/{treatmentId}", method = RequestMethod.GET)
    public TreatmentDict getSingleTreatment(@PathVariable Long treatmentId) {
  	
    	return treatService.getSingleTreatment(treatmentId);
      
    }

}
