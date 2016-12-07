package es.uc3m.tiw.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.dominio.Usuario;
import es.uc3m.tiw.repository.UsuarioDao;

@RestController
public class controller {
    private Usuario usuario;
    @Autowired
    private UsuarioDao dao;
    
    
    @RequestMapping(value="/login" ,method = RequestMethod.GET)
    public  @ResponseBody Usuario login(@RequestParam(value="nombre", required = true) String nombre,
    @RequestParam(value="password", required = true) String password){
        Usuario u = dao.findByEmailAndPassword(nombre, password);
        return u;
    }
    
    @RequestMapping(value="/registro", method = RequestMethod.POST)
    public @ResponseBody Usuario registro(@RequestParam(value="user", required = true) Usuario u){
        dao.save(u);
        return u;
    }
    @RequestMapping(value="/registro2", method = RequestMethod.POST)
    public @ResponseBody Usuario registro2(@RequestParam(value="nombre", required = true) String n,
            @RequestParam(value="apellido1", required = true) String a1,
            @RequestParam(value="apellido2", required = true) String a2,
            @RequestParam(value="password", required = true) String p,
            @RequestParam(value="ciudad", required = true) String c,
            @RequestParam(value="email", required = true) String e){
        Usuario u =new Usuario(n,a1,a2,e,p,c);
        dao.save(u);
        return u;
    }
    @RequestMapping(value="/registro3", method = RequestMethod.GET)
    public @ResponseBody Usuario registro2(){
        Usuario u =new Usuario("David","del Rey","Garcia","a@b.com","1234","Madrid");
        dao.save(u);
        return u;
    }
}