import java.util.ArrayList;
import java.util.Date;

public class CuentaBancaria {
    protected long numeroCuenta;
    protected double saldo;
    protected Date fechaAlta;
    protected Cliente cliente;
    protected ArrayList<Movimiento> movimientos;

    public CuentaBancaria(long numeroCuenta, double saldo, Date fechaAlta, Cliente cliente){
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaAlta = fechaAlta;
        this.cliente = cliente;
        this.movimientos = new ArrayList<>();
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void agregarMovimiento(Movimiento movimiento) {
        this.movimientos.add(movimiento);
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }
}
