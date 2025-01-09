package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.Service.CategoriaService;
import br.com.bulovask.atarefados.Entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/categoria")
    public Categoria salvar(@RequestBody Categoria categoria){
        return categoriaService.salvar(categoria).getBody();
    }

    @GetMapping("/categoria")
    public Iterable<Categoria> listarTodos (){
        return categoriaService.listarTodos();
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }

    @DeleteMapping("/categoria/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        return categoriaService.deletar(id);
    }

    @PutMapping("/categoria/{id}")
    public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria categoria){
        categoria.setId(id);
        return categoriaService.salvar(categoria).getBody();
    }
}
