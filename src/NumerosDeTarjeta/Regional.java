package NumerosDeTarjeta;
;
import java.io.*;

public class Regional implements Tarjeta {
    final static String NUMERO_REGIONAL="4256-3102-6590-";
    static String noTarjeta;
    static NumeroDeTarjetaDeCredito controlador = new NumeroDeTarjetaDeCredito();

    static private Regional regional = null;

    private Regional() { }

    static public Regional getRegional() {

        if (regional == null) {
            regional = new Regional();
        }
        return regional;
    }

    @Override
    public void actualizarArchivo(int numero){
        try{
            DataOutputStream fileOut;
            fileOut =
            new DataOutputStream(
                    new FileOutputStream("numeroRegionalCorriente.txt", false));
                    fileOut.writeInt(numero);
        }catch(IOException e){
                System.out.println("IO Error: "+e.getMessage());
        }
    }
    static int numero=0;
    @Override
    public String leerYAsingarNumeroEnArchivo(){
        try{
        DataInputStream fileIn;
            fileIn =
            new DataInputStream(
                    new FileInputStream("numeroRegionalCorriente.txt"));
                    numero = fileIn.readInt();
                    noTarjeta=controlador.asingarNumeroTarjeta(NUMERO_REGIONAL,numero);
                    numero=numero+1;
                    actualizarArchivo(numero);
        }catch(IOException e){
                System.out.println("IO Error: "+e.getMessage());
        }
        return noTarjeta;
    }   
}

