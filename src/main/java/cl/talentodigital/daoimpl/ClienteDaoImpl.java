package cl.talentodigital.daoimpl;

import java.util.ArrayList;
import java.util.List;

import cl.talentodigital.dao.IClienteDao;
import cl.talentodigital.database.ConexionDatabase;
import cl.talentodigital.database.DataList;
import cl.talentodigital.modelo.Cliente;

public class ClienteDaoImpl implements IClienteDao {
	// Sin Base De Datos:
	// List<Cliente> listaClientes  = DataList.listaClientes;
	
	List<Cliente> listaClientes  = new ArrayList<Cliente>();

	@Override
	public Cliente obtenerCliente(int clienteId) {
		listaClientes = ConexionDatabase.listar();
		Cliente cliente = new Cliente();
		
		for (int i = 0; i<listaClientes.size(); i++) {
			if (listaClientes.get(i).getId() == clienteId) {
				cliente.setId(listaClientes.get(i).getId());
				cliente.setNombre(listaClientes.get(i).getNombre());
				cliente.setRut(listaClientes.get(i).getRut());
				cliente.setTelefono(listaClientes.get(i).getTelefono());
				cliente.setDireccion(listaClientes.get(i).getDireccion());
			}
		}
		return cliente;
		
	}

	@Override
	public boolean actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cliente> obtenerClientes() {
		listaClientes = ConexionDatabase.listar();
		return listaClientes;
	}

	@Override
	public boolean agregarCliente(Cliente cliente) {
		//listaClientes.add(cliente);
		try {
			ConexionDatabase.guardarCliente(cliente);
			return true;
		} catch (Exception e) {
			System.out.println(e + "No se guardo Cliente");
			return false;
		}
	}



	@Override
	public boolean eliminar(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}


}
