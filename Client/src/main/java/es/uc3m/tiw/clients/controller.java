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
    @Autowired
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
    @RequestMapping(value="/eliminarU/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void eliminarUsuario(@PathVariable long id){
        dao.delete(id); 
    }
    @RequestMapping(value="/editarU/{id}", method = RequestMethod.POST)
    public @ResponseBody Usuario editarUsuario(@RequestBody Usuario nuevo, @PathVariable long id){
   // 	Usuario antiguo= new Usuario("m1","freferf","efwwefw","m1@m1.com","m1.png","12345678","A coruna");
    	Usuario antiguo=dao.findById(id);
//        List <Usuario> u = dao.findAll();
 
    	Usuario actualizado=updateUser(antiguo,nuevo); 
    	//System.out.println(actualizado);
    	dao.save(actualizado);
        
        return actualizado;
       
    }
    @RequestMapping(value="/buscarPorId/{id}", method = RequestMethod.GET)
    public @ResponseBody Usuario buscarUsuario(@PathVariable Long id){
        return dao.findById(id);
       
    }
    @RequestMapping(value="/getUsuarios", method = RequestMethod.GET)
    public @ResponseBody List<Usuario> getUsuarios(){
        return dao.findAll();
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
    public  @ResponseBody Administrador loginAdmin(@RequestBody Administrador admin){
    	List <Administrador> Administradores = daoA.findAll();
    	buscarAdministrador(Administradores, admin);
    	return new Administrador (); 
    }

    
    private static Usuario buscarUsuario(List<Usuario> lista, Usuario user){
    	Usuario u = null;
    	for (Usuario usuario : lista) {
			if(usuario.getEmail().equals(user.getEmail())&&usuario.getPassword().equals(user.getPassword())){
				return usuario;
			}
		}
    	return u;
    	
    	
    }
    
    private static Usuario buscarUsuariobyId(List<Usuario> lista, long id){
    	Usuario u = null;
    	for (Usuario usuario : lista) {
			if(usuario.getId() == id){
				return usuario;
			}
		}
    	return u;
    	
    	
    }
    private static Usuario updateUser(Usuario antiguo, Usuario user){
    	
    	if(!user.getNombre().equals("")&&user.getNombre()!=null){
    		antiguo.setNombre(user.getNombre());
    	}
    	if(!user.getApellido1().equals("")&&user.getApellido1()!=null){
    		antiguo.setApellido1(user.getApellido1());
    	}
    	if(!user.getApellido2().equals("")&&user.getApellido2()!=null){
    		antiguo.setApellido2(user.getApellido2());
    	}
    	if(!user.getEmail().equals("")&&user.getEmail()!=null){
    		antiguo.setEmail(user.getEmail());
    	}
    	if(!user.getCiudad().equals("")&&user.getCiudad()!=null){
    		antiguo.setCiudad(user.getCiudad());
    	}
    	if(!user.getAvatar().equals("")&&user.getAvatar()!=null){
    		antiguo.setAvatar(user.getAvatar());
    	}
    	if(!user.getPassword().equals("")&&user.getPassword()!=null){
    		antiguo.setPassword(user.getPassword());
    	}
    	return antiguo;
    }
    
    private static Administrador buscarAdministrador(List<Administrador> lista, Administrador admin){
    	Administrador a = null;
    	for (Administrador administrador : lista) {
			if(administrador.getEmail().equals(admin.getEmail())&& administrador.getPassword().equals(admin.getPassword())){
				return administrador;
			}
		}
    	return a;
    	
    	
    }

    
    
    
    
}