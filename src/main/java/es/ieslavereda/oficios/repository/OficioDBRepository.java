package es.ieslavereda.oficios.repository;

import es.ieslavereda.oficios.repository.model.Oficio;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class OficioDBRepository implements IOficioDBRepository{
    @Override
    public String getImage(int id) throws SQLException {

    }

    @Override
    public List<Oficio> getAll() throws SQLException {
        return null;
    }
}
