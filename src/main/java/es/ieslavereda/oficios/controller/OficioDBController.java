package es.ieslavereda.oficios.controller;


import es.ieslavereda.oficios.service.OficioDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/oficios")
public class OficioDBController {

    @Autowired
    private OficioDBService oficioDBService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAll(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(oficioDBService.getById(id), HttpStatus.OK);
        } catch (SQLException e){
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<?> getImage(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(oficioDBService.getImage(id), HttpStatus.OK);
        } catch (SQLException e){
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
