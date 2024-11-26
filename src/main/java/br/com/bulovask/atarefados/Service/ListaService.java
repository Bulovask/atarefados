package br.com.bulovask.atarefados.Service;

import br.com.bulovask.atarefados.Repository.ListaRepository;
import br.com.bulovask.atarefados.entidades.Lista;
import org.springframework.beans.factory.annotation.Autowired;

public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    public List<Lista> listarTodos() {
        return (List<Lista>) listaRepository.findAll();
    }

    public Optional<Lista> buscarPorId(Long id) {
        return listaRepository.findById(id);
    }

    public Lista salvar(Lista lista) {
        return listaRepository.save(lista);
    }

    public Lista atualizar(Long id, Lista listaAtualizada) {
        Optional<Lista> listaExistente = listaRepository.findById(id);
        if (listaExistente.isPresent()) {
            Lista lista = listaExistente.get();
            lista.setUsuario(listaAtualizada.getUsuario());
            lista.setProjeto(listaAtualizada.getProjeto());
            return listaRepository.save(lista);
        } else {
            throw new RuntimeException("Item da Lista não encontrado com o ID: " + id);
        }
    }

    public ResponseEntity deletar(Long id) {
        listaRepository.deleteById(id);
        return new ResponseEntity("{\"mensagem\":\"Removido com sucesso\"}", HttpStatus.OK);
    }
}