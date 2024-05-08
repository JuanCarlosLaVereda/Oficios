package es.ieslavereda.oficios.service;


import es.ieslavereda.oficios.repository.OficioDBRepository;
import es.ieslavereda.oficios.repository.model.Oficio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OficioDBService {

    @Autowired
    private OficioDBRepository oficioDBRepository;

    public List<Oficio> getById(int id) throws SQLException {
        return oficioDBRepository.getById(id);
    }

    public String getImage(int id) throws SQLException{
        return oficioDBRepository.getImage(id);
    }

}
