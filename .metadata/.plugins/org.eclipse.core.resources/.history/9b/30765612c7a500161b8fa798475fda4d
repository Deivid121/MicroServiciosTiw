package es.uc3m.tiw.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.wallapop.dominios.Usuario;
import es.uc3m.tiw.wallapoptiw.daos.UsuarioDAO;
import es.uc3m.tiw.wallapoptiw.daos.UsuarioDAOImpl;

/**
 * Servlet implementation class usuarioServlet
 */
@WebServlet("/usuarioServlet")
public class usuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config; 
	private UsuarioDAO dao;
       
	@PersistenceContext(unitName="wallapoptiw")
    EntityManager em;
    @Resource
    UserTransaction ut;
    public usuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		dao = new UsuarioDAOImpl();
		dao.setConexion(em);
		dao.setTransaction(ut);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario u;
		HttpSession sesion = request.getSession();
		u=(Usuario) sesion.getAttribute("usuario");
		u.setNombre(request.getParameter("nombre"));
		u.setApellido1(request.getParameter("apellido1"));
		u.setApellido2(request.getParameter("apellido2"));
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("password"));
		u.setCiudad(request.getParameter("ciudad"));
		
		
		
		try {
			sesion.setAttribute("usuario", dao.actualizarUsuario(u));
			config.getServletContext().getRequestDispatcher("/perfilusuario.jsp").forward(request, response);
		} catch (SQLException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
