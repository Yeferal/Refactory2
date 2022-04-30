package Instrucciones;
import java.io.*;
import java.util.*;

import objectinstruction.Solicitud;
import registrodetarjetas.ControladorDeArchivos;

public class InsSolicitud implements Instruccion {
    String pathRoot = "Archivos/Solicitud/";

    @Override
    public String evaluarLinea(String line) {
        StringTokenizer token = new StringTokenizer(line,","); //se define un nuevo objeto StringTokenizer con la cadena line y el delmitador ","
        String temp; //la variable temp sirve para almacenar datos y poder operar con ellos antes de ingresarlos a sus datos fijos
        temp=token.nextToken().replace("(", ""); //aca se le quita el parentesis al primer token
        int numeroDeSolicitud = Integer.parseInt(temp.replaceAll("SOLICITUD", ""));
        temp=token.nextToken();
        String fecha=temp.replaceAll("\"","");
        int tipo=Integer.valueOf(token.nextToken().replace("\"", ""));
        String nombre=String.valueOf(token.nextToken().replaceAll("\"", ""));
        int salario=Integer.valueOf(token.nextToken());
        String direccion=token.nextToken().replaceAll("\"", "").replace(")", "");

        Solicitud solicitud = new Solicitud(numeroDeSolicitud,fecha,tipo,nombre,salario,direccion);
        String numeroDeLaSolicitud = String.valueOf(solicitud.getNumeroDeSolicitud());
        String nombreDeLaNuevaSolicitud = "Solicitud"+numeroDeLaSolicitud+".sol";
        ControladorDeArchivos.escribirEnArchivo(pathRoot+nombreDeLaNuevaSolicitud,solicitud);
        System.out.println(nombreDeLaNuevaSolicitud+": "+nombreDeLaNuevaSolicitud);
        return "Numero Solicitud: "+ numeroDeLaSolicitud+"\nNombre de la Nueva Solicitud"+nombreDeLaNuevaSolicitud;
    }
}
