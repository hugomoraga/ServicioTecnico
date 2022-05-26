package cl.talentodigital.dao;
import cl.talentodigital.modelo.Cliente;
import java.util.List;

public interface IClienteDao {
	
    
    List<Cliente> obtenerClientes();
    
    Cliente obtenerCliente(int clienteId);
    
    boolean agregarCliente(Cliente cliente);
    
    boolean actualizar(Cliente cliente);
    
    boolean eliminar(Cliente cliente);


}
