package es.ieslavereda.oficios.service;

import es.ieslavereda.oficios.repository.UsuarioDBRepository;
import es.ieslavereda.oficios.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioDBService {
    @Autowired
    private UsuarioDBRepository usuarioDBRepository;

    public List<Usuario> getAll() throws SQLException {
        return usuarioDBRepository.getAll();
    }

    public Usuario addUsuario(Usuario usuario) throws SQLException{
        return usuarioDBRepository.addUser(usuario);
    }

    public Usuario updateUser(Usuario usuario) throws SQLException{
        return usuarioDBRepository.updateUser(usuario);
    }

    public int deleteUser(int id) throws SQLException{
        return usuarioDBRepository.deleteUser(id);
    }
}
