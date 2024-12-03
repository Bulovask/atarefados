package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.Service.ProjetoService;
import br.com.bulovask.atarefados.entidades.Projeto;
import br.com.bulovask.atarefados.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping("/projeto")
    public ResponseEntity<Projeto> salvar(@RequestBody Projeto projeto) {
        return projetoService.salvar(projeto);
    }

    @GetMapping("/projeto")
    public Iterable<Projeto> listarTodos (){
        return projetoService.listarTodos();
    }

    @GetMapping("/projeto/{id}")
    public ResponseEntity<Projeto> buscarPorId(@PathVariable Long id){
        return projetoService.buscarPorId(id);
    }

    @DeleteMapping("/projeto/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        return projetoService.deletar(id);
    }

}
