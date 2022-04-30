package NumerosDeTarjeta;

import java.io.*;

public class Nacional implements Tarjeta {
    final static String NUMERO_NACIONAL="4256-3102-6585-";
    static String noTarjeta;
    static NumeroDeTarjetaDeCredito controlador = new NumeroDeTarjetaDeCredito();
    static int numero=1;
    static private Nacional nacional = null;

    private Nacional() { }

    static public Nacional getNacional() {

        if (nacional == null) {
            nacional = new Nacional();
        }
        return nacional;
    }

    @Override
    public void actualizarArchivo(int numero){
        try{
            DataOutputStream fileOut;
            fileOut =
            new DataOutputStream(
                    new FileOutputStream("numeroNacionalCorriente.txt", false));
                    fileOut.writeInt(numero);
        }catch(IOException e){
                System.out.println("IO Error: "+e.getMessage());
        }
    }
    @Override
    public String leerYAsingarNumeroEnArchivo(){
        try{
        DataInputStream fileIn;
            fileIn =
            new DataInputStream(
                    new FileInputStream("numeroNacionalCorriente.txt"));
                    numero = (Integer) fileIn.readInt();  //este comando lee el valor que tiene nuestro archivo numeroNacionalCorriente.txt
                    noTarjeta=(controlador.asingarNumeroTarjeta(NUMERO_NACIONAL,numero)); //aca Obtenemos el numero de nuestra siguiente tarjeta a instanciar
                    numero=numero+1;
                    actualizarArchivo(numero);  //Mediante este comando se invoca al metodo actualizarArchivo el cual sobreescribe el siguiente numero.
        }catch(IOException e){
                System.out.println("IO Error: "+e.getMessage());
        }
        return noTarjeta; //este retorno me regresa un valor con el formato de un numero como xxxx-xxxx-xxxx-xxxx
    }
}
