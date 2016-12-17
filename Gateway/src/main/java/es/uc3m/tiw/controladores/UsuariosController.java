package es.uc3m.tiw.controladores;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;


import es.uc3m.tiw.dominio.Producto;
import es.uc3m.tiw.dominio.Usuario;

@SessionAttributes(value={"logueado","usuarioValidado"})
@Controller
public class UsuariosController {
    @Autowired
    RestTemplate restTemplate;
    
    
    @RequestMapping(value="/registrar")
    public String registrarUsuarios(Model modelo){
        Usuario u=new Usuario();
        modelo.addAttribute(u);
        return "registro";
    }
    
    @PostMapping("/registrar")
    public String guardarUnUsuario(Model modelo, @Valid @ModelAttribute Usuario usuario, BindingResult bR){
        if(bR.hasErrors()){
            return"registro";
        }
        Usuario usuarioGuardado = restTemplate.postForObject("http://localhost:8010/registro", usuario, Usuario.class);
        modelo.addAttribute(usuarioGuardado);
        return "index";
        
    }
    
    @RequestMapping(value="/editarUsuario")
    public String editarUsuarios(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("nuevo",usuario);
        return "editarUsuario";
    }
    @PostMapping("/editar")
    public String actualizarUsuario(Model modelo, @SessionAttribute(value="usuarioValidado") Usuario validado, @ModelAttribute Usuario nuevo){
        long id= validado.getId();
        System.out.println(nuevo);
        Map<String, Long> vars = new HashMap<String, Long>();
        vars.put("id", id);
        Usuario usuarioValidado = restTemplate.postForObject("http://localhost:8010/editarU/{id}", nuevo, Usuario.class,vars);
        modelo.addAttribute("usuarioValidado",usuarioValidado);
        return "perfilUsuario";
    }
    @RequestMapping(value="/eliminar", method=RequestMethod.GET)
    public String borrarUsuario(Model modelo, HttpServletRequest request){
        HttpSession sesion =request.getSession();
        Usuario usuario = (Usuario)sesion.getAttribute("usuarioValidado");
        
        return usuario.toString();
    }
    
    
    @PostMapping("/loguear")
    public String validarUsuario(Model modelo, @ModelAttribute Usuario usuario){
        System.out.println(usuario);
        Usuario usuarioValidado = restTemplate.postForObject("http://localhost:8010/login", usuario, Usuario.class);
        modelo.addAttribute("usuarioValidado",usuarioValidado);
        modelo.addAttribute("logueado", true);
        return "perfilUsuario";
        
    }
    @RequestMapping(value="/perfilUsuario",method=RequestMethod.GET)
    public String verUsuario(Model modelo, @ModelAttribute Usuario usuario){
        System.out.println(usuario);
        return "perfilUsuario";
        
    }
    @RequestMapping(value="/verMisProductos",method=RequestMethod.GET)
    public String verProductos(Model modelo, @ModelAttribute Usuario usuario,@SessionAttribute("usuarioValidado")Usuario user){
        Map <String, Long>vars= new HashMap<String, Long>();
        vars.put("id", user.getId());
        ResponseEntity responseEntity=restTemplate.getForEntity("http://localhost:8020/verMisProducto/{id}", Producto[].class, vars);
        Producto[]prod=(Producto[])responseEntity.getBody();
        List<Producto> lista= Arrays.asList(prod);
        modelo.addAttribute("misProductos",lista);
        return "misProductos";
        
    }
    
}
