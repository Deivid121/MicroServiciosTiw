package es.uc3m.tiw.controladores;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class IndexController {

	
	@RequestMapping(value="/inicio", method=RequestMethod.GET)
	public String saludar(){
		return "index";
	}
	
}
