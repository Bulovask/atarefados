package br.com.bulovask.atarefados.Service;

import br.com.bulovask.atarefados.Repository.CategoriaTarefaRepository;
import br.com.bulovask.atarefados.Repository.UsuarioRepository;
import br.com.bulovask.atarefados.entidades.CategoriaTarefa;
import br.com.bulovask.atarefados.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoriaTarefaService {
    @Autowired
    private CategoriaTarefaRepository categoriaTarefaRepository;

    public ResponseEntity<CategoriaTarefa> salvar (CategoriaTarefa categoriaTarefa){
        return new ResponseEntity<CategoriaTarefa>(categoriaTarefaRepository.save(categoriaTarefa), HttpStatus.OK);
    }

    public Iterable<CategoriaTarefa> listarTodos (){
        return categoriaTarefaRepository.findAll();
    }
    public ResponseEntity<CategoriaTarefa> buscarPorId(Long id) {
        return new ResponseEntity<CategoriaTarefa>(categoriaTarefaRepository.findById(id).orElseThrow(),HttpStatus.OK);
    }

    public ResponseEntity deletar(Long id) {
        categoriaTarefaRepository.deleteById(id);
        return new ResponseEntity("{\"mensagem\":\"Removido com sucesso\"}",HttpStatus.OK);
    }
}
