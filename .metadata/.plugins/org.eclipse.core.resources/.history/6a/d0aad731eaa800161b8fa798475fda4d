package es.uc3m.tiw.wallapoptiw.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.wallapop.dominios.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
	private EntityManager em;
	private UserTransaction ut;
	@Override
	public void crearUsuario(Usuario nuevoUsuario) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		ut.begin();
		em.persist(nuevoUsuario);
		ut.commit();
		//em.flush();
	}
	
	@Override
	public Usuario buscarUsuario(String user, String pass) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		
		Query consulta= em.createQuery("select u from Usuario u where u.email =:email and u.password =:pass",Usuario.class);	
		consulta.setParameter("email", user);
		consulta.setParameter("pass", pass);
		if(consulta.getResultList().isEmpty()){
			return null;
		}
		else{
			Usuario usuario=(Usuario)consulta.getResultList().get(0);
			return usuario;
		}
		


		//em.flush();
	}
	@Override
    public Usuario recuperarUnUsuarioPorClave(int pk) throws SQLException{
        
        return em.find(Usuario.class, pk);
        
    }
	@Override
	public Usuario actualizarUsuario (Usuario user )throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		
		ut.begin();

		em.merge(user);
		
		ut.commit();
		
		
		return recuperarUnUsuarioPorClave(user.getId());
	
	
	}
	
	
	
	
	@Override
	public void setConexion(EntityManager em) {
		this.em = em;
		
	}
	@Override
	public void setTransaction(UserTransaction ut) {
		// TODO Auto-generated method stub
		this.ut = ut;
	}

}
