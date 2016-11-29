package es.uc3m.tiw.wallapoptiw.daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.wallapop.dominios.Usuario;


public interface UsuarioDAO {
	
	public abstract void crearUsuario(Usuario nuevoUsuario) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;

	public abstract void setTransaction(UserTransaction ut);

	public abstract void setConexion(EntityManager em);

	public abstract Usuario buscarUsuario(String user, String pass)
			throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException;

public abstract	Usuario recuperarUnUsuarioPorClave(int pk) throws SQLException;

public abstract Usuario actualizarUsuario(Usuario user) throws SQLException, NotSupportedException, SystemException, SecurityException,
		IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;

}