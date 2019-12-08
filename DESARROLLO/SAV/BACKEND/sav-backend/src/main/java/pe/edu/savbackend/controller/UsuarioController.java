package pe.edu.savbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.savbackend.domain.usuario.UsuarioDto;
import pe.edu.savbackend.entity.Usuario;
import pe.edu.savbackend.service.usuario.IUsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping(value = "/")
	@Secured("ROLE_ADMIN")
    public List<Usuario> buscarTodos() {
        return usuarioService.buscar();
    }
    
    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {
        usuarioService.guardar(usuario);
        return ResponseEntity.ok("Usuario creado con exito");
    }

    @PutMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> actualizar(@RequestBody Usuario usuario) {
    	usuarioService.guardar(usuario);
        return ResponseEntity.ok("Usuario actualizado con exito");
    }

    @DeleteMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> eliminar(@RequestBody Usuario usuario) {
    	usuarioService.eliminar(usuario.getId());
        return ResponseEntity.ok("Usuario eliminado con exito");
    }
    
    @GetMapping(value = "/{username}")
	@Secured("ROLE_ALUMNO")
    public UsuarioDto buscarPorUsername(@PathVariable String username) {
        
    	return usuarioService.buscarPorUsername(username);
    }
	
}
