package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.Service.CategoriaService;
import br.com.bulovask.atarefados.entidades.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoriaTarefaController {

    @Autowired
    private CategoriaTarefaService categoriaTarefaService;

    @PostMapping("/CategoriaTarefa")
    public CategoriaTarefa salvar(@RequestBody CategoriaTarefa categoriaTarefa){
        return categoriaTarefaService.salvar(categoriaTarefa).getBody();
    }

    @GetMapping("/CategoriaTarefa")
    public Iterable<Categoria> listarTodos (){
        return categoriaTarefaService.listarTodos();
    }

    @GetMapping("/CategoriaTarefa/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id){
        return categoriaTarefaService.buscarPorId(id);
    }

    @DeleteMapping("/CategoriaTarefa/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        return categoriaTarefaService.deletar(id);
    }

    @PutMapping("/CategoriaTarefa/{id}")
    public CategoriaTarefa atualizar(@PathVariable Long id, @RequestBody CategoriaTarefa categoriaTarefa){
        categoria.setId(id);
        return categoriaTarefaService.salvar(categoriaTarefa).getBody();
    }
}