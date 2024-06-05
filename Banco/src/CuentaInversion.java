import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CuentaInversion extends CuentaBancaria {
    private int plazo, interes;
    private double inversion;
    public CuentaInversion(long numeroCuenta, double saldo, Date fechaAlta, Cliente cliente, int plazo, int interes) {
        super(numeroCuenta, saldo, fechaAlta, cliente);
        this.plazo = plazo;
        this.interes = interes;
        proyectarInversion();
    }
    public int getPlazo() {
        return plazo;
    }
    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }
    public int getInteres() {
        return interes;
    }
    public void setInteres(int interes) {
        this.interes = interes;
    }
    public void proyectarInversion() {
        inversion = getSaldo() * plazo * ((double) interes / 100);
        System.out.println("Inversion después de " + plazo + " meses: " + inversion);
    }
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Número de cuenta: ").append(numeroCuenta).append("\n");
        sb.append("Saldo: ").append(saldo).append("\n");
        sb.append("Fecha de alta: ").append(formatter.format(fechaAlta)).append("\n");
        sb.append("Cliente: ").append(cliente).append("\n");
        sb.append("Plazo: ").append(plazo).append("\n");
        sb.append("Interés: ").append(interes).append("\n");
        sb.append("Inversión después de ").append(plazo).append(" meses: ").append(inversion).append("\n");
        sb.append("\n");
        return sb.toString();
    }
}