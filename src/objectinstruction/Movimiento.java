package objectinstruction;

import java.io.Serializable;

public class Movimiento implements Serializable {

    String numeroDeTarjeta;
    String fecha;
    String tipoDeMovimiento;
    String descripcion;
    String establecimiento;
    double monto;

    public Movimiento(String numeroDeTarjeta, String fecha, String tipoDeMovimiento, String descripcion, String establecimiento, double monto) {
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.fecha = fecha;
        this.tipoDeMovimiento = tipoDeMovimiento;
        this.descripcion = descripcion;
        this.establecimiento = establecimiento;
        this.monto = monto;
    }

    public String getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public void setNumeroDeTarjeta(String numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoDeMovimiento() {
        return tipoDeMovimiento;
    }

    public void setTipoDeMovimiento(String tipoDeMovimiento) {
        this.tipoDeMovimiento = tipoDeMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
