package NumerosDeTarjeta;

import java.io.*;

public class Internacional implements Tarjeta{
    final static String NUMERO_INTERNACIONAL=   "4256-3102-6595-";
    static String noTarjeta;
    static NumeroDeTarjetaDeCredito controlador = new NumeroDeTarjetaDeCredito();
    static private Internacional internacional = null;

    private Internacional() { }

    static public Internacional getInternacional() {

        if (internacional == null) {
            internacional = new Internacional();
        }
        return internacional;
    }


    @Override
    public void actualizarArchivo(int numero){
        try{
            DataOutputStream fileOut;
            fileOut =
            new DataOutputStream(
                    new FileOutputStream("numeroInternacionalCorriente.txt", false));
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
                    new FileInputStream("numeroInternacionalCorriente.txt"));
                    numero=fileIn.readInt();
                    noTarjeta=controlador.asingarNumeroTarjeta(NUMERO_INTERNACIONAL,numero);
                    numero=numero+1;
                    actualizarArchivo(numero);
        }catch(IOException e){
                System.out.println("IO Error: "+e.getMessage());
        }
        return noTarjeta; 
    }  
}
