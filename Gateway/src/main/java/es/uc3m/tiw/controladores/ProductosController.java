package es.uc3m.tiw.controladores;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import es.uc3m.tiw.dominio.Usuario;

@Controller
public class ProductosController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/crearProducto")
	public String saludar(){
		return "crearProductos";
	}
	
}
