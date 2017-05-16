package pl.dentsys;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    List<String> partialHandler() {
    	List<String> list=new ArrayList<String>();
    	list.add("test");
        return list;
    }

}
