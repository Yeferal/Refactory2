package registrodetarjetas;

import Instrucciones.Instruccion;
import Instrucciones.StrategyInstruction;

import java.util.Scanner;
import java.io.*;
import java.util.TimerTask;

public class ArchivoDeEntrada{
    
    Disenio actualizarInstrucciones;
    public String textoResultado;
    public String textoInstruccion;

    public ArchivoDeEntrada(Disenio disenio){
        this.actualizarInstrucciones = disenio;
    }
/*
    Este procedimiento sirve para leer el archivo de entrada 
    que contiene todas las instrucciones a ingresar al sistema.
    */
    protected void asignarArchivo(String path){
        Scanner archivoDeEntrada;
        String line = null;
        StrategyInstruction strategyInstruction = new StrategyInstruction();
        try{
           archivoDeEntrada = new Scanner(new FileReader(path));
           ControladorDeArchivos.crearArchivo("Archivos/numeroNacionalCorriente.txt");
           ControladorDeArchivos.crearArchivo("Archivos/numeroRegionalCorriente.txt");
           ControladorDeArchivos.crearArchivo("Archivos/numeroInternacionalCorriente.txt");

           while (archivoDeEntrada.hasNextLine()){

               line = archivoDeEntrada.nextLine();
               actualizarInstrucciones.setAreaInstrucciones(String.valueOf(line)+"\n"); //Las lineas que se van leyendo se almacenan en line
               strategyInstruction.evaluarLinea(line);
               actualizarInstrucciones.setAreaResultados(strategyInstruction.textoResultado+"\n");
           }
           archivoDeEntrada.close(); //luego de haber abierto el archivo de entrada tambien hay que cerrarlo para
           //que se liberen desbloquerlo y que se liberen recursos.
        }
        catch (FileNotFoundException e){ // si el archivo no existe captura la excepcion y lanza un mensaje
           System.out.println("Error: " + e.getMessage());
        }
    }//cerramos el procedimiento asignarArchivo
}//cerramos la clase ArchivoDeEntrada. 
