package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.Service.ComentarioTarefaService;
import br.com.bulovask.atarefados.Service.TarefaService;
import br.com.bulovask.atarefados.entidades.ComentarioTarefa;
import br.com.bulovask.atarefados.entidades.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping("/Tarefa")
    public Tarefa salvar(@RequestBody Tarefa tarefa){
        return tarefaService.salvar(tarefa).getBody();
    }

    @GetMapping("/Tarefa")
    public Iterable<Tarefa> listarTodos (){
        return tarefaService.listarTodos();
    }

    @GetMapping("/Tarefa/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id){
        return tarefaService.buscarPorId(id);
    }

    @DeleteMapping("/Tarefa/{id}")
    public ResponseEntity<Tarefa> deletar(@PathVariable Long id){
        return tarefaService.deletar(id);
    }

}