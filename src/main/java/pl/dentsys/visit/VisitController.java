package pl.dentsys.visit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dentsys.visit.api.VisitDto;
import pl.dentsys.visit.api.VisitSearchCriteria;
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
    
    @RequestMapping(value = "/visit/{visitId}", method = RequestMethod.PUT)
    public void updateVisit(@RequestBody VisitSimpleDto visit,@PathVariable Long visitId) {
    	
    	visitService.updateVisit(visit, visitId);
        
    }
    
    @RequestMapping(value = "/visit/{visitId}", method = RequestMethod.GET)
    public VisitDto getVisit(@PathVariable Long visitId) {
  	
    	return visitService.getVisit(visitId);
      
    }
    
    @RequestMapping(value = "/visit/{visitId}", method = RequestMethod.DELETE)
    public void deleteVisit(@PathVariable Long visitId) {
        
    	visitService.deleteVisit(visitId);
    }
    
    @RequestMapping(value = "/visit-list", method = RequestMethod.GET)
    public List<VisitDto> getVisitList(@ModelAttribute VisitSearchCriteria searchCriteria) {
    	
    	return visitService.searchVisit(searchCriteria);
        
    }

}
