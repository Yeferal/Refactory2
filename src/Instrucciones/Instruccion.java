package Instrucciones;

import java.io.Serializable;
import registrodetarjetas.ControladorDeArchivos;
import registrodetarjetas.Disenio;

public interface Instruccion {

    public String evaluarLinea(String line);

}
