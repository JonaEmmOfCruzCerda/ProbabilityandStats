import java.util.Scanner;

public class TestCiclos {

    public static void main(String[] args) {

        Scanner Lector = new Scanner(System.in);
        Ciclos ciclos = new Ciclos();
        int op;

        do {
            System.out.println("------- Menu -------");
            System.out.println("1. Sumatoria del 1 al 10.");
            System.out.println("2. Sumatoria de multiplos de 5.");
            System.out.println("3. Imprimir la tabla de multiplicar de N");
            System.out.println("4. Imprimir los primeros N números primos.");
            System.out.println("5. Calcular la factorial de un número entero positivo.");
            System.out.println("6. Mostrar en pantalla los primeros N números impares.");
            System.out.println("7. Determinar si un numero dado por el usuario es o no perfecto.");
            System.out.println("8. Dados dos números por el usuario determinar si son o no números amigos.");
            System.out.println("9. Elevar un numero N a una potencia P.");
            System.out.println("10. Calcular el valor de e^x y el factorial de todo número.");
            System.out.println("Seleccione una opcion: ");
            op = Lector.nextInt();

            switch (op) {
                case 0:
                    System.out.println("Fin del programa...");
                    break;
                case 1:
                    System.out.println("La sumatoria es: " + ciclos.sumatoria10());
                    break;
                case 2:
                    System.out.println("= " + ciclos.sumatoriaDe5());
                    break;
                case 3:
                    System.out.println("Por favor, ingresa el valor de N:");
                    int num = Lector.nextInt();
                    ciclos.tablaDeMultiplicar(num);
                    break;
                case 4:
                    System.out.println("Por favor, ingresa el valor de N:");
                    int numP = Lector.nextInt();
                    ciclos.numerosPrimos(numP);
                case 5:
                    System.out.println("Ingrese un numero para calcular su factorial: ");
                    int numFactorial = Lector.nextInt();
                    System.out.println("La factorial de: " + numFactorial +" es: " +ciclos.factorial(numFactorial));
                    break;
                case 6:
                    System.out.println("Ingrese un número: ");
                    int numI = Lector.nextInt();
                    ciclos.numeroImpar(numI);
                    break;
                case 7:
                    System.out.println("Ingrese un número: ");
                    num = Lector.nextInt();
                    if (ciclos.numeroPerfecto(num)) {
                        System.out.println("El número " + num + " es perfecto.");
                    } else {
                        System.out.println("El número " + num + " no es perfecto.");
                    }
                    break;
                case 8:
                    System.out.println("Ingrese el primer número: ");
                    int num1 = Lector.nextInt();
                    System.out.println("Ingrese el segundo número: ");
                    int num2 = Lector.nextInt();
                    if (ciclos.numerosAmigos(num1, num2)) {
                        System.out.println("Los números " + num1 + " y " + num2 + " son amigos.");
                    } else {
                        System.out.println("Los números " + num1 + " y " + num2 + " no son amigos.");
                    }
                    break;
                case 9:
                    System.out.println("Ingrese el valor de N:");
                    int N = Lector.nextInt();
                    System.out.println("Ingrese el valor de P:");
                    int P = Lector.nextInt();
                    int resultado = ciclos.elevar(N, P);
                    System.out.println("El resultado de elevar " + N + " a la potencia " + P + " es: " + resultado);
                    break;
                case 10:
                    System.out.println("Ingrese el valor de x:");
                    int x = Lector.nextInt();
                    double r = ciclos.calcularEx(x);
                    System.out.println("El valor de e^" + x + " es aproximadamente: " + r);
                    break;
            }

        } while (op != 0);
    }
}
