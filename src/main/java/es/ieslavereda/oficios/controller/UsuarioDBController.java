package es.ieslavereda.oficios.controller;

import es.ieslavereda.oficios.service.UsuarioDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/oficios")
public class UsuarioDBController {

    @Autowired
    UsuarioDBService usuarioDBService;

    @GetMapping("/usuarios/")
    public ResponseEntity<?> getAll(){
        try {
            return new ResponseEntity<>(usuarioDBService.getAll(), HttpStatus.OK);
        } catch (SQLException e){
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
