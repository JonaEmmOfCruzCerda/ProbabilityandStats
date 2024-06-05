import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner lector = new Scanner(System.in);
    static ArrayList<CuentaNomina> cuentaNominas = new ArrayList<>();
    static ArrayList<CuentaInversion> cuentaInversiones = new ArrayList<>();
    public static void main(String[] args) {
        leerArchivo("CuentasNominas.txt", cuentaNominas);
        leerArchivoInversion("CuentasInversiones.txt", cuentaInversiones);
        int op;
        do {
            System.out.println();
            System.out.println("            Menu            ");
            System.out.println("1. Dar de alta cuenta de nomina");
            System.out.println("2. Dar de alta cuenta de inversion");
            System.out.println("3. Buscar cuenta");
            System.out.println("4. Listar cuentas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            op = lector.nextInt();
            switch (op) {
                case 1:
                    darAltaCuentaNomina(lector, cuentaNominas);
                    break;
                case 2:
                    darAltaCuentaInversion(lector, cuentaInversiones);
                    break;
                case 3:
                    buscarCuenta(lector, cuentaNominas, cuentaInversiones);
                    break;
                case 4:
                    listarCuentas(cuentaNominas, cuentaInversiones);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (op != 0);
    }
    public static void leerArchivo(String nombreArchivo, ArrayList<CuentaNomina> cuentaNominas) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Numero de cuenta:")) {
                    long numeroCuenta = Long.parseLong(linea.split(": ")[1]);
                    double saldo = Double.parseDouble(br.readLine().split(": ")[1]);
                    Date fechaAlta = new SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.ENGLISH).parse(br.readLine().split(": ")[1]);
                    String clienteLine = br.readLine();
                    String[] datosCliente = clienteLine.split(": ")[1].split(", ");
                    String nombre = "", apellidos = "", domicilio = "", ciudad = "", telefono = "";
                    if (datosCliente.length >= 1) { nombre = datosCliente[0];}
                    if (datosCliente.length >= 2) { apellidos = datosCliente[1]; }
                    if (datosCliente.length >= 3) { domicilio = datosCliente[2]; }
                    if (datosCliente.length >= 4) { ciudad = datosCliente[3]; }
                    if (datosCliente.length >= 5) { telefono = datosCliente[4]; }
                    Cliente cliente = new Cliente(nombre, apellidos, domicilio, ciudad, telefono);
                    CuentaNomina cuentaNomina = new CuentaNomina(numeroCuenta, saldo, fechaAlta, cliente);
                    cuentaNominas.add(cuentaNomina);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    public static void leerArchivoInversion(String nombreArchivo, ArrayList<CuentaInversion> cuentaInversiones) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Número de cuenta:")) {
                    long numeroCuenta = Long.parseLong(linea.split(": ")[1]);
                    double saldo = Double.parseDouble(br.readLine().split(": ")[1]);
                    Date fechaAlta = new SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.ENGLISH).parse(br.readLine().split(": ")[1]);
                    String clienteLine = br.readLine();
                    String[] datosCliente = clienteLine.split(": ")[1].split(", ");
                    String nombre = "", apellidos = "", domicilio = "", ciudad = "", telefono = "";
                    if (datosCliente.length >= 1) { nombre = datosCliente[0]; }
                    if (datosCliente.length >= 2) { apellidos = datosCliente[1]; }
                    if (datosCliente.length >= 3) { domicilio = datosCliente[2];}
                    if (datosCliente.length >= 4) { ciudad = datosCliente[3]; }
                    if (datosCliente.length >= 5) { telefono = datosCliente[4]; }
                    Cliente cliente = new Cliente(nombre, apellidos, domicilio, ciudad, telefono);
                    int plazo = Integer.parseInt(br.readLine().split(": ")[1]);
                    int interes = Integer.parseInt(br.readLine().split(": ")[1]);
                    CuentaInversion cuentaInversion = new CuentaInversion(numeroCuenta, saldo, fechaAlta, cliente, plazo, interes);
                    boolean cuentaRepetida = cuentaInversiones.stream().anyMatch(c -> c.getNumeroCuenta() == numeroCuenta);
                    if (!cuentaRepetida) {
                        cuentaInversiones.add(cuentaInversion);
                    } else {
                        System.out.println("La cuenta de inversión con número de cuenta " + numeroCuenta + " ya existe.");
                    }
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void darAltaCuentaNomina(Scanner lector, ArrayList<CuentaNomina> cuentaNominas) {
        boolean cuentaExiste;
        do {
            cuentaExiste = false;
            System.out.println("Dar de alta Cuenta Nomina");
            System.out.print("Numero de cuenta: ");
            long numeroCuenta = lector.nextLong();
            for (CuentaNomina cuenta : cuentaNominas) {
                if (cuenta.getNumeroCuenta() == numeroCuenta) {
                    cuentaExiste = true;
                    System.out.println("El número de cuenta ya está en uso");
                    break;
                }
            }

            if (!cuentaExiste) {
                System.out.print("Nombre: ");
                String nombre = lector.next();
                System.out.print("Apellidos: ");
                String apellidos = lector.next();
                System.out.print("Domicilio: ");
                String domicilio = lector.next();
                System.out.print("Ciudad: ");
                String ciudad = lector.next();
                System.out.print("Telefono: ");
                String telefono = lector.next();

                Cliente cliente = new Cliente(nombre, apellidos, domicilio, ciudad, telefono);

                System.out.print("Saldo inicial: ");
                double saldo = lector.nextDouble();

                Date fechaAlta = new Date();

                CuentaNomina cuentaNomina = new CuentaNomina(numeroCuenta, saldo, fechaAlta, cliente);
                cuentaNominas.add(cuentaNomina);
                try {
                    FileWriter fw = new FileWriter("CuentasNominas.txt", true);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(cuentaNomina);
                    pw.close();
                    System.out.println("Cuenta de nómina creada exitosamente");
                } catch (IOException e) {
                    System.out.println("Error al guardar la cuenta de nómina: " + e.getMessage());
                }
            }
        } while (cuentaExiste);
    }

    private static void darAltaCuentaInversion(Scanner lector, ArrayList<CuentaInversion> cuentaInversiones) {
        boolean cuentaExiste;
        do {
            cuentaExiste = false;
            System.out.println("Ingrese los datos del cliente:");
            System.out.print("Número de cuenta: ");
            long numeroCuenta = lector.nextLong();
            for (CuentaInversion cuenta : cuentaInversiones) {
                if (cuenta.getNumeroCuenta() == numeroCuenta) {
                    cuentaExiste = true;
                    System.out.println("El número de cuenta ya está en uso");
                    break;
                }
            }
            if (!cuentaExiste) {
                System.out.print("Nombre: ");
                String nombre = lector.next();
                System.out.print("Apellidos: ");
                String apellidos = lector.next();
                System.out.print("Domicilio: ");
                String domicilio = lector.next();
                System.out.print("Ciudad: ");
                String ciudad = lector.next();
                System.out.print("Telefono: ");
                String telefono = lector.next();

                Cliente cliente = new Cliente(nombre, apellidos, domicilio, ciudad, telefono);

                System.out.print("Saldo inicial: ");
                double saldo = lector.nextDouble();
                System.out.print("Plazo de inversión (en meses): ");
                int plazo = lector.nextInt();
                System.out.print("Interés (%): ");
                int interes = lector.nextInt();

                Date fechaAlta = new Date();

                CuentaInversion cuentaInversion = new CuentaInversion(numeroCuenta, saldo, fechaAlta, cliente, plazo, interes);
                cuentaInversiones.add(cuentaInversion);
                try {
                    FileWriter fw = new FileWriter("CuentasInversiones.txt", true);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(cuentaInversion);
                    pw.close();
                    System.out.println("Cuenta de inversión creada exitosamente.");
                } catch (IOException e) {
                    System.out.println("Error al guardar la cuenta de inversión en el archivo.");
                }
            }
        } while (cuentaExiste);
    }

    private static void buscarCuenta(Scanner lector, ArrayList<CuentaNomina> cuentaNominas, ArrayList<CuentaInversion> cuentaInversiones) {
        System.out.print("Ingrese el número de cuenta: ");
        long numeroCuenta = lector.nextLong();
        boolean found = false;
        for (CuentaNomina cuentaNomina : cuentaNominas) {
            if (cuentaNomina.getNumeroCuenta() == numeroCuenta) {
                found = true;
                System.out.println("Cuenta de nómina encontrada");
                System.out.println(cuentaNomina);
                System.out.println("         Submenu            ");
                System.out.println("1. Depositar");
                System.out.println("2. Retirar");
                System.out.println("3. Consultar saldo");
                System.out.println("4. Imprimir movimientos");
                System.out.println("5. Salir");
                int opc;
                do {
                    System.out.print("Seleccione una opcion: ");
                    opc = lector.nextInt();
                    switch (opc) {
                        case 1:
                            System.out.print("Ingrese la cantidad a depositar: ");
                            double cantidad = lector.nextDouble();
                            cuentaNomina.depositar(cantidad);
                            break;
                        case 2:
                            System.out.print("Ingrese la cantidad a retirar: ");
                            cantidad = lector.nextDouble();
                            try {
                                cuentaNomina.retirar(cantidad);
                            } catch (SaldoInsuficienteException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 3:
                            System.out.println("Saldo actual: " + cuentaNomina.getSaldo());
                            break;
                        case 4:
                            System.out.println("Movimientos:");
                            for (Movimiento movimiento : cuentaNomina.getMovimientos()) {
                                System.out.println(movimiento);
                            }
                            break;
                        case 5:
                            System.out.println("Saliendo del submenu...");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                } while (opc != 5);
                break;
            }
        }
        if (!found) {
            for (CuentaNomina cuentaNomina : cuentaNominas) {
                if (cuentaNomina.getNumeroCuenta() == numeroCuenta) {
                    found = true;
                    System.out.println("Cuenta de nómina encontrada");
                    System.out.println(cuentaNomina);
                    System.out.println("Movimientos:");
                    for (Movimiento movimiento : cuentaNomina.getMovimientos()) {
                        System.out.println(movimiento);
                    }
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Cuenta no encontrada.");
        }
    }

    private static void listarCuentas(ArrayList<CuentaNomina> cuentaNominas, ArrayList<CuentaInversion> cuentaInversiones) {
        System.out.println("Cuentas de nómina:");
        System.out.println();
        for (CuentaNomina cuentaNomina : cuentaNominas) {
            System.out.println("Número de cuenta: " + cuentaNomina.getNumeroCuenta());
            System.out.println("Saldo: " + cuentaNomina.getSaldo());
            System.out.println("Fecha de alta: " + cuentaNomina.getFechaAlta());
            System.out.println("Cliente: " + cuentaNomina.getCliente());
            System.out.println();
        }
        System.out.println("Cuentas de inversión:");
        System.out.println();
        for (CuentaInversion cuentaInversion : cuentaInversiones) {
            System.out.println("Número de cuenta: " + cuentaInversion.getNumeroCuenta());
            System.out.println("Saldo: " + cuentaInversion.getSaldo());
            System.out.println("Fecha de alta: " + cuentaInversion.getFechaAlta());
            System.out.println("Cliente: " + cuentaInversion.getCliente());
            System.out.println();
        }
    }
}