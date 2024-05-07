package es.ieslavereda.oficios.repository;

import es.ieslavereda.oficios.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioDBRepository implements IUsuarioDBRepository{

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource dataSource;

    @Override
    public int adduser(Usuario usuario) throws SQLException {
        return 0;
    }

    @Override
    public List<Usuario> getAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "{call obtener_usuarios}";

        try (Connection connection = dataSource.getConnection();
        CallableStatement cs = connection.prepareCall(query)){
            ResultSet rs = cs.executeQuery();

            while (rs.next()){
                usuarios.add(Usuario.builder()
                        .id(rs.getInt(1))
                        .nombre(rs.getString(2))
                        .apellidos(rs.getString(3))
                        .idOficio(rs.getInt(4)).build());
            }
        }
        return usuarios;
    }

    @Override
    public int updateUser(Usuario usuario) throws SQLException {
        return 0;
    }

    @Override
    public int deleteUser(Usuario usuario) throws SQLException {
        return 0;
    }
}
