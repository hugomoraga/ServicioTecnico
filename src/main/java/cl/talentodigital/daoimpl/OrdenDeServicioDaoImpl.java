package cl.talentodigital.daoimpl;

import java.util.ArrayList;
import java.util.List;

import cl.talentodigital.dao.IOrdenDeServicioDao;
import cl.talentodigital.database.ConexionDatabase;
import cl.talentodigital.database.DataList;
import cl.talentodigital.modelo.Cliente;
import cl.talentodigital.modelo.OrdenDeServicio;

public class OrdenDeServicioDaoImpl implements IOrdenDeServicioDao {
	//Lista de Guardado Sin Base De Datos 
	//List<OrdenDeServicio> listaOrdenesCliente = DataList.listaOrdenesCliente;
	//List<OrdenDeServicio> listaOrdenes = DataList.listaOrdenes;
	
	List<OrdenDeServicio> listaOrdenesCliente = new ArrayList<OrdenDeServicio>();
	List<OrdenDeServicio> listaOrdenes = new ArrayList<OrdenDeServicio>();

	@Override
	public List<OrdenDeServicio> obtenerOrdenes() {
		listaOrdenes = ConexionDatabase.listarOrdenes();
		return listaOrdenes;
	}

	@Override
	public List<OrdenDeServicio> obtenerOrdenesdeCliente(Cliente cliente) {
		listaOrdenes = ConexionDatabase.listarOrdenes();

		int idCliente = cliente.getId();
		for (int i = 0; i<listaOrdenes.size(); i++) {
			
			if (listaOrdenes.get(i).getCliente().getId() == idCliente) {
				listaOrdenesCliente.add(listaOrdenes.get(i));
			}
		}
		return listaOrdenesCliente;
	}

	@Override
	public boolean agregarOrden(OrdenDeServicio orden) {
		//listaOrdenes.add(orden);
		try {
			ConexionDatabase.guardarOrden(orden);
			return true;
		} catch (Exception e) {
			System.out.println(e + "No se guardo Orden");
			return false;
		}
	}

	@Override
	public boolean obtenerOrden(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarOrden(OrdenDeServicio orden) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarOrden(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
