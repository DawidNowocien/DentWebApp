package pl.dentsys.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    String getPatients() {
    	
        return "Test";
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    String savePatients() {
    	
        return "Test";
    }

}
