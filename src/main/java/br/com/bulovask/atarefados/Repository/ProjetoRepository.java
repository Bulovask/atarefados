package br.com.bulovask.atarefados.Repository;
import br.com.bulovask.atarefados.Entity.Projeto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends CrudRepository<Projeto, Long> {
}
