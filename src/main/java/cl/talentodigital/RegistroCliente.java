package cl.talentodigital;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.talentodigital.dao.IClienteDao;
import cl.talentodigital.daoimpl.ClienteDaoImpl;
import cl.talentodigital.modelo.Cliente;

/**
 * Servlet implementation class FormularioDeRegistro
 */
@WebServlet("/registrocliente")
public class RegistroCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistroCliente() {
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  	 HttpSession session = request.getSession();
			 int id=1;
			 String nombre = request.getParameter("nombre");
		     String rut = request.getParameter("rut");
	    	 int telefono = Integer.parseInt(request.getParameter("telefono"));
	    	 String direccion = request.getParameter("direccion");
	    	 
	    	 Cliente clienteNuevo = new Cliente(id,nombre,rut,telefono,direccion);
	 	     IClienteDao clienteDao = new ClienteDaoImpl();
	 	     clienteDao.agregarCliente(clienteNuevo);
		 	    response.sendRedirect("index.jsp");

		
	}

}
