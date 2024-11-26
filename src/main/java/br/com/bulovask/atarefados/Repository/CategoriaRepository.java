package br.com.bulovask.atarefados.Repository;
import br.com.bulovask.atarefados.entidades.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}
