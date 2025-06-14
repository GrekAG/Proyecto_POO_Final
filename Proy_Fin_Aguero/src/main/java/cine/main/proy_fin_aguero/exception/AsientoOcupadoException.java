package cine.main.proy_fin_aguero.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AsientoOcupadoException extends RuntimeException {
    public AsientoOcupadoException(String message) {
        super(message);
    }
}
