package es.uc3m.tiw.controladores;



import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.apache.commons.codec.binary.Base64;

import es.uc3m.tiw.dominio.Men;
import es.uc3m.tiw.dominio.Producto;
import es.uc3m.tiw.dominio.Usuario;


@Controller
public class ProductosController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/crearProducto", method=RequestMethod.GET)
	public String crearProducto(Model modelo){
	    Producto p=new Producto();
		modelo.addAttribute("pvacio",p);
		modelo.addAttribute("busqueda",new Men());
		System.out.println(p);
		return "crearProductos";
	}
	@PostMapping("/crearProducto")
	public String guardarProducto(Model modelo, @ModelAttribute(value="pvacio")Producto producto,@SessionAttribute(value="usuarioValidado") Usuario usuario, HttpServletResponse response){
		System.out.println(usuario);
		producto.setUsuario(usuario.getId());
		Producto productoGuardado = restTemplate.postForObject("http://localhost:8020/subirProducto", producto, Producto.class);
		modelo.addAttribute(productoGuardado);
		try {
			response.sendRedirect("/index");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/index";
	}
	
	@PostMapping("/crearProducto2")
    public String guardarProducto(Model modelo,MultipartHttpServletRequest request,@ModelAttribute(value="pvacio") Producto producto,@SessionAttribute(value="usuarioValidado") Usuario usuario){
        Producto p = new Producto();
        p = producto;
        p.setUsuario(usuario.getId());
		Iterator<String> itrator = request.getFileNames();
         MultipartFile multiFile = request.getFile(itrator.next());
        byte[] bytes = null;

         try{
             Base64 base64 = new Base64();
             bytes = multiFile.getBytes();
             String imagen = "data:image/jpg;base64,";
            		 imagen +=base64.encodeToString(bytes);
             p.setImage(imagen);
         }catch(Exception e){
             System.out.println("No se ha podido el byte[]");
         }
         System.out.println(p);
    if(bytes != null){
   Producto productoGuardado = restTemplate.postForObject("http://localhost:8020/subirProducto", p, Producto.class);
    }
   return "/index";
	
}
	@RequestMapping(value="/verProducto/{id}", method=RequestMethod.GET)
	public String cargarProducto(Model modelo,@ModelAttribute String id){
		Map<String, Long> vars = new HashMap<String, Long>();
		vars.put("id", Long.parseLong(id));
		Producto productoGuardado = restTemplate.getForObject("http://localhost:8020/verProducto/{id}", Producto.class, vars);
		modelo.addAttribute("producto",productoGuardado);
		return "verProducto";
	}
	@RequestMapping(value="/buscar", method=RequestMethod.POST)
	public String buscarProducto(Model modelo,@ModelAttribute Men busqueda){
		Map<String, String> vars = new HashMap<String, String>();
		String men = busqueda.getMensaje();
		vars.put("busqueda", men);
		ResponseEntity productoGuardado = restTemplate.getForEntity("http://localhost:8020/buscarProducto/{busqueda}", Producto[].class, vars);
		Producto[] productos = (Producto []) productoGuardado.getBody();
		List<Producto> lista = (List<Producto>) Arrays.asList(productos);
		modelo.addAttribute("lista",lista);
		modelo.addAttribute("busqueda",new Men());
		modelo.addAttribute("boolbus", true);
		modelo.addAttribute("usuario",new Usuario());
		modelo.addAttribute("logueado",false);
		modelo.addAttribute("adminLogueado", false);
		return "index";
	}
}
