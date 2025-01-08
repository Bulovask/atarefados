package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.Service.ComentarioTarefaService;
import br.com.bulovask.atarefados.Service.TarefaService;
import br.com.bulovask.atarefados.entidades.ComentarioTarefa;
import br.com.bulovask.atarefados.entidades.Lista;
import br.com.bulovask.atarefados.entidades.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping("/tarefa")
    public Tarefa salvar(@RequestBody Tarefa tarefa){
        return tarefaService.salvar(tarefa).getBody();
    }

    @GetMapping("/tarefa")
    public Iterable<Tarefa> listarTodos (){
        return tarefaService.listarTodos();
    }

    @GetMapping("/tarefa/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id){
        return tarefaService.buscarPorId(id);
    }

    @DeleteMapping("/tarefa/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        return tarefaService.deletar(id);
    }

    @PutMapping("/tarefa/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa){
        tarefa.setId(id);
        return tarefaService.salvar(tarefa).getBody();
    }

}