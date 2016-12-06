package es.uc3m.tiw.controladores;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class IndexController {

	
	@RequestMapping(value="/")
	public String saludar(){
		return "index";
	}
	@RequestMapping(value="/crear")
	public String productos(){
		return "crearProductos";
	}
	
}
