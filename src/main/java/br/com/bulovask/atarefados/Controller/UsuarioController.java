package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.Service.UsuarioService;
import br.com.bulovask.atarefados.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UsuarioController {



    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public Iterable<Usuario> listarTodos(@RequestBody Usuario usuario) {
        List<Usuario> usuarios = (List<Usuario>) usuarioService.listarTodos();
        return usuarios;
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }
}



