package br.com.bulovask.atarefados.Service;

import br.com.bulovask.atarefados.Repository.ComentarioTarefaRepository;
import br.com.bulovask.atarefados.Entity.ComentarioTarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ComentarioTarefaService {
    @Autowired
    private ComentarioTarefaRepository comentarioTarefaRepository;

    public ResponseEntity<ComentarioTarefa> salvar(ComentarioTarefa comentarioTarefa){
        return new ResponseEntity<ComentarioTarefa>(comentarioTarefaRepository.save(comentarioTarefa), HttpStatus.OK);
    }

    public Iterable<ComentarioTarefa> listarTodos (){
        return comentarioTarefaRepository.findAll();
    }
    public ResponseEntity<ComentarioTarefa> buscarPorId(Long id) {
        return new ResponseEntity<ComentarioTarefa>(comentarioTarefaRepository.findById(id).orElseThrow(),HttpStatus.OK);
    }

    public ResponseEntity deletar(Long id) {
        comentarioTarefaRepository.deleteById(id);
        return new ResponseEntity("{\"mensagem\":\"Removido com sucesso\"}",HttpStatus.OK);
    }
}
