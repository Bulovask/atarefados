package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.Service.ComentarioTarefaService;
import br.com.bulovask.atarefados.Entity.ComentarioTarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComentarioTarefaController {

    @Autowired
    private ComentarioTarefaService comentarioTarefaService;

    @PostMapping("/comentario-tarefa")
    public ComentarioTarefa salvar(@RequestBody ComentarioTarefa comentarioTarefa){
        return comentarioTarefaService.salvar(comentarioTarefa).getBody();
    }

    @GetMapping("/comentario-tarefa")
    public Iterable<ComentarioTarefa> listarTodos (){
        return comentarioTarefaService.listarTodos();
    }

    @GetMapping("/comentario-tarefa/{id}")
    public ResponseEntity<ComentarioTarefa> buscarPorId(@PathVariable Long id){
        return comentarioTarefaService.buscarPorId(id);
    }

    @DeleteMapping("/comentario-tarefa/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        return comentarioTarefaService.deletar(id);
    }

    @PutMapping("/comentario-tarefa/{id}")
    public ComentarioTarefa atualizar(@PathVariable Long id, @RequestBody ComentarioTarefa comentarioTarefa){
        comentarioTarefa.setId(id);
        return comentarioTarefaService.salvar(comentarioTarefa).getBody();
    }
}