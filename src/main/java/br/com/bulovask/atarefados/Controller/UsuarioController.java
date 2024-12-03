package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.Service.UsuarioService;
import br.com.bulovask.atarefados.entidades.Usuario;
import br.com.bulovask.atarefados.entidades.UsuarioProjeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
        return usuarioService.buscarPorId(id);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Usuario> deletar(@PathVariable Long id){
        return usuarioService.deletar(id);
    }

}



