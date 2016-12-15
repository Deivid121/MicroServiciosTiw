package es.uc3m.tiw.controladores;



import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
		System.out.println(p);
		return "crearProductos";
	}
	@PostMapping("/crearProducto")
	public String guardarProducto(Model modelo, @ModelAttribute(value="pvacio")Producto producto,@SessionAttribute(value="usuarioValidado") Usuario usuario, HttpServletResponse response){
		producto.setUsuario(usuario.getId());
		System.out.println(producto);
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
    public String guardarProducto(MultipartHttpServletRequest request,@ModelAttribute(value="pvacio") Producto producto){
        Producto p = new Producto();
        p = producto;
		Iterator<String> itrator = request.getFileNames();
         MultipartFile multiFile = request.getFile(itrator.next());
        byte[] bytes = null;

         try{
             Base64 base64 = new Base64();
             bytes = multiFile.getBytes();
             String imagen = "data:image/jpg;base64,";
            		 imagen +=base64.encodeToString(bytes);
             System.out.println(imagen);
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
}
