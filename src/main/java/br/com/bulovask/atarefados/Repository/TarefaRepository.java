package br.com.bulovask.atarefados.Repository;
import br.com.bulovask.atarefados.Entity.Tarefa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa, Long> {
}
