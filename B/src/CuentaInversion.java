import java.util.ArrayList;
import java.util.Date;

public class CuentaInversion extends CuentaBancaria {
    private ArrayList<Movimiento> movimientos;
    private int plazo;
    private double interes;

    public CuentaInversion(long numeroCuenta, double saldo, Date fechaAlta, Cliente cliente, int plazo, double interes){
        super(numeroCuenta, saldo, fechaAlta, cliente);
        this.movimientos = new ArrayList<>();
        this.plazo = plazo;
        this.interes = interes;
    }

    public void proyectarInversion(){
        double inversion = getSaldo() * plazo * (interes / 100);
        System.out.println("Inversión después de " + plazo + " meses: " + inversion);
    }

    public double getInteres() {
        return interes;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
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

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }
}
