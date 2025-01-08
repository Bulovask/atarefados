package br.com.bulovask.atarefados.Repository;
import br.com.bulovask.atarefados.entidades.Anexo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexoRepository extends CrudRepository<Anexo, Long> {
}
