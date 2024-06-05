import java.util.Scanner;
public class TestFigura {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("------------- Menu -------------");
            System.out.println("1. Circulo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Pentagono");
            System.out.println("4. Triangulo");
            System.out.println("0. Salir");
            System.out.println("Ingrese una opcion: ");
            opcion = lector.nextInt();
            Figura figura = null;

            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                case 1:
                    System.out.println("Ingrese el radio del círculo:");
                    double radio = lector.nextDouble();
                    figura = new Circulo(0, 0, radio);
                    break;
                case 2:
                    System.out.println("Ingrese el lado del cuadrado:");
                    double lado = lector.nextDouble();
                    figura = new Cuadrado(0, 0, lado);
                    break;
                case 3:
                    System.out.println("Ingrese el lado del pentagono:");
                    lado = lector.nextDouble();
                    figura = new Pentagono(0, 0, lado);
                    break;
                case 4:
                    System.out.println("Ingrese el lado del triangulo:");
                    lado = lector.nextDouble();
                    figura = new Triangulo(0, 0, lado);
                    break;
            }
            if (figura != null) {
                System.out.println("Área: " + figura.area());
                System.out.println("Perímetro: " + figura.perimetro());
            }
        } while (opcion != 0);
    }
}