package es.ieslavereda.oficios.controller;

import es.ieslavereda.oficios.repository.model.Usuario;
import es.ieslavereda.oficios.service.UsuarioDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/usuarios/post")
    public ResponseEntity<?> postUser(@RequestBody Usuario usuario){
        try {
            return new ResponseEntity<>(usuarioDBService.addUsuario(usuario), HttpStatus.OK);
        } catch (SQLException e){
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/usuarios/put")
    public ResponseEntity<?> putUser(@RequestBody Usuario usuario){
        try {
            return new ResponseEntity<>(usuarioDBService.updateUser(usuario), HttpStatus.OK);
        } catch (SQLException e){
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/usuarios/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id")int id){
        try {
            return new ResponseEntity<>(usuarioDBService.deleteUser(id), HttpStatus.OK);
        } catch (SQLException e){
            return new ResponseEntity<>(e.getErrorCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
