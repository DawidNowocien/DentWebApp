package pl.dentsys;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    String getPatients() {
    	
        return "Test";
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    String savePatients() {
    	
        return "Test";
    }
    
//    @RequestMapping("/")
//    String home(ModelMap modal) {
//        modal.addAttribute("title","CRUD Example");
//        return "index";
//    }

}
