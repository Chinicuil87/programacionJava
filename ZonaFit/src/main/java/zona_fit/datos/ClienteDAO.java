package zona_fit.datos;

import zona_fit.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static zona_fit.conexion.Conexion.getConexion;

public class ClienteDAO implements IClienteDAO{
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        var sql = "SELECT * FROM usuario  ORDER BY id";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                var cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                clientes.add(cliente);
            }
        }catch (Exception e){
            System.out.println("Error al listar cliente: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion" + e.getMessage());
            }

        }
        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        var con = getConexion();
        var sql = "SELECT * FROM usuario WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            rs =  ps.executeQuery();
            if (rs.next()){
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                return true;
            }
        }catch (Exception e){
            System.out.println("Error al recuperar cliente por id: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql= "INSERT INTO usuario(nombre, apellido, membresia) " +
                " VALUES(?, ?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.execute();
            return true;

        }catch (Exception e){
            System.out.println("Error al agregar usuario: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al Cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        var sql = "UPDATE usuario SET nombre=?, apellido=?, membresia=? " +
                "WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3,  cliente.getMembresia());
            ps.setInt(4, cliente.getId());
            ps.execute();
            return true;

        }catch (Exception  e){
            System.out.println("Error al modificar usuario: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarCLiente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM usuario WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {

        var separador = "*".repeat(100);

        IClienteDAO clienteDao =  new ClienteDAO();
        // Listar clientes
        System.out.println(separador);
        System.out.println("*** Listar usuarios ***");
        System.out.println(separador);
        var clientes=  clienteDao.listarClientes();
        clientes.forEach(System.out::println);
        System.out.println(separador);

        // Buscar pir id
        System.out.println(separador);
        System.out.println("*** Buscar usuario id ***");
        System.out.println(separador);
        var cliente1 = new Cliente(3);
        System.out.println("Cliente antes de la busqueda: " + cliente1);
        var encontrado =  clienteDao.buscarClientePorId(cliente1);
        if (encontrado)
            System.out.println("Cliente encontrado: "  +  cliente1);
        else
            System.out.println("Cliente no encontrado: " + cliente1.getId());

        // Agregar cliente
        var nuevoCliente = new Cliente("Mayra","Maruri", 6598);
        var agregado = clienteDao.agregarCliente(nuevoCliente);
        if (agregado)
            System.out.println("Ususario agregado: " + nuevoCliente);
        else
            System.out.println("Usuario no agregado" + nuevoCliente);

        System.out.println(separador);

        System.out.println(separador);
        System.out.println("*** Lista usuarios ***");
        System.out.println(separador);
        clientes=  clienteDao.listarClientes();
        clientes.forEach(System.out::println);
        System.out.println(separador);

        // Modificar cliente
        System.out.println(separador);
        System.out.println("*** Modificar cliente");
        System.out.println(separador);;
        var modificarCliente = new Cliente(1, "Alfredo", "Lopez", 7845);
        var modificado = clienteDao.modificarCliente(modificarCliente);
        if (modificado)
            System.out.println("Usuario modificado: " + modificarCliente);
        else
            System.out.println("No se modifico usuario: " + modificarCliente);

        System.out.println(separador);

        System.out.println(separador);
        System.out.println("*** Lista usuarios ***");
        System.out.println(separador);
        clientes=  clienteDao.listarClientes();
        clientes.forEach(System.out::println);
        System.out.println(separador);

        System.out.println(separador);
        System.out.println("*** Eliminar usuario ***");
        System.out.println(separador);
        var clienteEliminar = new Cliente(2);
        var eliminado = clienteDao.eliminarCLiente(clienteEliminar);
        if (eliminado)
            System.out.println("Usuario eliminado:" + clienteEliminar);
        else
            System.out.println("No se elimino usuario:" + clienteEliminar);

        System.out.println(separador);
        System.out.println("*** Lista usuarios ***");
        System.out.println(separador);
        clientes=  clienteDao.listarClientes();
        clientes.forEach(System.out::println);
        System.out.println(separador);



    }
}
