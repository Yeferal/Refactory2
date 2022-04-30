package Instrucciones;

import registrodetarjetas.ControladorDeArchivos;

public class StrategyInstruction {

    Instruccion insAutorizacionTarjeta = new InsAutorizacion_Tarjeta();
    Instruccion insCancelacionTarjeta = new InsCancelacion_Tarjeta();
    Instruccion insConsultarTarjeta = new InsConsultar_Tarjeta();
    Instruccion insEstadoCuenta = new InsEstado_Cuenta();
    Instruccion insListadoSolicitudes = new InsListado_Solicitudes();
    Instruccion insListadoTarjetas = new InsListado_Tarjetas();
    Instruccion insMovimiento = new InsMovimiento();
    Instruccion insSolicitud = new InsSolicitud();

    public String textoResultado;

    public void evaluarLinea(String line){
        textoResultado = "";
        if(line.startsWith("SOLICITUD")){
            textoResultado = insSolicitud.evaluarLinea(line);
        } else if(line.startsWith("MOVIMIENTO")){
            textoResultado = insMovimiento.evaluarLinea(line);
        } else if(line.startsWith("AUTORIZACION_TARJETA")){
            textoResultado = insAutorizacionTarjeta.evaluarLinea(line);
        } else if(line.startsWith("CANCELACION_TARJETA")){
            textoResultado = insCancelacionTarjeta.evaluarLinea(line);
        } else if(line.startsWith("CONSULTAR_TARJETA")){
            textoResultado = insConsultarTarjeta.evaluarLinea(line);
        } else if(line.startsWith("ESTADO_CUENTA")){
            textoResultado = insEstadoCuenta.evaluarLinea(line);
        } else if(line.startsWith("LISTADO_TARJETAS")){
            textoResultado = insListadoTarjetas.evaluarLinea(line);
        } else if(line.startsWith("LISTADO_SOLICITUDES")){
            textoResultado = insListadoSolicitudes.evaluarLinea(line);
        }
    }

}
