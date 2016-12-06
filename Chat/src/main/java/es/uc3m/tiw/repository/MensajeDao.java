package es.uc3m.tiw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uc3m.tiw.dominio.Mensaje;


public interface MensajeDao extends JpaRepository<Mensaje, Long>{

}
