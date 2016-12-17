package es.uc3m.tiw.controladores;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;


import es.uc3m.tiw.dominio.Administrador;
import es.uc3m.tiw.dominio.Men;
import es.uc3m.tiw.dominio.Producto;
import es.uc3m.tiw.dominio.Usuario;

@SessionAttributes(value={"adminLogueado","adminValidado"})
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
		
		modelo.addAttribute("adminValidado",adminValidado);
		modelo.addAttribute("adminLogueado", true);
		modelo.addAttribute("err", new Men(""));
		return "redirect:cargarAdmin";
		
	}

	@RequestMapping(value="/cargarAdmin",method=RequestMethod.GET)
	public String cargar(Model modelo){
		ResponseEntity responseEntity=restTemplate.getForEntity("http://localhost:8020/getProductos", Producto[].class);
		Producto[] productos = (Producto[]) responseEntity.getBody();
		List<Producto> lista= Arrays.asList(productos);
		modelo.addAttribute("listaProductos",lista);
		ResponseEntity responseEntityU=restTemplate.getForEntity("http://localhost:8010/getUsuarios", Usuario[].class);
		Usuario[] usuarios = (Usuario[]) responseEntityU.getBody();
		List<Usuario> listaU= Arrays.asList(usuarios);
		modelo.addAttribute("listaUsuarios",listaU);
		modelo.addAttribute("adminLogueado", true);
		modelo.addAttribute("err", new Men(""));
		return "panelAdmin";

	}
	
	@RequestMapping(value="/eliminarU/{id}", method=RequestMethod.GET)
	public String borrarUsuarioAdmin(Model modelo,@PathVariable String id,@SessionAttribute("adminLogueado") boolean admin ){
		 Map <String, Long>vars= new HashMap<String, Long>();
		vars.put("id", Long.parseLong(id));
		restTemplate.delete("http://localhost:8010/eliminarU/{id}",vars);
		
		if(admin){
			modelo.addAttribute("err", new Men(""));
			return "redirect:/cargarAdmin";
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/eliminarP/{id}", method=RequestMethod.GET)
	public String borrarProductoAdmin(Model modelo,@PathVariable String id,@SessionAttribute("adminLogueado") boolean admin){
		Map<String, Long> vars = new HashMap<String, Long>();
		vars.put("id", Long.parseLong(id));
		restTemplate.delete("http://localhost:8020/eliminarP/{id}",vars);
		if(admin){
			modelo.addAttribute("err", new Men(""));
			return "redirect:/cargarAdmin";
		}
		else{
			return "redirect:/verMisProductos";
		}
	}
	
	@RequestMapping(value="/verUsuario/{id}", method=RequestMethod.GET)
	public String verUsuarioAdmin(Model modelo,@PathVariable String id ){
		Map<String, Long> vars = new HashMap<String, Long>();
		vars.put("id", Long.parseLong(id));
		Usuario u=restTemplate.getForObject("http://localhost:8010/buscarPorId/{id}",Usuario.class,vars);
		modelo.addAttribute("u",u);
		return "perfilUsuario";
	}
	
}
