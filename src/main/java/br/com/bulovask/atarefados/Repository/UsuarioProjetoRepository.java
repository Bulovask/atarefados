package br.com.bulovask.atarefados.Repository;
import br.com.bulovask.atarefados.Entity.UsuarioProjeto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioProjetoRepository extends CrudRepository<UsuarioProjeto, Long> {
}
