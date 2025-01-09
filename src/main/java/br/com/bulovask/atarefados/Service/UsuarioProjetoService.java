package br.com.bulovask.atarefados.Service;

import br.com.bulovask.atarefados.Repository.UsuarioProjetoRepository;
import br.com.bulovask.atarefados.Entity.UsuarioProjeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioProjetoService {
    @Autowired
    private UsuarioProjetoRepository usuarioProjetoRepository;

    public ResponseEntity<UsuarioProjeto> salvar (UsuarioProjeto usuarioProjeto){
        return new ResponseEntity<UsuarioProjeto>(usuarioProjetoRepository.save(usuarioProjeto), HttpStatus.OK);
    }

    public Iterable<UsuarioProjeto> listarTodos (){
        return usuarioProjetoRepository.findAll();
    }
    public ResponseEntity<UsuarioProjeto> buscarPorId(Long id) {
        return new ResponseEntity<UsuarioProjeto>(usuarioProjetoRepository.findById(id).orElseThrow(),HttpStatus.OK);
    }

    public ResponseEntity deletar(Long id) {
        usuarioProjetoRepository.deleteById(id);
        return new ResponseEntity("{\"mensagem\":\"Removido com sucesso\"}",HttpStatus.OK);
    }
}
