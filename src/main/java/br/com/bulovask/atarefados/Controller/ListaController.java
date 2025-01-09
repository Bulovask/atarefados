package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.Service.ListaService;
import br.com.bulovask.atarefados.Entity.Lista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListaController {

    @Autowired
    private ListaService listaService;

    @PostMapping("/lista")
    public Lista salvar(@RequestBody Lista lista){
        return listaService.salvar(lista).getBody();
    }

    @GetMapping("/lista")
    public Iterable<Lista> listarTodos (){
        return listaService.listarTodos();
    }

    @GetMapping("/lista/{id}")
    public ResponseEntity<Lista> buscarPorId(@PathVariable Long id){
        return listaService.buscarPorId(id);
    }

    @DeleteMapping("/lista/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        return listaService.deletar(id);
    }

    @PutMapping("/lista/{id}")
    public Lista atualizar(@PathVariable Long id, @RequestBody Lista lista){
        lista.setId(id);
        return listaService.salvar(lista).getBody();
    }
}