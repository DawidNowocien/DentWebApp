package pl.dentsys.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dentsys.visit.api.VisitSimpleDto;
import pl.dentsys.visit.service.VisitService;

@RestController
public class VisitController {
	
	@Autowired
	private VisitService visitService;
    
    @RequestMapping(value = "/visit",  produces = "application/json",method = RequestMethod.POST)
    public void savePatient(@RequestBody VisitSimpleDto visit) {

    	visitService.addVisit(visit);
    	
    }
    
  @RequestMapping(value = "/visit/{visitId}", method = RequestMethod.GET)
  public VisitSimpleDto getVisit(@PathVariable Long visitId) {
  	
  	return visitService.getVisit(visitId);
      
  }

}
