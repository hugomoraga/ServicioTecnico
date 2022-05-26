package cl.talentodigital.dao;

import java.util.List;

import cl.talentodigital.modelo.Cliente;
import cl.talentodigital.modelo.OrdenDeServicio;

public interface IOrdenDeServicioDao {
	List<OrdenDeServicio> obtenerOrdenes();
	
	List<OrdenDeServicio> obtenerOrdenesdeCliente(Cliente cliente);
	
	boolean agregarOrden(OrdenDeServicio orden);
	
	boolean obtenerOrden (int id);
	
	boolean actualizarOrden (OrdenDeServicio orden);
	
	boolean eliminarOrden(int id);
	
	
	
}
