package pe.edu.savbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.Test;
import pe.edu.savbackend.domain.Usuario;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("/login")
public class Login {


    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void logear(@RequestBody Usuario usuario) {
//        return token;
    }
    
   
}