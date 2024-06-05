import java.util.Date;

public class Movimiento {
    public String tipo, saldoAnterior, saldoActual, cantidad;
    public Date fecha;

    public Movimiento(String tipo, String saldoAnterior, String saldoActual, String cantidad, Date fecha){
        this.tipo = tipo;
        this.saldoAnterior = saldoAnterior;
        this.saldoActual = saldoActual;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }
    public String getSaldoAnterior() {
        return saldoAnterior;
    }
    public String getSaldoActual() {
        return saldoActual;
    }
    public String getCantidad() {
        return cantidad;
    }
    public Date getFecha() {
        return fecha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setSaldoAnterior(String saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }
    public void setSaldoActual(String saldoActual) {
        this.saldoActual = saldoActual;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

