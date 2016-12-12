package es.uc3m.tiw.clients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping(value="/registro3", method = RequestMethod.GET)
    public @ResponseBody Usuario registro2(){
        Usuario u =new Usuario("David","del Rey","Garcia","a@b.com","m2.png","1234","Madrid");
        dao.save(u);
        return u;
    }
    @RequestMapping(value="/eliminarU", method = RequestMethod.DELETE)
    public @ResponseBody Usuario eliminarUsuario(@RequestBody Usuario user){
        dao.delete(user.getId());
        return user;
       
    }
    @RequestMapping(value="/editarU/{id}", method = RequestMethod.POST)
    public @ResponseBody Usuario editarUsuario(@RequestBody Usuario nuevo, @PathVariable String id){
    	nuevo.setId(Long.parseLong(id));
//        List <Usuario> u = dao.findAll();
//        Usuario antiguo=buscarUsuariobyId(u, id);   updateUser(antiguo,user)
        dao.save(nuevo);
        
        return nuevo;
       
    }
    @RequestMapping (value="/verPerfil", method = RequestMethod.GET)
public @ResponseBody Usuario verPerfil(Usuario user){
    	
       // Usuario u = dao.findById(user.getId());
        user.getNombre();
        user.getApellido1();
        user.getApellido2();
        user.getEmail();
        user.getPassword();
        
        return user;
       
    }
    @RequestMapping(value="/loginAdmin" ,method = RequestMethod.POST)
    public  @ResponseBody Administrador loginAdmin(@RequestBody Administrador administrador){
    	List <Administrador> Administradores = daoA.findAll();
    	return buscarAdministrador(Administradores, administrador);
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
    private static Usuario buscarUsuariobyId(List<Usuario> lista, long id){
    	Usuario u=new Usuario();
    	for (Usuario usuario : lista) {
			if(usuario.getId() == id){
				return usuario;
			}
		}
    	return u;
    	
    	
    }
    private static Usuario updateUser(Usuario antiguo, Usuario user){
    	
    	if(user.getNombre().isEmpty()){
    		user.setNombre(antiguo.getNombre());
    	}
    	if(user.getApellido1().isEmpty()){
    		user.setApellido1(antiguo.getApellido1());
    	}
    	if(user.getEmail().isEmpty()){
    		user.setEmail(antiguo.getEmail());
    	}
    	if(user.getAvatar().isEmpty()){
    		user.setAvatar(antiguo.getAvatar());
    	}
    	if(user.getCiudad().isEmpty()){
    		user.setCiudad(antiguo.getCiudad());
    	}
    	return user;
    }
    
    private static Administrador buscarAdministrador(List<Administrador> lista, Administrador admin){
    	Administrador a=new Administrador();
    	for (Administrador administrador : lista) {
			if(administrador.getEmail().equals(administrador.getEmail())&&administrador.getPassword().equals(admin.getPassword())){
				return administrador;
			}
		}
    	return a;
    	
    	
    }
    
    
    
    
}