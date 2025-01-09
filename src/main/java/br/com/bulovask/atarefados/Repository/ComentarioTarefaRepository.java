package br.com.bulovask.atarefados.Repository;
import br.com.bulovask.atarefados.Entity.ComentarioTarefa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioTarefaRepository extends CrudRepository<ComentarioTarefa, Long> {
}
