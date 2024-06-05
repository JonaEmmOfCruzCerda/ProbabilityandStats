import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Moda {
    private DiscreteMaths dM = new DiscreteMaths();
    public String modaDNA(int[] dataSet) {
        int moda = dataSet[0];
        int maxContador = 0;
        List<Integer> modas = new ArrayList<>();

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

        System.out.println("| Li - Ls | Marca de clase | Frecuencia absoluta | Frecuencia absoluta acumulada | Frecuencia relativa | Frecuencia relativa acumulada |");
        for (int i = 0; i < frecuenciaClase.length; i++) {
            int marcaClase = (limiteInferior[i] + limiteSuperior[i]) / 2;
            int frecuenciaAcumulada = Arrays.stream(frecuenciaClase).limit(i + 1).sum();
            double frecuenciaRelativa = (double) frecuenciaClase[i] / dataSet.length;
            double frecuenciaRelativaAcumulada = (double) frecuenciaAcumulada / dataSet.length;

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

        // Mostrando los valores utilizados en el cálculo
        System.out.println("\nValores utilizados en el cálculo de la moda:");
        System.out.println("Li: " + Li);
        System.out.println("fi: " + fi);
        System.out.println("fi-1: " + fiAnterior);
        System.out.println("fi+1: " + fiPosterior);
        System.out.println("A: " + A);

        System.out.println("Moda (MO) = " + Li + " + ((" + fi + " - " + fiAnterior + ") / ((" + fi + " - " + fiAnterior + ") + (" + fi + " - " + fiPosterior + "))) * " + A);

        return moda;
    }



    /*public double modaDA(int[] dataSet) {

        Arrays.sort(dataSet); // Ordena los datos
        int n = dataSet.length; // Obtenemos el total de datos
        int numClases = (int) Math.ceil(1 + 3.322 * Math.log10(n)); // Número de clases
        int amplitudClase = (dataSet[n - 1] - dataSet[0] + 1) / numClases; // Amplitud de clase
        int[] limitesInferiores = new int[numClases]; // Límites de clase
        int[] limitesSuperiores = new int[numClases];

        for (int i = 0; i < numClases; i++) {
            limitesInferiores[i] = dataSet[0] + i * amplitudClase;
            limitesSuperiores[i] = limitesInferiores[i] + amplitudClase - 1;
        }

        int[] marcasClase = new int[numClases]; // Marcas de clase y Frecuencias de clase
        int[] frecuenciaClase = new int[numClases];

        for (int i = 0; i < numClases; i++) {
            marcasClase[i] = (limitesInferiores[i] + limitesSuperiores[i]) / 2;
            for (int dato : dataSet) {
                if (dato >= limitesInferiores[i] && dato <= limitesSuperiores[i]) {
                    frecuenciaClase[i]++;
                }
            }
        }

        int[] frecuenciaAcumulada = new int[numClases]; // Calculamos las frecuencias acumuladas
        int frecuenciaTotal = 0;

        for (int i = 0; i < numClases; i++) {
            frecuenciaTotal += frecuenciaClase[i];
            frecuenciaAcumulada[i] = frecuenciaTotal;
        }

        double[] frecuenciaRelativa = new double[numClases]; // Frecuencias relativas y acumuladas
        double[] frecuenciaRelativaAcumulada = new double[numClases];
        for (int i = 0; i < numClases; i++) {
            frecuenciaRelativa[i] = (double) frecuenciaClase[i] / n;
            frecuenciaRelativaAcumulada[i] = (double) frecuenciaAcumulada[i] / n;
        }

        System.out.println("| Li - Ls | Marca de clase | Frecuencia absoluta | Frecuencia absoluta acumulada | Frecuencia relativa | Frecuencia relativa acumulada |");
        for (int i = 0; i < numClases; i++) {
            System.out.printf("| %2d - %2d | %14d | %19d | %30d | %27.2f | %35.2f |\n",
                    limitesInferiores[i], limitesSuperiores[i], marcasClase[i],
                    frecuenciaClase[i], frecuenciaAcumulada[i], frecuenciaRelativa[i], frecuenciaRelativaAcumulada[i]);
        }

        // Clase modal
        int indiceModa = 0;
        int frecuenciaMayor = frecuenciaClase[0];
        for (int i = 1; i < numClases; i++) {
            if (frecuenciaClase[i] > frecuenciaMayor) {
                frecuenciaMayor = frecuenciaClase[i];
                indiceModa = i;
            }
        }

        double Li = limitesInferiores[indiceModa];
        double fi = frecuenciaMayor;
        double fiAnterior = (indiceModa > 0) ? frecuenciaClase[indiceModa - 1] : 0;
        double fiSiguiente = (indiceModa < numClases - 1) ? frecuenciaClase[indiceModa + 1] : 0;
        double A = limitesSuperiores[indiceModa] - limitesInferiores[indiceModa]; // Amplitud de clase

        System.out.println("Variables de la fórmula para la moda:");
        System.out.println("Li: " + Li); // Límite inferior de la clase modal
        System.out.println("fi: " + fi); // Frecuencia mayor
        System.out.println("fi-1: " + fiAnterior); // Frecuencia anterior
        System.out.println("fi+1: " + fiSiguiente); // Frecuencia posterior
        System.out.println("A: " + A); // Amplitud de clase

        return Li + ((fi - fiAnterior) / ((fi - fiAnterior) + (fi - fiSiguiente))) * A;
    }*/
}