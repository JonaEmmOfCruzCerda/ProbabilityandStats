import java.util.ArrayList;
import java.util.Scanner;

public class TestBiblioteca {
    static Scanner Lector = new Scanner(System.in);
    static ArrayList<Autor> autores = new ArrayList<>();
    static ArrayList<Editorial> editoriales = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();

    public static void main(String[] args) {
        autores.add(new Autor(1, "Jonathan", "DLCruz", "Cerda", "GDL"));
        autores.add(new Autor(2, "Andy", "Rojas", "Garcia", "GDL"));
        autores.add(new Autor(3, "Juan", "DLCruz", "Torres", "Zapopan"));
        editoriales.add(new Editorial(1, "Alfa-Omega", "Portucasa", "3312344", "MX"));
        editoriales.add(new Editorial(2, "Editorial Sur", "", "", ""));
        editoriales.add(new Editorial(3, "Editorial anagrama", "calle Formentor", "934960830", "Barcelona"));

        int op;
        int id;
        Autor a;
        Editorial e;

        do {
            System.out.println("1.- Agregar Autor");
            System.out.println("2.- Agregar Editorial");
            System.out.println("3.- Agregar Libro");
            System.out.println("4.- Buscar Autor");
            System.out.println("5.- Buscar Editorial");
            System.out.println("6.- Buscar Libro");
            System.out.println("7.- Modificar Autor");
            System.out.println("8.- Modificar Editorial");
            System.out.println("9.- Modificar Libro");
            System.out.println("10.- Eliminar Autor");
            System.out.println("11.- Eliminar Editorial");
            System.out.println("12.- Eliminar Libro");
            System.out.println("0.- Salir");
            System.out.print("Seleccione una opcion: ");
            op = Lector.nextInt();

            switch (op) {
                case 0:
                    System.out.println("Fin del programa...");
                    break;
                case 1:
                    System.out.println("------------------------");
                    System.out.println("Registrar un Autor");
                    System.out.println("------------------------");
                    a = registrarAutor();
                    if (a != null) {
                        autores.add(a);
                    }
                    System.out.println("------------------------");
                    break;
                case 2:
                    System.out.println("------------------------");
                    System.out.println("Registrar una Editorial");
                    System.out.println("------------------------");
                    e = registrarEditorial();
                    if (e != null) {
                        editoriales.add(e);
                    }
                    System.out.println("------------------------");
                    break;
                case 3:
                    System.out.println("------------------------");
                    System.out.println("Registrar Libro");
                    System.out.println("------------------------");
                    Libro libro = registrarLibro();
                    if(libro!=null){
                        System.out.println("Libro registrado correctamente");
                        libros.add(libro);
                    } else {
                        System.out.println("Hubo un error =(");
                    }
                    System.out.println("------------------------");
                    break;
                case 4:
                    System.out.println("------------------------");
                    System.out.println("Buscar Autor");
                    System.out.println("------------------------");
                    System.out.println("Ingresa el Id: ");
                    id = Lector.nextInt();
                    a = buscarAutor(id);
                    if (a == null) {
                        System.out.println("Autor no encontrado.");
                    }
                    System.out.println("------------------------");
                    break;
                case 5:
                    System.out.println("------------------------");
                    System.out.println("Buscar Editorial");
                    System.out.println("------------------------");
                    System.out.println("Ingresa el Id: ");
                    id = Lector.nextInt();
                    e = buscarEditorial(id);
                    if (e == null) {
                        System.out.println("Editorial no encontrado.");
                    }
                    System.out.println("------------------------");
                    break;
                case 6:
                    System.out.println("------------------------");
                    System.out.println("Buscar Libro");
                    System.out.println("------------------------");
                    System.out.println("Isbn: ");
                    Libro l = buscarLibro(Lector.nextInt());
                    if(l!=null){
                        System.out.println("Libro encontrado");
                    } else{
                        System.out.println("Libro no encontrado");
                    }
                    System.out.println("------------------------");
                    break;
                case 7:
                    System.out.println("------------------------");
                    System.out.println("Modificar Autor");
                    System.out.println("------------------------");
                    System.out.println("Ingresa el Id: ");
                    id = Lector.nextInt();
                    modificarAutor(id);
                    System.out.println("------------------------");
                    break;
                case 8:
                    System.out.println("------------------------");
                    System.out.println("Modificar Editorial");
                    System.out.println("------------------------");
                    System.out.println("Ingresa el Id: ");
                    id = Lector.nextInt();
                    modificarEditorial(id);
                    System.out.println("------------------------");
                    break;
                case 9:
                    System.out.println("------------------------");
                    System.out.println("Modificar Libro");
                    System.out.println("------------------------");
                    System.out.println("Ingrese el ISBN del libro que desea modificar: ");
                    int isbnModificar = Lector.nextInt();
                    modificarLibro(isbnModificar);
                    System.out.println("------------------------");
                    break;
                case 10:
                    System.out.println("------------------------");
                    System.out.println("Eliminar Autor");
                    System.out.println("------------------------");
                    System.out.println("Ingresa el Id: ");
                    id = Lector.nextInt();
                    eliminarAutor(id);
                    System.out.println("------------------------");
                    break;
                case 11:
                    System.out.println("------------------------");
                    System.out.println("Eliminar Editorial");
                    System.out.println("------------------------");
                    System.out.println("Ingresa el Id: ");
                    id = Lector.nextInt();
                    eliminarEditorial(id);
                    System.out.println("------------------------");
                    break;
                case 12:
                    System.out.println("------------------------");
                    System.out.println("Eliminar Libro");
                    System.out.println("------------------------");
                    System.out.println("Ingrese el ISBN del libro que desea eliminar: ");
                    int isbnEliminar = Lector.nextInt();
                    eliminarLibro(isbnEliminar);
                    System.out.println("------------------------");
                    break;
            }
        } while (op != 0);
    }

    // Metodos para Autor
    public static Autor registrarAutor() {
        int id;
        String nombre;
        String aPaterno;
        String aMaterno;
        String ciudad;

        System.out.println("Ingresa el Id: ");
        id = Lector.nextInt();
        System.out.println("Ingresa el Nombre: ");
        nombre = Lector.next();
        System.out.println("Ingresa el Apellido Paterno: ");
        aPaterno = Lector.next();
        System.out.println("Ingresa el Apellido Materno: ");
        aMaterno = Lector.next();
        System.out.println("Ingresa el Ciudad: ");
        ciudad = Lector.next();
        return new Autor(id, nombre, aPaterno, aMaterno, ciudad);
    }
    public static Autor buscarAutor(int id) {
        for (Autor a : autores) {
            if (a.getId() == id) {
                System.out.println("--------------------------------------");
                System.out.println("Nombre: " + a.getNombre());
                System.out.println("Apellido Paterno: " + a.getaPaterno());
                System.out.println("Apellido Materno: " + a.getaMaterno());
                System.out.println("Ciudad: " + a.getCiudad());
                System.out.println("--------------------------------------");
                return a;
            }
        }
        return null;
    }
    public static void modificarAutor(int id) {
        String nombre;
        String aPaterno;
        String aMaterno;
        String ciudad;

        Autor a = buscarAutor(id);

        if (a != null) {
            System.out.println("Ingresa el Nombre: ");
            nombre = Lector.next();
            a.setNombre(nombre);
            System.out.println("Ingresa el Apellido Paterno: ");
            aPaterno = Lector.next();
            a.setaPaterno(aPaterno);
            System.out.println("Ingresa el Apellido Materno: ");
            aMaterno = Lector.next();
            a.setaMaterno(aMaterno);
            System.out.println("Ingresa la Ciudad: ");
            ciudad = Lector.next();
            a.setCiudad(ciudad);
            System.out.println("Autor modificado correctamente");
        } else {
            System.out.println("Autor no encontrado");
        }
    }
    public static void eliminarAutor(int id) {
        Autor a = buscarAutor(id);
        if (a != null) {
            autores.remove(a);
            System.out.println("Autor eliminado.");
        } else {
            System.out.println("Autor no encontrado.");
        }
    }
    // Metodos para Editorial
    public static Editorial registrarEditorial() {
        int id;
        String nombre;
        String direccion;
        String telefono;
        String ciudad;

        System.out.println("Ingresa el Id: ");
        id = Lector.nextInt();
        System.out.println("Ingresa el Nombre: ");
        nombre = Lector.next();
        System.out.println("Ingresa la Direccion: ");
        direccion = Lector.next();
        System.out.println("Ingresa el Telefono: ");
        telefono = Lector.next();
        System.out.println("Ingresa el Ciudad: ");
        ciudad = Lector.next();
        return new Editorial(id, nombre, direccion, telefono, ciudad);
    }
    public static Editorial buscarEditorial(int id) {
        for (Editorial e : editoriales) {
            if (e.getId() == id) {
                System.out.println("--------------------------------------");
                System.out.println("Nombre: " + e.getNombre());
                System.out.println("Direccion: " + e.getDireccion());
                System.out.println("Telofono: " + e.getTelefono());
                System.out.println("Ciudad: " + e.getCiudad());
                System.out.println("--------------------------------------");
                return e;
            }
        }
        return null;
    }
    public static Editorial modificarEditorial(int id) {
        String nombre;
        String direccion;
        String telefono;
        String ciudad;

        Editorial e = buscarEditorial(id);

        if (e != null) {
            System.out.println("Ingresa el Nombre: ");
            nombre = Lector.next();
            e.setNombre(nombre);
            System.out.println("Ingresa la Dirección: ");
            direccion = Lector.next();
            e.setDireccion(direccion);
            System.out.println("Ingresa el Teléfono: ");
            telefono = Lector.next();
            e.setTelefono(telefono);
            System.out.println("Ingresa la Ciudad: ");
            ciudad = Lector.next();
            e.setCiudad(ciudad);
            System.out.println("Editorial modificada correctamente");
            return e;
        } else {
            System.out.println("Editorial no encontrada");
            return null;
        }
    }
    public static void eliminarEditorial(int id) {
        Editorial e = buscarEditorial(id);
        if (e != null) {
            editoriales.remove(e);
            System.out.println("Editorial eliminada.");
        } else {
            System.out.println("Editorial no encontrada.");
        }
    }
    // Metodos para Libro
    public static Libro registrarLibro(){
        int isbn;
        String titulo;
        String edicion;
        String genero;
        Editorial editorial = null;
        ArrayList<Autor> autores = new ArrayList<>();
        Scanner Lector = new Scanner(System.in);

        System.out.printf("Isbn: ");
        isbn = Lector.nextInt();
        System.out.printf("Titulo: ");
        titulo =  Lector.next();
        System.out.printf("Edicion: ");
        edicion = Lector.next();
        System.out.printf("Genero: ");
        genero = Lector.next();

        while (editorial == null) {
            System.out.printf("Id de la Editorial: ");
            int idEditorial = Lector.nextInt();
            editorial = buscarEditorial(idEditorial);
            if (editorial == null) {
                System.out.println("ID de la Editorial no encontrado. Por favor, ingresa un nuevo ID.");
            }
        }

        int op=0;
        Autor a;
        do{
            System.out.println("1.- Agregar Autor");
            System.out.println("2.- Quitar Autor");
            System.out.println("3.- Finalizar");
            System.out.printf("Seleccionar opcion: ");
            op = Lector.nextInt();

            if(op==1){
                a = null;
                while (a == null) {
                    System.out.println("Id del autor a agregar: ");
                    a = buscarAutor(Lector.nextInt());
                    if(a == null){
                        System.out.println("ID del Autor no encontrado");
                    } else {
                        autores.add(a);
                    }
                }
            } else if(op==2){
                if(autores.isEmpty()){
                    System.out.println("No hay autores para quitar.");
                } else {
                    a = null;
                    while (a == null) {
                        System.out.println("Id del autor a quitar: ");
                        int idAutor = Lector.nextInt();
                        for(Autor autor : autores){
                            if(autor.getId() == idAutor){
                                a = autor;
                                break;
                            }
                        }
                        if(a == null){
                            System.out.println("ID del Autor no encontrado");
                        } else {
                            autores.remove(a);
                        }
                    }
                }
            }
        } while (op!=3);
        return new Libro(isbn, titulo, edicion, genero, editorial, autores);
    }
    public static Libro buscarLibro(int isbn){
        for(Libro l: libros){
            if(l.getIsbn() == isbn){
                System.out.println("--------------------------------------");
                System.out.println("Titulo: " + l.getTitulo());
                System.out.println("Edicion: " + l.getEdicion());
                System.out.println("Genero: " + l.getGenero());
                System.out.println("Editorial: " + l.getEditorial().getNombre());
                for(Autor autor : l.getAutores()){
                    System.out.println("Nombre: " +autor.getNombre());
                    System.out.println("A. Paterno: " +autor.getaPaterno());
                }
                System.out.println("--------------------------------------");
                return l;
            }
        }
        return null;
    }
    public static void modificarLibro(int isbn) {
        Libro libro = buscarLibro(isbn);
        if (libro != null) {
            System.out.println("Ingrese el título: ");
            String nuevoTitulo = Lector.next();
            libro.setTitulo(nuevoTitulo);

            System.out.println("Ingrese la edición: ");
            String nuevaEdicion = Lector.next();
            libro.setEdicion(nuevaEdicion);

            System.out.println("Ingrese el género: ");
            String nuevoGenero = Lector.next();
            libro.setGenero(nuevoGenero);

            System.out.println("Ingrese el nuevo id de la editorial: ");
            int idEditorial = Lector.nextInt();
            Editorial editorial = buscarEditorial(idEditorial);
            if(editorial != null){
                libro.setEditorial(editorial);
            } else {
                System.out.println("Editorial no encontrada.");
            }

            System.out.println("Ingrese el id de los autores ingrese 0 para terminar: ");
            ArrayList<Autor> nuevosAutores = new ArrayList<>();
            int idAutor = Lector.nextInt();
            while(idAutor != 0){
                Autor autor = buscarAutor(idAutor);
                if(autor != null){
                    nuevosAutores.add(autor);
                } else {
                    System.out.println("Autor con id " + idAutor + " no encontrado.");
                }
                idAutor = Lector.nextInt();
            }
            libro.setAutores(nuevosAutores);

            System.out.println("Libro modificado correctamente");
        } else {
            System.out.println("Libro no encontrado");
        }
    }
    public static void eliminarLibro(int isbn) {
        Libro libro = buscarLibro(isbn);
        if (libro != null) {
            libros.remove(libro);
            System.out.println("Libro eliminado.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
}