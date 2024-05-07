package es.ieslavereda.oficios.repository;

import es.ieslavereda.oficios.repository.model.Oficio;

import java.sql.SQLException;
import java.util.List;

public interface IOficioDBRepository {
    String getImage(int id) throws SQLException;
    List<Oficio> getAll() throws SQLException;

}
