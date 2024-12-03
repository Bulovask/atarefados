package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.Service.UsuarioProjetoService;
import br.com.bulovask.atarefados.Service.UsuarioService;
import br.com.bulovask.atarefados.entidades.Anexo;
import br.com.bulovask.atarefados.entidades.Usuario;
import br.com.bulovask.atarefados.entidades.UsuarioProjeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioProjetoController {



    @Autowired
    private UsuarioProjetoService usuarioProjetoService;

    @GetMapping("/usuarioProjeto")
    public Iterable<UsuarioProjeto> listarTodos(@RequestBody UsuarioProjeto usuarioProjeto) {
        List<UsuarioProjeto> usuarioProjetos = (List<UsuarioProjeto>) usuarioProjetoService.listarTodos();
        return usuarioProjetos;
    }
    @GetMapping("/usuarioProjeto/{id}")
    public ResponseEntity<UsuarioProjeto> buscarPorId(@PathVariable Long id){
        return usuarioProjetoService.buscarPorId(id);
    }

    @PostMapping("/usuarioProjeto")
    public ResponseEntity<UsuarioProjeto> salvar(@RequestBody UsuarioProjeto usuarioProjeto) {
        return usuarioProjetoService.salvar(usuarioProjeto);
    }
    @DeleteMapping("/usuarioProjeto/{id}")
    public ResponseEntity<UsuarioProjeto> deletar(@PathVariable Long id){
        return usuarioProjetoService.deletar(id);
    }
}
