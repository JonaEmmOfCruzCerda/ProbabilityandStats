import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Moda {
    private DiscreteMaths dM = new DiscreteMaths();
    public String modaDNA(int[] dataSet) {
        int moda = dataSet[0]; // Inicializa la moda con el primer elemento del dataset
        int maxContador = 0;
        List<Integer> modas = new ArrayList<>(); // almacena los valores de la moda.

        for (int i = 0; i < dataSet.length; i++) {
            int contador = 0;
            for (int j = 0; j < dataSet.length; j++) {
                if (dataSet[j] == dataSet[i]) {
                    contador++;
                }
            }
            if (contador > maxContador) {
                maxContador = contador;
                moda = dataSet[i];
                modas.clear();
                modas.add(moda);
            } else if (contador == maxContador && !modas.contains(dataSet[i])) {
                modas.add(dataSet[i]);
            }
        }
        if (modas.size() == 1) {
            return "Unimodal: " + modas.get(0);
        } else if (modas.size() == 2) {
            return "Bimodal: " + modas.get(0) + ", " + modas.get(1);
        } else if (modas.size() > 2) {
            StringBuilder resultado = new StringBuilder("Multimodal: ");
            for (int valor : modas) {
                resultado.append(valor).append(", ");
            }
            return resultado.toString();
        } else {
            return "No hay moda";
        }
    }
    public double modaDA(int[] dataSet) {
        int[] limiteInferior = dM.calcularLimiteInferior(dataSet);
        int[] limiteSuperior = dM.calcularLimiteSuperior(dataSet, limiteInferior);
        int[] frecuenciaClase = dM.calcularFrecuencia(dataSet, limiteInferior, limiteSuperior);

        System.out.println("                                                                    Moda                                                                ");
        System.out.println("| Li - Ls | Marca de clase | Frecuencia absoluta | Frecuencia absoluta acumulada | Frecuencia relativa | Frecuencia relativa acumulada |");
        for (int i = 0; i < frecuenciaClase.length; i++) {
            int marcaClase = (limiteInferior[i] + limiteSuperior[i]) / 2; // Calcula el punto medio del intervalo
            int frecuenciaAcumulada = Arrays.stream(frecuenciaClase).limit(i + 1).sum(); // Calcula la frecuencia acumulada sumando las frecuencias hasta el índice `i`.
            double frecuenciaRelativa = (double) frecuenciaClase[i] / dataSet.length; // Calcula la frecuencia relativa dividiendo la frecuencia de la clase por el total de datos.
            double frecuenciaRelativaAcumulada = (double) frecuenciaAcumulada / dataSet.length; // Calcula la frecuencia relativa acumulada dividiendo la frecuencia acumulada por el total de datos.

            System.out.printf("| %2d - %2d | %14d | %19d | %29d | %19.2f | %29.2f |\n",
                    limiteInferior[i], limiteSuperior[i], marcaClase,
                    frecuenciaClase[i], frecuenciaAcumulada, frecuenciaRelativa, frecuenciaRelativaAcumulada);
        }

        int indiceModa = 0;
        for (int i = 1; i < frecuenciaClase.length; i++) {
            if (frecuenciaClase[i] > frecuenciaClase[indiceModa]) {
                indiceModa = i;
            }
        }
        double Li = limiteInferior[indiceModa];
        double fi = frecuenciaClase[indiceModa];
        double fiAnterior = (indiceModa > 0) ? frecuenciaClase[indiceModa - 1] : 0;
        double fiPosterior = (indiceModa < frecuenciaClase.length - 1) ? frecuenciaClase[indiceModa + 1] : 0;
        double A = limiteSuperior[indiceModa] - limiteInferior[indiceModa];
        double moda = Li + ((fi - fiAnterior) / ((fi - fiAnterior) + (fi - fiPosterior))) * A;

        System.out.println("Variables de la fórmula:");
        System.out.println("Li: " + Li);
        System.out.println("fi: " + fi);
        System.out.println("fi-1: " + fiAnterior);
        System.out.println("fi+1: " + fiPosterior);
        System.out.println("A: " + A);

        System.out.println("Moda: " + Li + " + ((" + fi + " - " + fiAnterior + ") / ((" + fi + " - " + fiAnterior + ") + (" + fi + " - " + fiPosterior + "))) * " + A);

        return moda;
    }
}