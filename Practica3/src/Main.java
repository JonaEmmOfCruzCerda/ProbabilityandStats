import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner Lector = new Scanner(System.in);
    static ArrayList<Persona> personas = new ArrayList<>();
    public static void main(String[] args) {
        cargarArchivo();
        int op;
        do {
            System.out.println();
            System.out.println("            Menu            ");
            System.out.println("1. Agregar");
            System.out.println("2. Buscar");
            System.out.println("3. Eliminar");
            System.out.println("4. Modificar");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            op = Lector.nextInt();

            switch (op) {
                case 1:
                    agregarPersonas();
                    break;
                case 2:
                    buscarPersonas();
                    break;
                case 3:
                    eliminarPersonas();
                    break;
                case 4:
                    modificarPersonas();
                    break;
                case 5:
                    guardarEnArchivo();
                    System.out.println("Datos guardados en el archivo ");
                    break;
            }
        } while (op != 5);
    }
    private static void cargarArchivo(){
       try {
           File archivo = new File("personas.txt");
           Scanner S = new Scanner(archivo);

           while (S.hasNextLine()){
               String[] datos = S.nextLine().split(",");
               int id = Integer.parseInt(datos[0]);
               String nombre = datos[1];
               String apellidoP = datos[2];
               String apellidoM = datos[3];
               String ciudad = datos[4];
               personas.add(new Persona(id, nombre, apellidoP, apellidoM, ciudad));
           }
           S.close();
       } catch (FileNotFoundException e) {
           System.out.println("Archivo no encontrado" + e.getMessage());
       }
    }
    private static void agregarPersonas() {
        System.out.println("Ingresa el Id: ");
        int id = Lector.nextInt();
        System.out.println("Ingresa el Nombre: ");
        String nombre = Lector.next();
        System.out.println("Ingresa el Apellido Paterno: ");
        String apellidoP = Lector.next();
        System.out.println("Ingresa el Apellido Materno: ");
        String apellidoM = Lector.next();
        System.out.println("Ingresa la Ciudad: ");
        String ciudad = Lector.next();

        Persona nP = new Persona(id, nombre, apellidoP, apellidoM, ciudad);
        personas.add(nP);
        System.out.println("Persona agregada correctamente");
    }
    private static void buscarPersonas() {
        System.out.println("Ingresa el Id: ");
        int idB = Lector.nextInt();
        boolean encontrado = false;
        for (Persona persona : personas) {
            if (persona.getId() == idB) {
                encontrado = true;
                System.out.println("     Persona encontrada     ");
                System.out.println("Id: " + persona.getId());
                System.out.println("Nombre: " + persona.getNombre());
                System.out.println("Apellido Paterno: " + persona.getApellidoP());
                System.out.println("Apellido Materno: " + persona.getApellidoM());
                System.out.println("Ciudad: " + persona.getCiudad());
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Persona no encontrada");
        }
    }
    private static void eliminarPersonas() {
        System.out.println("Ingresa el Id: ");
        int idE = Lector.nextInt();
        boolean eliminar = false;
        for (Persona persona : personas) {
            if (persona.getId() == idE) {
                personas.remove(persona);
                eliminar = true;
                System.out.println("Persona eliminada correctamente");
                break;
            }
        }
        if (!eliminar) {
            System.out.println("Persona no encontrada");
        }
    }
    private static void modificarPersonas() {
        System.out.println("Ingresa el Id: ");
        int idM = Lector.nextInt();
        boolean modificar = false;
        for (Persona persona : personas) {
            if (persona.getId() == idM) {
                System.out.println("Ingrese el Nombre: ");
                String nNombre = Lector.next();
                System.out.println("Ingrese el Apellido Paterno: ");
                String nApellidoP = Lector.next();
                System.out.println("Ingrese el Apellido Materno: ");
                String nApellidoM = Lector.next();
                System.out.println("Ingrese la Ciudad: ");
                String nCiudad = Lector.next();

                persona.setNombre(nNombre);
                persona.setApellidoP(nApellidoP);
                persona.setApellidoM(nApellidoM);
                persona.setCiudad(nCiudad);

                modificar = true;
                System.out.println("Persona modificada correctamente");
                break;
            }
        }
        if (!modificar) {
            System.out.println("Persona no encontrada");
        }
    }
    private static void guardarEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("personas.txt"))) {
            for (Persona persona : personas) {
                writer.write(persona.getId() + "," + persona.getNombre() + "," +
                        persona.getApellidoP() + "," + persona.getApellidoM() + "," +
                        persona.getCiudad());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }
}