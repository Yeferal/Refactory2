package Instrucciones;

import java.io.File;

import objectinstruction.Solicitud;
import registrodetarjetas.ControladorDeArchivos;

public class InsListado_Solicitudes implements Instruccion {
    String reporteHTML;
    String pathRoot = "Archivos/";

    @Override
    public String evaluarLinea(String line) {
        int numeroDeSolicitud;
        String fechaSolicitud = null;
        int tipoDeSolicitud;
        String tipo = null;
        String nombre;
        int salario = 0;
        String direccion;
        String fechaAutorizacion_Cancelacion;
        boolean estado;
        String condicion;

        ControladorDeArchivos controlador = new ControladorDeArchivos();
        Solicitud solicitud = new Solicitud();
        File carpeta = new File(new File ("Archivos/Solicitud").getAbsolutePath ());

        File[] files = carpeta.listFiles((dir1, name) ->
                name.endsWith(".sol"));

        reporteHTML="<table style=\"border-collapse: collapse;\">\n"
                + "<h3>Listado de Solicitudes<h3>" +
                "	  <tr>\n" +
                "	    <th style=\"border: 1px solid #000000;\">NUMERO DE SOLICITUD</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">FECHA DE SOLICITUD</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">SALARIO</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
                "           <th style=\"border: 1px solid #000000;\">FECHA APROV/RECH</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">ESTADO SOLICITUD</th>\n" +
                "	  </tr>";
        controlador.edicionDeReporteHTML(reporteHTML);
        System.out.println(reporteHTML);

        for(File i: files){
            solicitud = controlador.leerSolicitud(i.getPath());
            numeroDeSolicitud=solicitud.getNumeroDeSolicitud();
            tipoDeSolicitud=solicitud.getTipo();
            if(tipoDeSolicitud==1){tipo="Nacional";}
            if(tipoDeSolicitud==2){tipo="Regional";}
            if(tipoDeSolicitud==3){tipo="Internacional";}
            nombre=solicitud.getNombre();
            direccion=solicitud.getDireccion();
            //estado=solicitud.get;
            //if(estado){
            //    condicion="AUTORIZADA";
            //}else{condicion="RECHAZADA";}


            reporteHTML=
                    "         <tr>\n" +
                            "	    <td style=\"border: 1px solid #000000;\">"+numeroDeSolicitud+"</td>\n" +
                            "	    <td style=\"border: 1px solid #000000;\">"+solicitud.getFecha()+"</td>\n" +
                            "	    <td style=\"border: 1px solid #000000;\">"+tipo+"</td>\n" +
                            "	    <td style=\"border: 1px solid #000000;\">"+nombre+"</td>\n" +
                            "	    <td style=\"border: 1px solid #000000;\">"+solicitud.getSalario()+"</td>\n" +
                            "	    <td style=\"border: 1px solid #000000;\">"+direccion+"</td>\n" +
                            "           <td style=\"border: 1px solid #000000;\">"+""+"</td>\n" +
                            "	    <td style=\"border: 1px solid #000000;\">"+""+"</td>\n" +
                            "	  </tr>";

            controlador.edicionDeReporteHTML(reporteHTML);
            System.out.println(reporteHTML);
        }
        reporteHTML="</table>";
        controlador.edicionDeReporteHTML(reporteHTML);
        return "Reporte Escrito en el HTML";
    }
    
}
