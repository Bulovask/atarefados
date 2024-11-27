package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.Service.CategoriaService;
import br.com.bulovask.atarefados.entidades.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/Categoria")
    public Categoria salvar(@RequestBody Categoria categoria){
        return categoriaService.salvar(categoria).getBody();
    }

    @GetMapping("/Categoria")
    public Iterable<Categoria> listarTodos (){
        return categoriaService.listarTodos();
    }

    @GetMapping("/Categoria/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }

    @DeleteMapping("/Categoria/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        return categoriaService.deletar(id);
    }

    @PutMapping("/Categoria/{id}")
    public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria categoria){
        categoria.setId(id);
        return categoriaService.salvar(categoria).getBody();
    }
}
