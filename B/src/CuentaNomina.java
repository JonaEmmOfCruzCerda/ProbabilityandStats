import java.util.ArrayList;
import java.util.Date;

public class CuentaNomina extends CuentaBancaria {
    private ArrayList<Movimiento> movimientos;

    public CuentaNomina(long numeroCuenta, double saldo, Date fechaAlta, Cliente cliente){
        super(numeroCuenta, saldo, fechaAlta, cliente);
        this.movimientos = new ArrayList<>();
    }

    public double depositar(double cantidad){
        setSaldo(getSaldo() + cantidad);
        Movimiento movimiento = new Movimiento("Depósito", Double.toString(getSaldo() - cantidad), Double.toString(getSaldo()), Double.toString(cantidad), new Date());
        agregarMovimiento(movimiento);
        return getSaldo();
    }

    public double retirar(double cantidad){
        if (cantidad <= getSaldo()){
            setSaldo(getSaldo() - cantidad);
            Movimiento movimiento = new Movimiento("Retiro", Double.toString(getSaldo() + cantidad), Double.toString(getSaldo()), Double.toString(cantidad), new Date());
            agregarMovimiento(movimiento);
            return cantidad;
        } else {
            System.out.println("Fondos insuficientes");
            return 0;
        }
    }

    public void imprimirMovimientos() {
        System.out.println();
        System.out.println("Movimientos de la cuenta ");
        for (Movimiento movimiento : getMovimientos()){
            System.out.println("Tipo: " + movimiento.getTipo());
            System.out.println("Cantidad: " + movimiento.getCantidad());
            System.out.println("Saldo anterior: " + movimiento.getSaldoAnterior());
            System.out.println("Saldo actual: " + movimiento.getSaldoActual());
            System.out.println("Fecha: " + movimiento.getFecha());
            System.out.println();
        }
    }

    public double consultarSaldo() {
        return getSaldo();
    }
}
