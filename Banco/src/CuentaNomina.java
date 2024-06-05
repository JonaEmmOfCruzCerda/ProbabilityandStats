import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class CuentaNomina extends CuentaBancaria {
    private ArrayList<Movimiento> movimientos;
    public CuentaNomina(long numeroCuenta, double saldo, Date fechaAlta, Cliente cliente) {
        super(numeroCuenta, saldo, fechaAlta, cliente);
        this.movimientos = new ArrayList<>();
    }
    public double depositar(double cantidad) {
        setSaldo(getSaldo() + cantidad);
        registrarMovimiento(cantidad, new Date(), "Depósito");
        return getSaldo();
    }
    public double retirar(double cantidad) throws SaldoInsuficienteException {
        if (cantidad <= getSaldo()) {
            setSaldo(getSaldo() - cantidad);
            registrarMovimiento(-cantidad, new Date(), "Retiro");
            return cantidad;
        } else {
            throw new SaldoInsuficienteException("Fondos Insuficientes");
        }
    }
    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }
    private void registrarMovimiento(double cantidad, Date fecha, String descripcion) {
        Movimiento movimiento = new Movimiento(cantidad, fecha, descripcion);
        movimientos.add(movimiento);
        try {
            double saldoAnterior = obtenerSaldoAnterior();
            FileWriter fw = new FileWriter(getNumeroCuenta() + ".txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Movimientos:");
            pw.println("Fecha: " + new SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.ENGLISH).format(fecha));
            pw.println("Saldo anterior: " + saldoAnterior);
            pw.println("Saldo actual: " + getSaldo());
            pw.println("Cantidad: " + cantidad);
            pw.println("Tipo: " + descripcion + "\n");
            pw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar el movimiento en el archivo" + e.getMessage());
        }
    }
    private double obtenerSaldoAnterior() {
        double saldoAnterior = 0;
        try {
            File archivo = new File(getNumeroCuenta() + ".txt");
            if (archivo.exists()) {
                Scanner scanner = new Scanner(archivo);
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    if (linea.startsWith("Saldo actual:")) {
                        saldoAnterior = Double.parseDouble(linea.substring(14).trim());
                        break;
                    }
                }
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
        return saldoAnterior;
    }
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n");
        return sb.toString();
    }
}
