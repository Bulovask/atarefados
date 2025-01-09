package br.com.bulovask.atarefados.Repository;
import br.com.bulovask.atarefados.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
