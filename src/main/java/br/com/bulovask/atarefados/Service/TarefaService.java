package br.com.bulovask.atarefados.Service;

import br.com.bulovask.atarefados.Repository.TarefaRepository;
import br.com.bulovask.atarefados.entidades.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    public ResponseEntity<Tarefa> salvar (Tarefa tarefa){
        return new ResponseEntity<Tarefa>(tarefaRepository.save(tarefa), HttpStatus.OK);
    }

    public Iterable<Tarefa> listarTodos (){
        return tarefaRepository.findAll();
    }
    public ResponseEntity<Tarefa> buscarPorId(Long id) {
        return new ResponseEntity<Tarefa>(tarefaRepository.findById(id).orElseThrow(),HttpStatus.OK);
    }

    public ResponseEntity deletar(Long id) {
        tarefaRepository.deleteById(id);
        return new ResponseEntity("{\"mensagem\":\"Removido com sucesso\"}",HttpStatus.OK);
    }
}
