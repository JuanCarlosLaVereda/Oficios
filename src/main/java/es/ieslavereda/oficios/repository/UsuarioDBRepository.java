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
    public Usuario addUser(Usuario usuario) throws SQLException {
        String query = "{call crear_usuario(?,?,?,?,?)}";
        int resultado = 0;
        try (Connection connection = dataSource.getConnection();
        CallableStatement cs = connection.prepareCall(query)){

            cs.setInt(2,usuario.getId());
            cs.setString(3,usuario.getNombre());
            cs.setString(4,usuario.getApellidos());
            cs.setInt(5,usuario.getIdOficio());
            cs.registerOutParameter(1, Types.INTEGER);
            cs.executeUpdate();
            resultado = cs.getInt(1);
        }
        usuario.setId(resultado);
        return  usuario;
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
    public Usuario updateUser(Usuario usuario) throws SQLException {
        String query = "{? = call actualizar_usuario(?,?,?,?)}";

        try (Connection connection = dataSource.getConnection();
        CallableStatement cs = connection.prepareCall(query)){
            cs.setInt(2,usuario.getId());
            cs.setString(3,usuario.getNombre());
            cs.setString(4,usuario.getApellidos());
            cs.setInt(5,usuario.getIdOficio());

            cs.executeUpdate();

        }

        return usuario;
    }

    @Override
    public int deleteUser(int id) throws SQLException {
        String query = "{? = call eliminar_usuario(?)}";
        int resultado = 0;

        try (Connection connection = dataSource.getConnection();
        CallableStatement cs = connection.prepareCall(query)){
            cs.setInt(2, id);
            resultado = cs.executeUpdate();

        }

        return resultado;
    }
}
