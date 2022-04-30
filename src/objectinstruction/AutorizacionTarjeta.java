package objectinstruction;

import java.io.Serializable;

public class AutorizacionTarjeta implements Serializable {
    private String numeroDeSiguienteTarjeta;
    private int salario ;
    private int tipo ;
    private String nombre;
    private String direccion;
    private boolean estado;
    private int limite;
    private double credito;

    public AutorizacionTarjeta(String numeroDeSiguienteTarjeta, int salario, int tipo, String nombre, String direccion, boolean estado, int limite, double credito) {
        this.numeroDeSiguienteTarjeta = numeroDeSiguienteTarjeta;
        this.salario = salario;
        this.tipo = tipo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.estado = estado;
        this.limite = limite;
        this.credito = credito;
    }

    public String getNumeroDeSiguienteTarjeta() {
        return numeroDeSiguienteTarjeta;
    }

    public void setNumeroDeSiguienteTarjeta(String numeroDeSiguienteTarjeta) {
        this.numeroDeSiguienteTarjeta = numeroDeSiguienteTarjeta;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }
}
