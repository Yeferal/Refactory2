package Instrucciones;

import registrodetarjetas.ControladorDeArchivos;
import objectinstruction.TarjetaDeCredito;

public class InsCancelacion_Tarjeta implements Instruccion {

    String pathRoot = "Archivos/";

    @Override
    public String evaluarLinea(String line) {
        try{
            String numeroDeTarjeta=line
                .replaceAll("CANCELACION_TARJETA","")
                .replace("(", "")
                .replace(")", "");
            String nombreDelArchivo = "Tarjeta"+numeroDeTarjeta+".tacre";
            ControladorDeArchivos controlador = new ControladorDeArchivos();
            TarjetaDeCredito tarjeta = new TarjetaDeCredito();
            tarjeta = controlador.leerTarjetaDeCredito(pathRoot+"Tarjeta/"+nombreDelArchivo);
            if(tarjeta.getCreditoDeTarjeta()<0){
                tarjeta.setEstaActiva(false);
                return "Tarjeta Activa: "+tarjeta.getNumeroDeTarjeta();
            }else{
                System.out.println("No se puede cancelar la tarjeta ya que tiene credito pendiente. "+tarjeta.getNumeroDeTarjeta());
                return "No se puede cancelar la tarjeta ya que tiene credito pendiente.\n" +
                        "No. Tarjeta: "+tarjeta.getNumeroDeTarjeta();
            }
        }
        catch(NullPointerException e){
//            System.out.println("No puede autorizar solicitudes que no existan ");
            return "No puede autorizar solicitudes que no existan";
        }
    }
    
}
