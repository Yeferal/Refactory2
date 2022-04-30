package Instrucciones;

import java.util.Calendar;
import java.util.StringTokenizer;

import objectinstruction.Movimiento;
import registrodetarjetas.ControladorDeArchivos;
import objectinstruction.TarjetaDeCredito;

public class InsMovimiento implements Instruccion {

    String pathRoot = "Archivos/Movimiento/";

    @Override
    public String evaluarLinea(String line) {
        try {
            StringTokenizer token = new StringTokenizer(line,","); //se define un nuevo objeto StringTokenizer con la cadena line y el delmitador ","
            String temp; //la variable temp sirve para almacenar datos y poder operar con ellos antes de ingresarlos a sus datos fijos
            temp=token.nextToken().replace("(", ""); //aca se le quita el parentesis al primer token que en este caso es Movimiento(
            String numeroDeTarjeta = temp.replaceAll("MOVIMIENTO", "");//Luego aca se le se quita la palabra movimiento a la variable numero de tarjeta y se convierte a entero
            String fecha = token.nextToken().replaceAll("\"",""); //mediante esta instruccion se quitan las comillas a la fecha
            String tipoDeMovimiento = (token.nextToken().replace("\"", ""));
            String descripcion = (token.nextToken().replace("\"", ""));
            String establecimiento = (token.nextToken().replace("\"", ""));
            double monto = Double.parseDouble(token.nextToken().replaceAll("\"", "").replace(")", ""));

            ControladorDeArchivos controlador = new ControladorDeArchivos();
            TarjetaDeCredito tarjeta = new TarjetaDeCredito();
            tarjeta=controlador.leerTarjetaDeCredito("Archivos/Tarjeta/"+"Tarjeta"+numeroDeTarjeta+".tacre");

            tarjeta.setCredito(tarjeta.getCreditoDeTarjeta()+monto);

            ControladorDeArchivos.escribirEnArchivo("Archivos/Tarjeta/"+"Tarjeta"+numeroDeTarjeta+".tacre", tarjeta);     //Actualizacion del objeto en el archivo
            Movimiento movimiento = new Movimiento(numeroDeTarjeta, fecha, tipoDeMovimiento, descripcion, establecimiento , monto);
            Calendar tiempo=Calendar.getInstance();
            String nombreDelNuevoMovimiento="Movimiento"+String.valueOf(tiempo.getTimeInMillis())+".mvito";
            ControladorDeArchivos.escribirEnArchivo(pathRoot+nombreDelNuevoMovimiento,movimiento);
            return "Movimiento \nCreando tarjeta: "+nombreDelNuevoMovimiento;
        }catch (NullPointerException e){
            System.out.println("La tarjeta no existe");
            return "La tarjeta no existe";
        }


    }
}
