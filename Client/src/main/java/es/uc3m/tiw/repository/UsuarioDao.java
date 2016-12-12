package es.uc3m.tiw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import es.uc3m.tiw.dominio.Administrador;
import es.uc3m.tiw.dominio.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
	@Modifying
	@Transactional
	@Query(value="delete from Usuario u where u.id = ?1")
	void deleteById(Long id);
	
	List<Usuario> findAll();
	
    Usuario findByEmailAndPassword(String email, String password);

    Usuario findById (Long id);
	
}
