package Controller;

import Service.ComentarioTarefaService;
import br.com.bulovask.atarefados.entidades.ComentarioTarefa;
import org.springframework.beans.factory.annotation.Autowired;

public class ComentarioTarefaController {
    @Autowired
    private ComentarioTarefaService comentarioTarefaService;
}
