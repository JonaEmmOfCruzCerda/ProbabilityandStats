import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CuentaBancaria {
    protected long numeroCuenta;
    protected double saldo;
    protected Date fechaAlta;
    protected Cliente cliente;
    public CuentaBancaria(long numeroCuenta, double saldo, Date fechaAlta, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaAlta = fechaAlta;
        this.cliente = cliente;
    }
    public long getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public Date getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
        return "Numero de cuenta: " + numeroCuenta + "\n" +
                "Saldo: " + saldo + "\n" +
                "Fecha de alta: " + formatter.format(fechaAlta) + "\n" +
                "Cliente: " + cliente;
    }
}