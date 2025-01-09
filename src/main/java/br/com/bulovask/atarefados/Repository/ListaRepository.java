package br.com.bulovask.atarefados.Repository;
import br.com.bulovask.atarefados.Entity.Lista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository extends CrudRepository<Lista, Long> {
}
