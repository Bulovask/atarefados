package br.com.bulovask.atarefados.Service;

import br.com.bulovask.atarefados.DTOs.read.ProjetoLazyDTO;
import br.com.bulovask.atarefados.Repository.ProjetoRepository;
import br.com.bulovask.atarefados.Entity.Projeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;

    public ResponseEntity<Projeto> salvar (Projeto projeto){
        return new ResponseEntity<Projeto>(projetoRepository.save(projeto), HttpStatus.OK);
    }

    public Iterable<Projeto> listarTodos (){
        return projetoRepository.findAll();
    }

    public ResponseEntity<Projeto> buscarPorId(Long id) {
        return new ResponseEntity<Projeto>(projetoRepository.findById(id).orElseThrow(),HttpStatus.OK);
    }

    public ResponseEntity deletar(Long id) {
        projetoRepository.deleteById(id);
        return new ResponseEntity("{\"mensagem\":\"Removido com sucesso\"}",HttpStatus.OK);
    }
}
