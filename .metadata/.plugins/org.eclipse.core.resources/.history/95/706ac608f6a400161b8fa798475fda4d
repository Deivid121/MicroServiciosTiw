package es.uc3m.tiw.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

import es.uc3m.tiw.wallapoptiw.daos.*;
import es.uc3m.tiw.wallapop.dominios.*;
/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletConfig config; 
    private UsuarioDAO dao;
	@PersistenceContext(unitName="wallapoptiw")
	private EntityManager em;
	@Resource
	private UserTransaction ut;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		config.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		String usuario= request.getParameter("User");
		String pass= request.getParameter("Pass");
		if(usuario.isEmpty()||pass.isEmpty()){
			config.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
		}
			try {
				Usuario user= dao.buscarUsuario(usuario, pass);
				if(user==null){
					config.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
				}
				else{
				
					if(user.getEmail().isEmpty() && user.getPassword().isEmpty()){
						
						sesion.setAttribute("logeado", false);
						config.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
					}
					else{
						
						sesion.setAttribute("logeado", true);
						sesion.setAttribute("email", user.getEmail());
						sesion.setAttribute("Nombre", user.getNombre());
						sesion.setAttribute("usuario", user);
						config.getServletContext().getRequestDispatcher("/perfilusuario.jsp").forward(request,response);
				}
					
				}
			}
		
			catch (SQLException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException | NotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

		}
	
		
		
		
		
	}

}

