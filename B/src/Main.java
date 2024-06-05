import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        ArrayList<CuentaNomina> cuentasNomina = new ArrayList<>();
        ArrayList<CuentaInversion> cuentasInversion = new ArrayList<>();

        int op;

        do {
            System.out.println();
            System.out.println("            Menu            ");
            System.out.println("1. Dar de alta cuenta de nomina");
            System.out.println("2. Dar de alta cuenta de inversion");
            System.out.println("3. Buscar cuenta");
            System.out.println("4. Listar cuentas de nomina");
            System.out.println("5. Listar cuentas de inversion");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            op = lector.nextInt();

            switch (op) {
                case 1:
                    darAltaCuentaNomina(lector, cuentasNomina);
                    break;
                case 2:
                    darAltaCuentaInversion(lector, cuentasInversion);
                    break;
                case 3:
                    buscarCuenta(lector, cuentasNomina, cuentasInversion);
                    break;
                case 4:
                    listarCuentaNomina(cuentasNomina);
                    break;
                case 5:
                    listarCuentaInversion(cuentasInversion);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
            }

        } while (op != 0);
    }

    private static void darAltaCuentaNomina(Scanner lector, ArrayList<CuentaNomina> cuentasNomina) {
        System.out.println();
        System.out.println("Ingrese los datos del cliente");
        System.out.print("Nombre: ");
        String nombre = lector.next();
        System.out.printf("Apellidos: ");
        String apellidos = lector.next();
        System.out.printf("Domicilio: ");
        String domicilio = lector.next();
        System.out.printf("Ciudad: ");
        String ciudad = lector.next();
        System.out.printf("Telefono: ");
        String telefono = lector.next();

        Cliente clienteNomina = new Cliente(nombre, apellidos, domicilio, ciudad, telefono);

        System.out.printf("Ingresa el numero de cuenta: ");
        long numeroCuenta = lector.nextLong();

        // Verificar si el número de cuenta ya existe
        boolean cuentaExistente = false;
        for (CuentaNomina cuenta : cuentasNomina) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                cuentaExistente = true;
                break;
            }
        }

        if (!cuentaExistente) {
            System.out.printf("Ingrese el saldo inicial: ");
            double saldo = lector.nextDouble();
            Date fechaAlta = new Date();
            CuentaNomina nuevaCuenta = new CuentaNomina(numeroCuenta, saldo, fechaAlta, clienteNomina);
            cuentasNomina.add(nuevaCuenta);
            System.out.println("Cuenta de nomina creada correctamente.");

            generarArchivoMovimientos(nuevaCuenta, "CuentasNomina.txt");
            generarArchivoMovimientos(nuevaCuenta, Long.toString(numeroCuenta) + ".txt");
        } else {
            System.out.println("Ya existe una cuenta con este número. Intente nuevamente.");
        }
    }

    private static void darAltaCuentaInversion(Scanner lector, ArrayList<CuentaInversion> cuentasInversion) {
        System.out.println();
        System.out.println("Ingrese los datos del cliente");
        System.out.print("Nombre: ");
        String nombre = lector.next();
        System.out.printf("Apellidos: ");
        String apellidos = lector.next();
        System.out.printf("Domicilio: ");
        String domicilio = lector.next();
        System.out.printf("Ciudad: ");
        String ciudad = lector.next();
        System.out.printf("Telefono: ");
        String telefono = lector.next();

        Cliente clienteInversion = new Cliente(nombre, apellidos, domicilio, ciudad, telefono);

        System.out.printf("Ingresa el numero de cuenta: ");
        long numeroCuenta = lector.nextLong();
        System.out.printf("Ingresa el saldo inicial: ");
        double saldo = lector.nextDouble();
        System.out.println("Ingresa el plazo de la inversion en meses: ");
        int plazo = lector.nextInt();
        System.out.println("Ingresa el interés de la inversión %: ");
        double interes = lector.nextDouble();

        Date fechaAlta = new Date();
        CuentaInversion nuevaCuenta = new CuentaInversion(numeroCuenta, saldo, fechaAlta, clienteInversion, plazo, interes);
        cuentasInversion.add(nuevaCuenta);
        System.out.println("Cuenta de inversion creada correctamente");

        generarArchivoMovimientos(nuevaCuenta, "CuentasInversion.txt");
        generarArchivoMovimientos(nuevaCuenta, Long.toString(numeroCuenta) + ".txt");

        nuevaCuenta.proyectarInversion();
    }

    private static void generarArchivoMovimientos(CuentaBancaria cuenta, String nombreArchivo){
        try {
            FileWriter writer = new FileWriter(nombreArchivo, true);
            writer.write("Numero de cuenta: "  + cuenta.getNumeroCuenta() + "\n");
            writer.write("Saldo: " + cuenta.getSaldo() + "\n");
            writer.write("Cliente: " + cuenta.getCliente()  + "\n");
            writer.write("Movimientos: \n");
            for (Movimiento movimiento : cuenta.getMovimientos()){
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fecha = dateFormat.format(movimiento.getFecha());
                writer.write("Tipo: " + movimiento.getTipo() + ", Cantidad: " + movimiento.getCantidad() +
                        ", Saldo Anterior: " + movimiento.getSaldoAnterior() + ", Saldo Actual: " +
                        movimiento.getSaldoActual() + ", Fecha: " + fecha + "\n");
            }
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void archivoMovimientosInversion(ArrayList<CuentaInversion> cuentasInversion) {
        try {
            for (CuentaInversion cuentaInversion : cuentasInversion) {
                String nombreArchivo = cuentaInversion.getNumeroCuenta() + ".txt";
                FileWriter writer = new FileWriter(nombreArchivo);
                writer.write("Cuenta de inversión:\n");
                writer.write("Numero de cuenta: " + cuentaInversion.getNumeroCuenta() + "\n");
                writer.write("Saldo: " + cuentaInversion.getSaldo() + "\n");
                writer.write("Plazo de inversión: " + cuentaInversion.getPlazo() + " meses\n");
                writer.write("Interés de inversión: " + cuentaInversion.getInteres() + "%\n");
                writer.write("Movimientos:\n");
                for (Movimiento movimiento : cuentaInversion.getMovimientos()) {
                    writer.write(movimiento + "\n");
                }
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void buscarCuenta(Scanner lector, ArrayList<CuentaNomina> cuentasNomina, ArrayList<CuentaInversion> cuentasInversion) {
        System.out.print("Ingrese el numero de cuenta: ");
        long numeroCuenta = lector.nextLong();
        boolean cuentaEncontrada = false;

        // Buscar en la lista de cuentas de nómina
        for (CuentaNomina cuentaNomina : cuentasNomina) {
            if (cuentaNomina.getNumeroCuenta() == numeroCuenta) {
                System.out.println("Cuenta de nomina encontrada ");
                System.out.println("Numero de cuenta: " + cuentaNomina.getNumeroCuenta());
                System.out.println("Saldo: " + cuentaNomina.getSaldo());
                System.out.println("Cliente: " + cuentaNomina.getCliente().getNombre() + " " + cuentaNomina.getCliente().getApellidos());
                cuentaEncontrada = true;
                mostrarSubMenuOperaciones(lector, cuentaNomina);
                break;
            }
        }
        if (!cuentaEncontrada) {
            for (CuentaInversion cuentaInversion : cuentasInversion) {
                if (cuentaInversion.getNumeroCuenta() == numeroCuenta) {
                    System.out.println("Cuenta de inversión encontrada:");
                    System.out.println("Número de cuenta: " + cuentaInversion.getNumeroCuenta());
                    System.out.println("Saldo: " + cuentaInversion.getSaldo());
                    System.out.println("Plazo de inversión: " + cuentaInversion.getPlazo() + " meses");
                    System.out.println("Interés de inversión: " + cuentaInversion.getInteres() + "%");
                    cuentaEncontrada = true;
                    break;
                }
            }
        }
        if (!cuentaEncontrada) {
            System.out.println("La cuenta no fue encontrada");
        }
    }

    private static void mostrarSubMenuOperaciones(Scanner lector, CuentaNomina cuentaNomina) {
        int op;
        do {
            System.out.println();
            System.out.println("            Submenú            ");
            System.out.println("1. Depósito");
            System.out.println("2. Retiro");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Imprimir Movimientos");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            op = lector.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double cantidadDeposito = lector.nextDouble();
                    cuentaNomina.depositar(cantidadDeposito);
                    System.out.println("Depósito realizado con éxito.");
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double cantidadRetiro = lector.nextDouble();
                    double cantidadRetirada = cuentaNomina.retirar(cantidadRetiro);
                    if (cantidadRetirada > 0) {
                        System.out.println("Retiro de " + cantidadRetirada + " realizado con éxito.");
                    }
                    break;
                case 3:
                    double saldo = cuentaNomina.consultarSaldo();
                    System.out.println("Saldo actual: " + saldo);
                    break;
                case 4:
                    cuentaNomina.imprimirMovimientos();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (op != 0);
    }


    private static void listarCuentaNomina(ArrayList<CuentaNomina> cuentasNomina) {
        System.out.println();
        System.out.println("Listado de cuentas de nomina");
        for (CuentaNomina cuenta : cuentasNomina) {
            System.out.println("Numero de cuenta: " + cuenta.getNumeroCuenta());
            System.out.println("Saldo: " + cuenta.getSaldo());
            System.out.println("Cliente: " + cuenta.getCliente().getNombre() + " " + cuenta.getCliente().getApellidos());
            System.out.println();
        }
    }

    private static void listarCuentaInversion(ArrayList<CuentaInversion> cuentasInversion) {
        System.out.println();
        System.out.println("Listado de cuentas de inversión:");
        for (CuentaInversion cuenta : cuentasInversion) {
            System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
            System.out.println("Saldo: " + cuenta.getSaldo());
            System.out.println("Plazo de inversión: " + cuenta.getPlazo() + " meses");
            System.out.println("Interés de inversión: " + cuenta.getInteres() + "%");
            System.out.println();
        }
    }
}
