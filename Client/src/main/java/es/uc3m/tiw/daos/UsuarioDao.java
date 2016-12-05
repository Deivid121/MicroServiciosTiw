package es.uc3m.tiw.daos;

import java.util.List;

import es.uc3m.tiw.dominio.Usuario;

public interface UsuarioDao extends org.springframework.data.repository.CrudRepository {
	List<Usuario> findAll();
    Usuario findByNombre(String nombre);
}
