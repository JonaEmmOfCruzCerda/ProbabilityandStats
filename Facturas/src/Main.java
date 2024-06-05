import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Vendedor> vendedores = new ArrayList<>();
    static ArrayList<Producto> productos = new ArrayList<>();
    static int contadorFacturas = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cargar datos desde archivos
        cargarProductosDesdeArchivo("productos.txt");
        cargarVendedoresDesdeArchivo("vendedores.txt");

        int opc;
        do {
            System.out.println("------- Menu -------");
            System.out.println("1. Dar alta cliente");
            System.out.println("2. Dar alta vendedores");
            System.out.println("3. Dar alta productos");
            System.out.println("4. Realizar venta");
            System.out.println("5. Listar facturas de un cliente");
            System.out.println("6. Buscar vendedor y listar sus ventas");
            System.out.println("7. Salir");
            System.out.println("Seleccione una opcion: ");
            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    altaCliente(scanner);
                    break;
                case 2:
                    altaVendedor(scanner);
                    break;
                case 3:
                    altaProducto(scanner);
                    break;
                case 4:
                    realizarVenta(scanner);
                    break;
                case 5:
                    listarFacturasCliente(scanner);
                    break;
                case 6:
                    buscarVendedorYListarVentas(scanner);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
            }
        } while (opc != 7);

        scanner.close();
    }

    private static void altaCliente(Scanner scanner) {
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido paterno del cliente:");
        String apellidoPaterno = scanner.nextLine();
        System.out.println("Ingrese el apellido materno del cliente:");
        String apellidoMaterno = scanner.nextLine();
        System.out.println("Ingrese la fecha de nacimiento del cliente (dia mes año):");
        int dia = scanner.nextInt();
        int mes = scanner.nextInt();
        int anio = scanner.nextInt();
        Fecha fechaNacimiento = new Fecha(dia, mes, anio);
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.println("Ingrese el RFC del cliente:");
        String rfc = scanner.nextLine();
        System.out.println("Ingrese el domicilio del cliente:");
        String domicilio = scanner.nextLine();
        Cliente cliente = new Cliente(clientes.size() + 1, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, rfc, domicilio);
        clientes.add(cliente);
        System.out.println("Cliente agregado con éxito.");
    }

    private static void altaVendedor(Scanner scanner) {
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.println("Ingrese el nombre del vendedor:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido paterno del vendedor:");
        String apellidoPaterno = scanner.nextLine();
        System.out.println("Ingrese el apellido materno del vendedor:");
        String apellidoMaterno = scanner.nextLine();
        System.out.println("Ingrese la fecha de nacimiento del vendedor (dia mes año):");
        int dia = scanner.nextInt();
        int mes = scanner.nextInt();
        int anio = scanner.nextInt();
        Fecha fechaNacimiento = new Fecha(dia, mes, anio);
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.println("Ingrese el área del vendedor:");
        String area = scanner.nextLine();
        System.out.println("Ingrese el porcentaje de comisión del vendedor:");
        float porcentajeComision = scanner.nextFloat();
        System.out.println("Ingrese el sueldo base del vendedor:");
        int sueldoBase = scanner.nextInt();
        Vendedor vendedor = new Vendedor(vendedores.size() + 1, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, area, porcentajeComision, sueldoBase);
        vendedores.add(vendedor);
        System.out.println("Vendedor agregado con éxito.");

        // Ahora guardamos el vendedor en el archivo
        try {
            FileWriter fw = new FileWriter("vendedores.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(vendedor);
            pw.close();
            System.out.println("Vendedor guardado en archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar el vendedor en el archivo.");
        }
    }

    private static void altaProducto(Scanner scanner) {
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.println("Ingrese la descripción del producto:");
        String descripcion = scanner.nextLine();
        System.out.println("Ingrese el precio del producto:");
        float precio = scanner.nextFloat();

        // Ahora guardamos el producto en el archivo
        try {
            FileWriter fw = new FileWriter("productos.txt", true);
            PrintWriter pw = new PrintWriter(fw);

            Producto producto = new Producto(productos.size() + 1, descripcion, precio);
            productos.add(producto);

            pw.println(producto); // Utilizando la representación de cadena del producto
            pw.close();
            System.out.println("Producto guardado en archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar el producto en el archivo.");
        }
    }

    private static void realizarVenta(Scanner scanner) {
        System.out.println("Ingrese el ID del cliente:");
        int idCliente = scanner.nextInt();
        Cliente cliente = buscarClientePorID(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Ingrese el ID del vendedor:");
        int idVendedor = scanner.nextInt();
        Vendedor vendedor = buscarVendedorPorID(idVendedor);
        if (vendedor == null) {
            System.out.println("Vendedor no encontrado.");
            return;
        }

        Factura factura = new Factura(contadorFacturas++, new Fecha(14, 5, 2024), cliente, vendedor, 0, 0, 0);
        cliente.comprar(factura);
        System.out.println("Venta creada para el cliente " + cliente.getNombre() + " y el vendedor " + vendedor.getNombre() + ".");
        // Agregar la factura al vendedor
        vendedor.agregarFactura(factura);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese el ID del producto a agregar a la factura (o 0 para salir):");
            int idProducto = scanner.nextInt();
            if (idProducto == 0) {
                continuar = false;
            } else {
                Producto producto = Producto.buscar(idProducto);
                if (producto == null) {
                    System.out.println("Producto no encontrado.");
                } else {
                    factura.agregarProducto(producto);
                    System.out.println("Producto agregado a la factura: " + producto.getDescripcion());
                }
            }
        }
        System.out.println("¿Desea realizar más acciones o volver al menú principal? (1 para más acciones, 0 para volver al menú)");
        int opcion = scanner.nextInt();
        if (opcion == 0) {
            return;
        }
    }


    private static Cliente buscarClientePorID(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    private static void listarFacturasCliente(Scanner scanner) {
        System.out.println("Ingrese el ID del cliente:");
        int idCliente = scanner.nextInt();
        Cliente cliente = buscarClientePorID(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        ArrayList<Factura> facturas = cliente.getCompras();
        if (facturas.isEmpty()) {
            System.out.println("El cliente no tiene facturas registradas.");
        } else {
            System.out.println("Facturas del cliente " + cliente.getNombre() + ":");
            for (Factura factura : facturas) {
                System.out.println(factura);
            }
        }
    }

    private static void buscarVendedorYListarVentas(Scanner scanner) {
        System.out.println("Ingrese el ID del vendedor:");
        int idVendedor = scanner.nextInt();
        Vendedor vendedor = buscarVendedorPorID(idVendedor);
        if (vendedor == null) {
            System.out.println("Vendedor no encontrado.");
            return;
        }
        ArrayList<Factura> ventas = obtenerVentasDelVendedor(vendedor);
        if (ventas.isEmpty()) {
            System.out.println("El vendedor " + vendedor.getNombre() + " no tiene ventas registradas.");
        } else {
            System.out.println("Ventas del vendedor " + vendedor.getNombre() + ":");
            for (Factura venta : ventas) {
                System.out.println(venta);
            }
        }
    }

    private static Vendedor buscarVendedorPorID(int id) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getId() == id) {
                return vendedor;
            }
        }
        return null;
    }

    private static ArrayList<Factura> obtenerVentasDelVendedor(Vendedor vendedor) {
        ArrayList<Factura> ventas = new ArrayList<>();
        for (Cliente cliente : clientes) {
            for (Factura factura : cliente.getCompras()) {
                if (factura.getVendedor().equals(vendedor)) {
                    ventas.add(factura);
                }
            }
        }
        return ventas;
    }

    private static void cargarProductosDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0]);
                String descripcion = partes[1];
                float precio = Float.parseFloat(partes[2]);
                Producto.agregar(id, descripcion, precio);
            }
            System.out.println("Productos cargados correctamente desde el archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de productos: " + e.getMessage());
        }
    }

    private static void cargarVendedoresDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int id = 1;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 7) { // Verificar que haya al menos 7 elementos en la línea
                    String nombre = partes[0];
                    String apellidoPaterno = partes[1];
                    String apellidoMaterno = partes[2];
                    String[] fechaNacimiento = partes[3].split("/");
                    Fecha fecha = new Fecha(Integer.parseInt(fechaNacimiento[0]), Integer.parseInt(fechaNacimiento[1]), Integer.parseInt(fechaNacimiento[2]));
                    String area = partes[4];
                    float porcentajeComision = Float.parseFloat(partes[5]);
                    int sueldoBase = Integer.parseInt(partes[6]);
                    Vendedor vendedor = new Vendedor(id, nombre, apellidoPaterno, apellidoMaterno, fecha, area, porcentajeComision, sueldoBase);
                    vendedores.add(vendedor);
                    id++;
                } else {
                    System.out.println("La línea no tiene el formato esperado: " + linea);
                }
            }
            System.out.println("Vendedores cargados correctamente desde el archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de vendedores: " + e.getMessage());
        }
    }


    private static void guardarProductoEnArchivo(String nombreArchivo, Producto producto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write(producto.getId() + "," + producto.getDescripcion() + "," + producto.getPrecio() + "\n");
            System.out.println("Producto guardado en archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar el producto en el archivo: " + e.getMessage());
        }
    }
}
