package zona_fit.datos;

import zona_fit.dominio.Cliente;

import java.util.List;

public interface IClienteDAO {
    List<Cliente> listarClientes();
    boolean buscarClientePorId(Cliente cliente);
    boolean agregarCliente(Cliente cliente);
    boolean modificarCliente(Cliente cliente);
    boolean eliminarCLiente(Cliente cliente);

}
