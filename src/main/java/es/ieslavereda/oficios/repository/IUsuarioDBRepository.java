package es.ieslavereda.oficios.repository;

import es.ieslavereda.oficios.repository.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDBRepository {
    int adduser(Usuario usuario) throws SQLException;
    List<Usuario> getAll() throws SQLException;
    int updateUser (Usuario usuario) throws SQLException;
    int deleteUser (Usuario usuario) throws SQLException;
}
