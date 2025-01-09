package br.com.bulovask.atarefados.Service;

import br.com.bulovask.atarefados.Repository.ListaRepository;
import br.com.bulovask.atarefados.Entity.Lista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ListaService {
    @Autowired
    private ListaRepository listaRepository;

    public ResponseEntity<Lista> salvar (Lista lista){
        return new ResponseEntity<Lista>(listaRepository.save(lista), HttpStatus.OK);
    }

    public Iterable<Lista> listarTodos (){
        return listaRepository.findAll();
    }
    public ResponseEntity<Lista> buscarPorId(Long id) {
        return new ResponseEntity<Lista>(listaRepository.findById(id).orElseThrow(),HttpStatus.OK);
    }

    public ResponseEntity deletar(Long id) {
        listaRepository.deleteById(id);
        return new ResponseEntity("{\"mensagem\":\"Removido com sucesso\"}",HttpStatus.OK);
    }
}