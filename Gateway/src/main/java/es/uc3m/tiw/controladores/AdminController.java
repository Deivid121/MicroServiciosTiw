package es.uc3m.tiw.controladores;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import es.uc3m.tiw.dominio.Administrador;
import es.uc3m.tiw.dominio.Producto;
import es.uc3m.tiw.dominio.Usuario;

@SessionAttributes(value={"adminlogueado","adminValidado"})
@Controller
public class AdminController {
	@Autowired
	RestTemplate restTemplate;

	
	@RequestMapping("/panelAdmin")
	public String formularioAdmin(Model modelo, @ModelAttribute Administrador administrador){
		Administrador admin = new Administrador();
		modelo.addAttribute("AdminValidado",admin);
		modelo.addAttribute("logueadoAdmin", false);
		return "LoginAdmin";
	}

	@RequestMapping(value="/perfilAdministrador",method=RequestMethod.GET)
	public String verAdmin(Model modelo, @ModelAttribute Administrador administrador){
		System.out.println(administrador);
		return "perfilAdmin";
		
	}
	
	@RequestMapping(value="/editarAdmin")
	public String editarUsuarios(Model modelo){
		modelo.addAttribute(new Administrador());
		return "editarAdmin";
	}
	@PostMapping("/editarA")
	public String actualizarUsuario(Model modelo, @ModelAttribute Usuario usuario){
		System.out.println(usuario);
		Usuario usuarioValidado = restTemplate.postForObject("http://localhost:8010/editarA", usuario, Usuario.class);
		modelo.addAttribute("usuarioValidado",usuarioValidado);
		return "perfilUsuario";
		
	}
	
	@RequestMapping(value="/eliminarUsuarioAdmin", method=RequestMethod.GET)
	public String borrarUsuario(Model modelo, HttpServletRequest request){
		HttpSession sesion =request.getSession();
		Usuario usuario = (Usuario)sesion.getAttribute("AdminValidado");
		
		return usuario.toString();
	}
	@PostMapping("/loguearAdmin")
	public String validarAdmin(Model modelo, @ModelAttribute Administrador admin){
		Administrador adminValidado = restTemplate.postForObject("http://localhost:8010/loginAdmin", admin, Administrador.class);
		ResponseEntity responseEntity=restTemplate.getForEntity("http://localhost:8020/getProductos", Producto[].class);
		Producto[] productos = (Producto[]) responseEntity.getBody();
		List<Producto> lista= Arrays.asList(productos);
		modelo.addAttribute("listaProductos",lista);
		ResponseEntity responseEntityU=restTemplate.getForEntity("http://localhost:8010/getUsuarios", Producto[].class);
		Usuario[] usuarios = (Usuario[]) responseEntity.getBody();
		List<Usuario> listaU= Arrays.asList(usuarios);
		modelo.addAttribute("listaUsuarios",lista);
		modelo.addAttribute("adminValidado",adminValidado);
		modelo.addAttribute("adminLogueado", true);
		return "panelAdmin";
		
	}
	
	
	
}
