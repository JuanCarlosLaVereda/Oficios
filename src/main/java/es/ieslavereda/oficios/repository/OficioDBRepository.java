package es.ieslavereda.oficios.repository;

import com.mysql.cj.xdevapi.Type;
import es.ieslavereda.oficios.repository.model.Oficio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OficioDBRepository implements IOficioDBRepository{

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource dataSource;

    @Override
    public String getImage(int id) throws SQLException {
        String query = "{call obtener_image_oficio(?,?)}";
        String resultado = "";

        try (Connection connection = dataSource.getConnection();
        CallableStatement cs = connection.prepareCall(query)){
            cs.setInt(2, id);
            //cs.registerOutParameter(1, Types.);
            cs.executeQuery();
            resultado = cs.getString(1);

        }
        return resultado;
    }

    @Override
    public List<Oficio> getById(int id) throws SQLException {
        List<Oficio> oficios = new ArrayList<>();
        String query = "{call obtener_oficios(?)}";
        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){
            cs.setInt(1, id);
            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()){
                oficios.add(Oficio.builder()
                        .id(resultSet.getInt(1))
                        .descripcion(resultSet.getString(2))
                        .image(resultSet.getString(3))
                        .imageURL(resultSet.getString(4)).build());
            }

        }
        return oficios;
    }
}
