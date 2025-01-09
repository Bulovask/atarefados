package br.com.bulovask.atarefados.ResponseObject;

import br.com.bulovask.atarefados.DTOs.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultResObj {
    boolean error;
    String message;
    Object data;
}
