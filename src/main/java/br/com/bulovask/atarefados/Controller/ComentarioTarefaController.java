package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.Service.ComentarioTarefaService;
import br.com.bulovask.atarefados.Service.ListaService;
import br.com.bulovask.atarefados.entidades.ComentarioTarefa;
import br.com.bulovask.atarefados.entidades.Lista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComentarioTarefaController {

    @Autowired
    private ComentarioTarefaService comentarioTarefaService;

    @PostMapping("/comentarioTarefa")
    public ComentarioTarefa salvar(@RequestBody ComentarioTarefa comentarioTarefa){
        return ComentarioTarefaService.salvar(comentarioTarefa).getBody();
    }

    @GetMapping("/comentarioTarefa")
    public Iterable<ComentarioTarefa> listarTodos (){
        return comentarioTarefaService.listarTodos();
    }

    @GetMapping("/comentarioTarefa/{id}")
    public ResponseEntity<ComentarioTarefa> buscarPorId(@PathVariable Long id){
        return comentarioTarefaService.buscarPorId(id);
    }

    @DeleteMapping("/comentrioTarefa/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        return comentarioTarefaService.deletar(id);
    }

    @PutMapping("/comentarioTarefa/{id}")
    public ComentarioTarefa atualizar(@PathVariable Long id, @RequestBody ComentarioTarefa comentarioTarefa){
        comentarioTarefa.setId(id);
        return comentarioTarefaService.salvar(comentarioTarefa).getBody();
    }
}