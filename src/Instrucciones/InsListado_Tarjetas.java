package Instrucciones;

import java.io.File;
import registrodetarjetas.ControladorDeArchivos;
import objectinstruction.TarjetaDeCredito;

public class InsListado_Tarjetas implements Instruccion {

    String reporteHTML;
    String pathRoot = "Archivos/";

    @Override
    public String evaluarLinea(String line) {
        String numeroDeTarjeta;
        int tipoDeTarjeta;
        String tipo = null;
        int limite = 0;
        String nombre;
        String direccion;
        String fecha;
        boolean estado;
        String condicion;

        ControladorDeArchivos controlador = new ControladorDeArchivos();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito();

        File carpeta = new File(new File ("Archivos/Tarjeta").getAbsolutePath ());
        File[] files = carpeta.listFiles((dir1, name) ->
                name.endsWith(".tacre"));

        reporteHTML="<table style=\"border-collapse: collapse;\">\n"
                + "<h3>Listado de Tarjetas<h3>" +
                "	    <th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
                "           <th style=\"border: 1px solid #000000;\">FECHA</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n" +
                "	  </tr>";
        controlador.edicionDeReporteHTML(reporteHTML);

        for(File i: files){
            tarjeta=controlador.leerTarjetaDeCredito(i.getPath());
            numeroDeTarjeta=tarjeta.getNumeroDeTarjeta();
            tipoDeTarjeta=tarjeta.getTipo();
            if(tipoDeTarjeta==1){tipo="Nacional";limite=2000;}
            if(tipoDeTarjeta==2){tipo="Regional";limite=5000;}
            if(tipoDeTarjeta==3){tipo="Internacional";limite=12000;}
            nombre=tarjeta.getnombreDelCliente();
            direccion=tarjeta.getDireccionDelCliente();
            estado=tarjeta.getEstaActiva();
            if(estado){
                condicion="ACTIVA";
            }else{condicion="CANCELADA";}


            reporteHTML=
                    "         <tr>\n" +
                            "	    <td style=\"border: 1px solid #000000;\">"+numeroDeTarjeta+"</th>\n" +
                            "	    <td style=\"border: 1px solid #000000;\">"+tipo+"</th>\n" +
                            "	    <td style=\"border: 1px solid #000000;\">"+limite+"</th>\n" +
                            "	    <td style=\"border: 1px solid #000000;\">"+nombre+"</th>\n" +
                            "	    <td style=\"border: 1px solid #000000;\">"+direccion+"</th>\n" +
                            "           <td style=\"border: 1px solid #000000;\">"+""+"</th>\n" +
                            "	    <td style=\"border: 1px solid #000000;\">"+condicion+"</th>\n" +
                            "	  </tr>";

            controlador.edicionDeReporteHTML(reporteHTML);

        }
        reporteHTML="</table>";
        controlador.edicionDeReporteHTML(reporteHTML);
        return "Reporte Escrito en el HTML";
    }
}
