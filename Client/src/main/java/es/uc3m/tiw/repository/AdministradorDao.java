package es.uc3m.tiw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uc3m.tiw.dominio.Administrador;


public interface AdministradorDao extends JpaRepository<Administrador, Long> {

	Administrador findByEmailAndPassword(String email, String password);
	List<Administrador> findAll();

	
}
