import java.util.Arrays;
import java.util.List;

public class Mediana {
    private DiscreteMaths dM = new DiscreteMaths();
    public double medianaDNA(int[] dataSet) {
        Arrays.sort(dataSet); // Ordena el arreglo

        int n = dataSet.length; // Obtengo el tamaño del arreglo
        if (n % 2 == 1) { // Es para si el tamaño es impar
            int medianPos = (n + 1) / 2 - 1; // Calcula la posicion y el -1 es para ajustar el indice del arreglo
            return dataSet[medianPos]; // devuelve el valor del elemento en la posición.
        } else {
            int medianPos = (n + 1) / 2 - 1; //Si es par
            return dataSet[medianPos] + 0.5; // devuelve el promedio de los dos valores.
        }
    }
    public double medianaDA(int[] dataSet) {
        int[] limitesInferiores = dM.calcularLimiteInferior(dataSet);
        int[] limitesSuperiores = dM.calcularLimiteSuperior(dataSet, limitesInferiores);
        int[] frecuenciaClase = dM.calcularFrecuencia(dataSet, limitesInferiores, limitesSuperiores);
        int[] frecuenciaAcumulada = dM.calcularFrecuenciaAcumulada(frecuenciaClase);
        int n = dataSet.length; // Obtengo el tamaño del arreglo
        int numClases = limitesInferiores.length; // Obtengo el numero de clases

        System.out.println("                          Mediana                             ");
        System.out.println("| Li - Ls | Frecuencia de clase | Frecuencia Acumulada menor |");
        System.out.println("|---------|---------------------|----------------------------|");
        for (int i = 0; i < frecuenciaClase.length; i++) {
            System.out.printf("| %2d - %2d | %19d | %26d |\n", limitesInferiores[i], limitesSuperiores[i], frecuenciaClase[i], frecuenciaAcumulada[i]);
        }

        int posicionMediana = n / 2; // Calculo la posición de la mediana (n/2)
        System.out.println("Total de datos: " + n);
        System.out.println("Mediana = " + n + "/2 = " + posicionMediana + "\n");

        for (int i = 0; i < numClases; i++) {
            if (frecuenciaAcumulada[i] >= posicionMediana) { // Encuentra la clase donde la frecuencia acumulada es mayor o igual a la posición de la mediana.
                double L = limitesInferiores[i]; // Obtengo límite inferior de la clase mediana
                double f = frecuenciaClase[i]; // Obtengo frecuencia de la clase mediana
                double FA = (i > 0) ? frecuenciaAcumulada[i - 1] : 0; // Obtengo frecuencia acumulada anterior.
                double amplitud = limitesSuperiores[i] - limitesInferiores[i]; // Amplitud de la clase

                System.out.println("Variables de la fórmula:");
                System.out.println("L: " + L);
                System.out.println("n/2: " + posicionMediana);
                System.out.println("FA: " + (i > 0 ? frecuenciaAcumulada[i - 1] : 0)); // Frecuencia acumulada anterior
                System.out.println("f: " + f);
                System.out.println("i: " + amplitud); // Amplitud de la clase

                double mediana = L + ((posicionMediana - (i > 0 ? frecuenciaAcumulada[i - 1] : 0)) / f) * amplitud; // Aplico la formula
                System.out.println("Mediana: " + L + " + ((" + (n / 2) + " - " + FA + ") / " + f + ") * " + amplitud);
                return mediana;
            }
        }
        return -1; // Si no encuentra la clase devuelve el -1
    }
}