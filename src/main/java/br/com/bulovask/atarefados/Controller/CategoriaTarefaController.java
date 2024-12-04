package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.Service.CategoriaTarefaService;
import br.com.bulovask.atarefados.entidades.CategoriaTarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoriaTarefaController {

    @Autowired
    private CategoriaTarefaService categoriaTarefaService;

    @PostMapping("/categoriaTarefa")
    public CategoriaTarefa salvar(@RequestBody CategoriaTarefa categoriaTarefa){
        return categoriaTarefaService.salvar(categoriaTarefa).getBody();
    }

    @GetMapping("/categoriaTarefa")
    public Iterable<CategoriaTarefa> listarTodos (){
        return categoriaTarefaService.listarTodos();
    }

    @GetMapping("/categoriaTarefa/{id}")
    public ResponseEntity<CategoriaTarefa> buscarPorId(@PathVariable Long id){
        return categoriaTarefaService.buscarPorId(id);
    }

    @DeleteMapping("/categoriaTarefa/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        return categoriaTarefaService.deletar(id);
    }

    @PutMapping("/categoriaTarefa/{id}")
    public CategoriaTarefa atualizar(@PathVariable Long id, @RequestBody CategoriaTarefa categoriaTarefa){
        categoriaTarefa.setId(id);
        return categoriaTarefaService.salvar(categoriaTarefa).getBody();
    }
}