package br.com.bulovask.atarefados.Service;

import br.com.bulovask.atarefados.Repository.CategoriaRepository;
import br.com.bulovask.atarefados.entidades.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public ResponseEntity<Categoria> salvar (Categoria categoria){
        return new ResponseEntity<Categoria>(categoriaRepository.save(categoria), HttpStatus.OK);
    }

    public Iterable<Categoria> listarTodos (){
        return categoriaRepository.findAll();
    }
    public ResponseEntity<Categoria> buscarPorId(Long id) {
        return new ResponseEntity<Categoria>(categoriaRepository.findById(id).orElseThrow(),HttpStatus.OK);
    }

    public ResponseEntity deletar(Long id) {
        categoriaRepository.deleteById(id);
        return new ResponseEntity("{\"mensagem\":\"Removido com sucesso\"}",HttpStatus.OK);
    }
}
