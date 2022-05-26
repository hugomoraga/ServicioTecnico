package cl.talentodigital.dao;

import java.util.List;

public interface IClienteDao<Cliente> {
	
    
    List<Cliente> obtenerClientes();
    
    boolean guardar(Cliente cliente);
    
    boolean actualizar(Cliente cliente, String[] params);
    
    boolean eliminar(Cliente cliente);

}
