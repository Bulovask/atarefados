package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.Service.UsuarioProjetoService;
import br.com.bulovask.atarefados.entidades.Usuario;
import br.com.bulovask.atarefados.entidades.UsuarioProjeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UsuarioProjetoController {



    @Autowired
    private UsuarioProjetoService usuarioProjetoService;

    @PostMapping("/usuarioProjeto")
    public ResponseEntity<UsuarioProjeto> salvar(@RequestBody UsuarioProjeto usuarioProjeto) {
        return usuarioProjetoService.salvar(usuarioProjeto);
    }
}