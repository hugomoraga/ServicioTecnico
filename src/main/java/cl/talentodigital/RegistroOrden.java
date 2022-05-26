package cl.talentodigital;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.talentodigital.dao.IClienteDao;
import cl.talentodigital.dao.IOrdenDeServicioDao;
import cl.talentodigital.daoimpl.ClienteDaoImpl;
import cl.talentodigital.daoimpl.OrdenDeServicioDaoImpl;
import cl.talentodigital.modelo.*;
/**
 * Servlet implementation class RegistroOrden
 */
@WebServlet("/registroservicio")
public class RegistroOrden extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroOrden() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 IClienteDao clienteDao = new ClienteDaoImpl();
		 IOrdenDeServicioDao ordenDao = new OrdenDeServicioDaoImpl();
		 int id=1;
		 int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		 Cliente cliente = clienteDao.obtenerCliente(idCliente);
		
		 int tipoeleint = Integer.parseInt(request.getParameter("tipoElectrodomestico"));
		 int estadoServicioInt = Integer.parseInt(request.getParameter("estadoServicio"));

		 TipoElectrodomestico tipoElectrodomestico = TipoElectrodomestico.fromId(tipoeleint);
		 EstadoServicio estadoServicio = EstadoServicio.fromId(estadoServicioInt);
		 String fechaSolicitudString = request.getParameter("fechaSolicitud");
		 String fechaActualizacionString = request.getParameter("fechaActualizacion");
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		 LocalDate fechaSolicitud = LocalDate.parse(fechaSolicitudString, formatter);
		 LocalDate fechaActualizacion = LocalDate.parse(fechaActualizacionString, formatter);
		 
		 LocalDate hoy = LocalDate.now();
		 OrdenDeServicio nuevaOrden = new OrdenDeServicio(id, tipoElectrodomestico, estadoServicio, fechaSolicitud, fechaActualizacion, cliente);
		 ordenDao.agregarOrden(nuevaOrden);
	 	   response.sendRedirect("index.jsp");

		 
	}

}