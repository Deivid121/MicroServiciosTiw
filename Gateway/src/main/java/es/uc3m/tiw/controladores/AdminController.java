package es.uc3m.tiw.controladores;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public String formularioAdmin(Model modelo, @ModelAttribute Administrador administrador ){
		Administrador admin = new Administrador();
		modelo.addAttribute("adminValidado",admin);
		modelo.addAttribute("logueadoAdmin", false);
		modelo.addAttribute("err", new Men(""));
		return "LoginAdmin";
	}

	@RequestMapping(value="/perfilAdministrador",method=RequestMethod.GET)
	public String verAdmin(Model modelo, @ModelAttribute Administrador administrador){
		return "perfilAdmin";
		
	}
	
	@RequestMapping(value="/editarAdmin/{id}")
	public String editarUsuarios(Model modelo, @PathVariable long id, @SessionAttribute("adminLogueado") boolean admin){
		if(admin){
		modelo.addAttribute("boolbus", false);
		Usuario nuevo = new Usuario();
		Map<String, Long> vars = new HashMap<String, Long>();
		vars.put("id", id);
		Usuario u=restTemplate.getForObject("http://localhost:8010/buscarPorId/{id}",Usuario.class,vars);
		modelo.addAttribute("u",u);
		System.out.println(u);
		modelo.addAttribute("nuevo", nuevo);
		return "editarUsuarioAdmin";
		}else{
			Administrador admin2 = new Administrador();
			modelo.addAttribute("AdminValidado",admin2);
			modelo.addAttribute("err", new Men("No se ha introducido un administrador correcto"));
			return "LoginAdmin";
		}
	}
	
	//EDITAR PRODUCTOS ADMIN 
	@RequestMapping(value="/productoAdmin/{id}")
	public String editarProducto(Model modelo, @PathVariable long id, @SessionAttribute("adminLogueado") boolean admin){
		if(admin){
		modelo.addAttribute("boolbus", false);
		Producto nuevo = new Producto();
		Map<String, Long> vars = new HashMap<String, Long>();
		vars.put("id", id);
		Producto p=restTemplate.getForObject("http://localhost:8020/buscarPorId/{id}",Producto.class,vars);
		modelo.addAttribute("p",p);
		modelo.addAttribute("nuevo", nuevo);
		return "editarProductoAdmin";
		}else{
			Administrador admin2 = new Administrador();
			modelo.addAttribute("AdminValidado",admin2);
			modelo.addAttribute("err", new Men("No se ha introducido un administrador correcto"));
			return "LoginAdmin";
		}
	}
	
	
	@PostMapping("/editarA/{id}")
	public String actualizarUsuario(Model modelo, @ModelAttribute("nuevo") Usuario nuevo,@PathVariable long id ){
		Map<String, Long> vars = new HashMap<String, Long>();
		vars.put("id", id);
		Usuario usuarioValidado = restTemplate.postForObject("http://localhost:8010/editarU/{id}",nuevo, Usuario.class,vars);
		modelo.addAttribute("usuarioValidado",usuarioValidado);
		return "redirect:/cargarAdmin";
		
	}
	@PostMapping("/editarP/{id}")
	public String actualizarProducto(Model modelo, @ModelAttribute("nuevo") Producto nuevo,@PathVariable long id,MultipartHttpServletRequest request ){
		Map<String, Long> vars = new HashMap<String, Long>();
		vars.put("id", id);
		Producto p=restTemplate.getForObject("http://localhost:8020/buscarPorId/{id}",Producto.class,vars);
		nuevo.setUsuario(p.getUsuario());
		nuevo.setId((int)p.getId());
		Iterator<String> itrator = request.getFileNames();
        MultipartFile multiFile = request.getFile(itrator.next());
        	byte[] bytes = null;
            Base64 base64 = new Base64();
             try{
                 bytes = multiFile.getBytes();
                 String imagen = "data:image/jpg;base64,";
         		 imagen +=base64.encodeToString(bytes);
         		 if(!imagen.equals("data:image/jpg;base64,")){
         			nuevo.setImage(imagen);
         		 }else{
         			 nuevo.setImage("");
         		 }            	 
             }catch(Exception e){
                 System.out.println("No se ha podido el byte[]");
             }  

		Producto actualizado = restTemplate.postForObject("http://localhost:8020/editarProducto",nuevo, Producto.class);
		return "redirect:/cargarAdmin";
		
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
		if(adminValidado != null){
			modelo.addAttribute("adminValidado",adminValidado);
			modelo.addAttribute("adminLogueado", true);
			modelo.addAttribute("err", new Men(""));
			return "redirect:/cargarAdmin";
		}else{
			modelo.addAttribute("err", new Men("No se ha introducido un administrador correcto"));
			return "LoginAdmin";
		}
		
		
	}

	@RequestMapping(value="/cargarAdmin",method=RequestMethod.GET)
	public String cargar(Model modelo, @SessionAttribute("adminLogueado") boolean admin){
		if(admin){
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
		}else {
			modelo.addAttribute("err", new Men("No se ha introducido un administrador correcto"));
			return "LoginAdmin";
		}

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
