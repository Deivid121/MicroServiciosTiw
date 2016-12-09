package es.uc3m.tiw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import es.uc3m.tiw.dominio.Administrador;
import es.uc3m.tiw.dominio.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {
	List<Usuario> findAll();
	
    Usuario findByEmailAndPassword(String email, String password);

    Usuario findById (Long id);
	
}
