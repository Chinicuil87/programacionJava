package gm.zona_fit.servicio;

import gm.zona_fit.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    public List<Usuario> listaUsusarios();
    public Usuario buscarUsuario(Integer idUsuario);
    public void guardarUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
}
