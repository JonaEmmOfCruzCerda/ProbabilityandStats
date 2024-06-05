import java.util.ArrayList;
import java.util.Scanner;

public class TestSeleccion {
    public static void main(String[] args){
        Scanner Lector = new Scanner(System.in);
        ArrayList<SeleccionFutbol> Seleccion = new ArrayList<>();

        Seleccion.add(new Futbolista(1, "Jonathan", "OfCruz", 19, 12, "Delantero"));
        Seleccion.add(new Entrenador(1, "Juan", "OfCruz", 42, "01"));
        Seleccion.add(new Masajista(1, "Erika", "Alejandre", 40, "Masajista", 1));
        int op;

        do{
            System.out.println("1- Agregar un Futbolista");
            System.out.println("2- Agregar un Entrenador");
            System.out.println("3- Agregar un Masajista");
            System.out.println("4- Buscar: ");
            System.out.println("0- Salir");
            System.out.println("Seleccione una opcion: ");
            op = Lector.nextInt();

            switch (op){
                case 0:
                    System.out.println("Fin del programa...");
                    break;
                case 1:
                    agregarFutbolista(Seleccion);
                    break;
                case 2:
                    agregarEntrenador(Seleccion);
                    break;
                case 3:
                    agregarMasajista(Seleccion);
                    break;
                case 4:
                    int id;
                    System.out.println("Ingresa el id: ");
                    id=Lector.nextInt();
                    buscar(Seleccion,id);
                    break;
            }

        } while(op != 0);
    }
    public static void agregarFutbolista(ArrayList<SeleccionFutbol> Seleccion){
        String Nombre, Apellidos, posicion;
        int id, Edad, dorsal;

        Scanner s = new Scanner(System.in);

        System.out.println("Ingresa el id: ");
        id = s.nextInt();
        s.nextLine();
        System.out.println("Ingresa el Nombre: ");
        Nombre = s.nextLine();
        System.out.println("Ingresa el Apellido: ");
        Apellidos = s.nextLine();
        System.out.println("Ingresa la edad: ");
        Edad = s.nextInt();
        System.out.println("Ingresa el dorsal: ");
        dorsal = s.nextInt();
        s.nextLine();
        System.out.println("Ingresa la posicion: ");
        posicion = s.nextLine();

        Futbolista futbolista = new Futbolista(id, Nombre, Apellidos, Edad, dorsal, posicion);
        Seleccion.add(futbolista);
    }
    public static void agregarEntrenador(ArrayList<SeleccionFutbol> Seleccion){
        int id, Edad;
        String Nombre, Apellidos, idFederacion;
        Scanner s = new  Scanner(System.in);

        System.out.println("Ingresa id: ");
        id = s.nextInt();
        s.nextLine();
        System.out.println("Ingresa el Nombre: ");
        Nombre = s.nextLine();
        System.out.println("Ingresa el Apellido: ");
        Apellidos = s.nextLine();
        System.out.println("Ingresa la edad: ");
        Edad = s.nextInt();
        s.nextLine();
        System.out.println("Ingresa el id de la Federacion: ");
        idFederacion = s.nextLine();

        Entrenador entrenador = new Entrenador(id, Nombre, Apellidos, Edad, idFederacion);
        Seleccion.add(entrenador);
    }
    public static void agregarMasajista(ArrayList<SeleccionFutbol> Seleccion){
        int id, Edad, aniosExperiencia;
        String Nombre, Apellidos, Titulacion;

        Scanner s = new Scanner(System.in);

        System.out.println("Ingresar id: ");
        id = s.nextInt();
        s.nextLine(); // Consumir el salto de línea
        System.out.println("Ingresa el Nombre: ");
        Nombre = s.nextLine();
        System.out.println("Ingresa el Apellido: ");
        Apellidos = s.nextLine();
        System.out.println("Ingresa la edad: ");
        Edad = s.nextInt();
        s.nextLine();
        System.out.println("Ingresa la Titulacion: ");
        Titulacion = s.nextLine();
        System.out.println("Ingresa los anios de Experiencia: ");
        aniosExperiencia = s.nextInt();

        Masajista masajista = new Masajista(id, Nombre, Apellidos, Edad, Titulacion, aniosExperiencia);
        Seleccion.add(masajista);
    }
    public static void buscar(ArrayList<SeleccionFutbol> Seleccion, int id){
        for(SeleccionFutbol integrante: Seleccion) {
            if (id == integrante.getId()) {
                if (integrante instanceof Entrenador) {
                    ((Entrenador) integrante).dirigirPartido();
                    ((Entrenador) integrante).dirigirEntreno();
                } else {
                    if (integrante instanceof Futbolista) {
                        ((Futbolista) integrante).jugarPartido();
                        ((Futbolista) integrante).entrenar();
                    } else {
                        if (integrante instanceof Masajista) {
                            ((Masajista) integrante).darMasaje();
                        }
                    }
                }
            }
        }
    }
}
