package gm.zona_fit.servicio;

import gm.zona_fit.modelo.Usuario;
import gm.zona_fit.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio implements IUsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> listaUsusarios() {
        List<Usuario> usuarios = usuarioRepositorio.findAll();
        return usuarios;
    }

    @Override
    public Usuario buscarUsuario(Integer idUsuario) {
        Usuario usuario = usuarioRepositorio.findById(idUsuario).orElse(null);
        return usuario;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioRepositorio.delete(usuario);
    }
}
