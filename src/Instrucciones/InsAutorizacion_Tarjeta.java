package Instrucciones;

import NumerosDeTarjeta.FabricaTarjeta;
import NumerosDeTarjeta.Internacional;
import NumerosDeTarjeta.Nacional;

import NumerosDeTarjeta.Regional;
import objectinstruction.Solicitud;
import registrodetarjetas.ControladorDeArchivos;
import objectinstruction.TarjetaDeCredito;


public class InsAutorizacion_Tarjeta implements Instruccion {

    String pathRoot = "Archivos";

    @Override
    public String evaluarLinea(String line) {
        ControladorDeArchivos controlador = new ControladorDeArchivos();
        Solicitud solicitudActual= new Solicitud();

        int numeroDeSolicitud = Integer.valueOf(line
                .replaceAll("AUTORIZACION_TARJETA", "")
                .replace("(", "")
                .replace(")", ""));
        String nombreDelArchivo = "Solicitud"+numeroDeSolicitud+".sol";
        solicitudActual = controlador.leerSolicitud(pathRoot+"/Solicitud/"+nombreDelArchivo);
        int tipo = solicitudActual.getTipo();
        int salario = solicitudActual.getSalario();
        int limite = (int) (salario*0.6);
        String nombre = solicitudActual.getNombre();
        String direccion = solicitudActual.getDireccion();
        double credito = 0;
        boolean estado = true;
        String numeroDeSiguienteTarjeta = asignarNumeroDeTarjeta(limite,tipo);

        if(numeroDeSiguienteTarjeta==null){
            System.out.println("No se pudo autorizar su tarjeta, porque no cumple con los requisitos. "+nombreDelArchivo);
            return "No. Solicitud: "+numeroDeSolicitud +
                    "\n"+"No se pudo autorizar su tarjeta, porque no cumple con los requisitos." +
                    "";
        }else{
            TarjetaDeCredito tarjeta = new TarjetaDeCredito(numeroDeSiguienteTarjeta,tipo, limite,nombre, direccion, credito, true);
            String nombreDelArchivoTarjeta = "Archivos/Tarjeta/"+"Tarjeta"+numeroDeSiguienteTarjeta+".tacre";
            ControladorDeArchivos.escribirEnArchivo(nombreDelArchivoTarjeta, tarjeta);
            return  "=> Tarjeta Autorizada <=" + "\n" + "Nombre del Archivo Tarjeta: "+nombreDelArchivoTarjeta + "\n" +
                    "No. Tarjeta: "+numeroDeSiguienteTarjeta;
        }

    }

    public String asignarNumeroDeTarjeta(int limiteDeCredito, int tipo){
        String valorActual = null;

        if(tipo==1 & limiteDeCredito>=2000){ //se evalua si es del tipo 1 y si tiene un salario suficiente para la aprovacion de la tarjeta
            valorActual= FabricaTarjeta.getTarjeta("Nacional").leerYAsingarNumeroEnArchivo();
           System.out.println("Solicitud del tipo "+tipo+" aprovada con exito");
        }
        if(tipo==2 & limiteDeCredito>=5000){ //se evalua si es del tipo 2 y si tiene un salario suficiente para la aprovacion de la tarjeta
            valorActual= FabricaTarjeta.getTarjeta("Regional").leerYAsingarNumeroEnArchivo();
           System.out.println("Solicitud del tipo "+tipo+" aprovada con exito");
        }
        if(tipo==3 & limiteDeCredito>=12000){ //se evalua si es del tipo 3 y si tiene un salario suficiente para la aprovacion de la tarjeta
            valorActual= FabricaTarjeta.getTarjeta("Internacional").leerYAsingarNumeroEnArchivo();
           System.out.println("Solicitud del tipo "+tipo+" aprovada con exito");
        }
        return valorActual;
    }

}
