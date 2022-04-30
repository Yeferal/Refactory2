package objectinstruction;

import java.io.Serializable;

public class Solicitud implements Serializable {
    private int numeroDeSolicitud;
    private String fecha;
    private int tipo;
    private String nombre;
    private int salario;
    private String direccion;

    public Solicitud(int numSolicitud,String fecha, int tipo, String nombre, int salario,String direccion){
        this.numeroDeSolicitud=numSolicitud;
        this.fecha=fecha;
        this.tipo=tipo;
        this.nombre=nombre;
        this.salario=salario;
        this.direccion=direccion;
    }

    public Solicitud()
    { }

    public int getNumeroDeSolicitud() {
        return numeroDeSolicitud;
    }

    public void setNumeroDeSolicitud(int numeroDeSolicitud) {
        this.numeroDeSolicitud = numeroDeSolicitud;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
