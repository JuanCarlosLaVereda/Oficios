package es.ieslavereda.oficios.repository;

import es.ieslavereda.oficios.repository.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDBRepository {
    Usuario addUser(Usuario usuario) throws SQLException;
    List<Usuario> getAll() throws SQLException;
    Usuario updateUser (Usuario usuario) throws SQLException;
    int deleteUser(int id) throws SQLException;
}
