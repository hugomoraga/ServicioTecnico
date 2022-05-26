package cl.talentodigital.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cl.talentodigital.dao.IClienteDao;
import cl.talentodigital.daoimpl.ClienteDaoImpl;
import cl.talentodigital.modelo.Cliente;
import cl.talentodigital.modelo.EstadoServicio;
import cl.talentodigital.modelo.OrdenDeServicio;
import cl.talentodigital.modelo.TipoElectrodomestico;


public class ConexionDatabase {
    public static Connection ConexionDatabase(){
    	Connection conn = null;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	    conn = DriverManager.getConnection("jdbc:mysql://localhost/serviciotecnico?" +
    	                                   "user=root&password=password");

    	} catch (SQLException ex) {
    		System.out.println("SQLException: " + ex.getMessage());
    	    System.out.println("SQLState: " + ex.getSQLState());
    	    System.out.println("VendorError: " + ex.getErrorCode());
    	} catch (ClassNotFoundException ex) {
    	    System.out.println("Class not Found " + ex);
    	}
	    return conn;	
    }
    
    public static void guardarCliente(Cliente cliente) {
    	String nombre = cliente.getNombre();
    	String rut = cliente.getRut();
    	int telefono = cliente.getTelefono();
    	String direccion = cliente.getDireccion();
    	
    	String sqlQuery = "insert into clientes (nombre, rut, telefono, direccion )values('" 
				    	+ nombre + "','"
				    	+ rut + "','"
				    	+ telefono + "','"
				    	+ direccion + "')";
    	try { 
    	Connection con = ConexionDatabase();
    	PreparedStatement ps =con.prepareStatement(sqlQuery);
    	ps.executeUpdate();
    	con.close();
    	}catch (Exception e) {
    		System.out.println("Registro no guardado " + e);
    	}
    }
    
    public static List<Cliente> listar(){
    	List<Cliente> listaClientes = new ArrayList<>();
     	String sqlQuery = "select * from clientes";
		try {
	    	Connection con = ConexionDatabase();
	    	PreparedStatement ps =con.prepareStatement(sqlQuery);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setNombre(rs.getString("nombre"));
				c.setRut(rs.getString("rut"));
				c.setTelefono(rs.getInt("telefono"));
				c.setDireccion(rs.getString("direccion"));
				listaClientes.add(c);
			}
			
			
		} catch (Exception e) {
		}
		return listaClientes;
    } 
    public static Cliente obtieneCliente(int id) {
    	Cliente cliente = new Cliente();
    	String sqlQuery = "SELECT id, nombre, rut, telefono, direccion"
	    		+ "FROM clientes where id=" + id + "";		
	    try {
	    	Connection con = ConexionDatabase();
			PreparedStatement ps=con.prepareStatement(sqlQuery);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				cliente.setId(rs.getInt("id"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setRut(rs.getString("rut"));
				cliente.setTelefono(rs.getInt("telefono"));
				cliente.setDireccion(rs.getString("direccion"));
			}
		
			
		} catch (Exception e) {
			System.out.println("No se encontro Estudiante");
		}
    	return cliente;
    }
    
    public static void guardarOrden(OrdenDeServicio orden) {
    	
    	int tipoElectrodomestico = orden.tipoElectrodomestico.getId();
    	int estadoServicio = orden.estadoServicio.getId();
    	Date fechaSolicitud = Date.valueOf(orden.getFechaSolicitud());
    	Date fechaActualizacion = Date.valueOf(orden.getFechaActualizacion());
    	int clienteId = orden.cliente.getId();
    	
    	
    	String sqlQuery = "insert into ordenes(tipoElectrodomestico, estadoServicio, fechaSolicitud, fechaActualizacion, clienteId)values('" 
				    	+ tipoElectrodomestico + "','"
				    	+ estadoServicio + "','"
				    	+ fechaSolicitud + "','"
				    	+ fechaActualizacion + "','"
    					+ clienteId + "')";

    	try { 
    	Connection con = ConexionDatabase();
    	PreparedStatement ps =con.prepareStatement(sqlQuery);
    	ps.executeUpdate();
    	con.close();
    	}catch (Exception e) {
    		System.out.println("Registro no guardado " + e);
    	}
    }
    
    public static List<OrdenDeServicio> obtenerOrdenesPorCliente(int id) {
    	List <OrdenDeServicio> listaOrdenPorCliente = new ArrayList<>();
    	
    	String sqlQuery = "SELECT * "
	    		+ "FROM ordenes where idCliente=" + id + "";		
    	try {
	    	Connection con = ConexionDatabase();
	    	PreparedStatement ps =con.prepareStatement(sqlQuery);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				OrdenDeServicio o = new OrdenDeServicio();
				Cliente cliente = new Cliente();
				IClienteDao clienteDao = new ClienteDaoImpl();
				o.setId(rs.getInt("id"));
				o.setTipoElectrodomestico(TipoElectrodomestico.fromId(rs.getInt("tipoElectrodomestico")));
				o.setEstadoServicio(EstadoServicio.fromId(rs.getInt("estadoServicio")));
				o.setFechaSolicitud(rs.getDate("fechaSolicitud").toLocalDate());
				o.setFechaActualizacion(rs.getDate("fechaActualizacion").toLocalDate());
				o.setCliente(clienteDao.obtenerCliente(rs.getInt("clienteId")));
				
				listaOrdenPorCliente.add(o);
			}

	
			
		} catch (Exception e) {
		}
    	return listaOrdenPorCliente;
    }

	public static List<OrdenDeServicio> listarOrdenes() {
		List <OrdenDeServicio> listaOrdenes = new ArrayList<OrdenDeServicio>();
	   	String sqlQuery = "select * from ordenes";
			try {
		    	Connection con = ConexionDatabase();
		    	PreparedStatement ps =con.prepareStatement(sqlQuery);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					OrdenDeServicio o = new OrdenDeServicio();
					Cliente cliente = new Cliente();
					IClienteDao clienteDao = new ClienteDaoImpl();
					o.setId(rs.getInt("id"));
					o.setTipoElectrodomestico(TipoElectrodomestico.fromId(rs.getInt("tipoElectrodomestico")));
					o.setEstadoServicio(EstadoServicio.fromId(rs.getInt("estadoServicio")));
					o.setFechaSolicitud(rs.getDate("fechaSolicitud").toLocalDate());
					o.setFechaActualizacion(rs.getDate("fechaActualizacion").toLocalDate());
					o.setCliente(clienteDao.obtenerCliente(rs.getInt("clienteId")));
					listaOrdenes.add(o);
				}
				System.out.println("Obteniendo Lista desde DB");
				
			} catch (Exception e) {
			}
			return listaOrdenes;
	}
    
    
   
}
