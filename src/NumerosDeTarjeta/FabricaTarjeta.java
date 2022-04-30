package NumerosDeTarjeta;

public class FabricaTarjeta {

    public static Tarjeta getTarjeta(String tipo){
        if (tipo.equals("Internacional")){
            return Internacional.getInternacional();
        }else if (tipo.equals("Nacional")){
            return Nacional.getNacional();
        }else {
            return Regional.getRegional();
        }
    }

}
