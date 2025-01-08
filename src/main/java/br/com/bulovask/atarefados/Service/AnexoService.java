package br.com.bulovask.atarefados.Service;

import br.com.bulovask.atarefados.Repository.AnexoRepository;
import br.com.bulovask.atarefados.entidades.Anexo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AnexoService {
    @Autowired
    private AnexoRepository anexoRepository;

    public ResponseEntity<Anexo> salvar (Anexo anexo){
        return new ResponseEntity<Anexo>(anexoRepository.save(anexo), HttpStatus.OK);
    }

    public Iterable<Anexo> listarTodos (){
        return anexoRepository.findAll();
    }
    public ResponseEntity<Anexo> buscarPorId(Long id) {
        return new ResponseEntity<Anexo>(anexoRepository.findById(id).orElseThrow(),HttpStatus.OK);
    }

    public ResponseEntity deletar(Long id) {
        anexoRepository.deleteById(id);
        return new ResponseEntity("{\"mensagem\":\"Removido com sucesso\"}",HttpStatus.OK);
    }
}
