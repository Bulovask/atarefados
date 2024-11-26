package br.com.bulovask.atarefados.Repository;
import br.com.bulovask.atarefados.entidades.CategoriaTarefa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaTarefaRepository extends CrudRepository<CategoriaTarefa, Long> {
}
