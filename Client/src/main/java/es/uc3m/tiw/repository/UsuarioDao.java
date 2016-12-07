package es.uc3m.tiw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uc3m.tiw.dominio.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
	List<Usuario> findAll();
    Usuario findByEmailAndPassword(String nombre, String password);
    Usuario findById (Long id);
}
