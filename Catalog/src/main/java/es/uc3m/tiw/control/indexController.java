package es.uc3m.tiw.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class indexController {
	
	@RequestMapping(value="/")
	public String saludar(){
		return "index";
	}
		
}

