package es.uc3m.tiw.controladores;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import es.uc3m.tiw.dominio.Producto;
import es.uc3m.tiw.dominio.Usuario;
@SessionAttributes("logueado")
@Controller
public class IndexController {
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/")
	public String saludar(Model modelo){
		
		modelo.addAttribute("usuario",new Usuario());
		modelo.addAttribute("logueado",false);
		ResponseEntity responseEntity=restTemplate.getForEntity("http://localhost:8020/getProductos", Producto[].class);
		Producto[] productos = (Producto[]) responseEntity.getBody();
		List<Producto> lista= Arrays.asList(productos);
		modelo.addAttribute("lista",lista);
		return "index";
	}
	@RequestMapping(value="/crear")
	public String productos(){
		return "crearProductos";
	}
	@RequestMapping(value="/index")
	public String index(Model modelo){
		ResponseEntity responseEntity=restTemplate.getForEntity("http://localhost:8020/getProductos", Producto[].class);
		Producto[] productos = (Producto[]) responseEntity.getBody();
		List<Producto> lista= Arrays.asList(productos);
		modelo.addAttribute("lista",lista);
		return "index";
	}
	@RequestMapping(value="/cerrarSesion")
	public String index2(Model modelo, @SessionAttribute boolean logueado){
		ResponseEntity responseEntity=restTemplate.getForEntity("http://localhost:8020/getProductos", Producto[].class);
		Producto[] productos = (Producto[]) responseEntity.getBody();
		List<Producto> lista= Arrays.asList(productos);
		modelo.addAttribute("lista",lista);
		logueado=false;
		modelo.addAttribute("logueado", logueado);
		modelo.addAttribute("usuario",new Usuario());
		return "index";
	}
	
}
