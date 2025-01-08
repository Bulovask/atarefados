package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.Service.AnexoService;
import br.com.bulovask.atarefados.Service.ProjetoService;
import br.com.bulovask.atarefados.entidades.Anexo;
import br.com.bulovask.atarefados.entidades.Projeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnexoController {

    @Autowired
    private AnexoService anexoService;

    @PostMapping("/anexo")
    public Anexo salvar(@RequestBody Anexo anexo){
        return anexoService.salvar(anexo).getBody();
    }

    @GetMapping("/anexo")
    public Iterable<Anexo> listarTodos (){
        return anexoService.listarTodos();
    }

    @GetMapping("/anexo/{id}")
    public ResponseEntity<Anexo> buscarPorId(@PathVariable Long id){
        return anexoService.buscarPorId(id);
    }

    @DeleteMapping("/anexo/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        return anexoService.deletar(id);
    }

}