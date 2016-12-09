package es.uc3m.tiw.clients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.dominio.Administrador;
import es.uc3m.tiw.dominio.Usuario;
import es.uc3m.tiw.repository.AdministradorDao;
import es.uc3m.tiw.repository.UsuarioDao;

@RestController
public class controller {
    private Usuario usuario;
    @Autowired
    private UsuarioDao dao;
    private AdministradorDao daoA;
    
    
    @RequestMapping(value="/login" ,method = RequestMethod.POST)
    public  @ResponseBody Usuario login(@RequestBody Usuario usuario){
        List <Usuario> Usuarios = dao.findAll();  
        return buscarUsuario(Usuarios,usuario);
    }
    
    @RequestMapping(value="/registro", method = RequestMethod.POST)
    public @ResponseBody Usuario registro(@RequestBody Usuario usuario){
        dao.save(usuario);
        return usuario;
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
    @RequestMapping(value="/eliminarU", method = RequestMethod.DELETE)
    public @ResponseBody Usuario eliminarUsuario(Usuario user){
        dao.delete(user);
        return user;
       
    }
    @RequestMapping(value="/editarU", method = RequestMethod.PUT)
    public @ResponseBody Usuario editarUsuario(Usuario user){
    	
        Usuario u = dao.findById(user.getId());
        u.setNombre(user.getNombre());
        u.setApellido1(user.getApellido1());
        u.setApellido2(user.getApellido2());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        dao.save(user);
        
        return user;
       
    }
    @RequestMapping(value="/loginAdmin" ,method = RequestMethod.GET)
    public  @ResponseBody Administrador loginAdmin(@RequestParam(value="nombre", required = true) String nombre,
    @RequestParam(value="password", required = true) String password){
        Administrador admin = daoA.findByEmailAndPassword(nombre, password);
        return admin;
    }
    
    private static Usuario buscarUsuario(List<Usuario> lista, Usuario user){
    	Usuario u=new Usuario();
    	for (Usuario usuario : lista) {
			if(usuario.getEmail().equals(user.getEmail())&&usuario.getPassword().equals(user.getPassword())){
				return usuario;
			}
		}
    	return u;
    	
    	
    }
    
    
    
    
}