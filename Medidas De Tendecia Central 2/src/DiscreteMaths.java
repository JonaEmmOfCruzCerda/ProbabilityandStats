import java.util.Arrays;

public class DiscreteMaths {
    int n, numClases;

    public int[] calcularLimiteInferior(int[] dataSet) {
        Arrays.sort(dataSet);
        n = dataSet.length;
        numClases = (int) Math.ceil(1 + 3.322 * Math.log10(n));
        int[] limiteInferior = new int[numClases];
        for (int i = 0; i < numClases; i++) {
            limiteInferior[i] = dataSet[0] + i * (dataSet[n - 1] - dataSet[0] + 1) / numClases;
        }
        return limiteInferior;
    }

    public int[] calcularLimiteSuperior(int[] dataSet, int[] limiteInferior) {
        numClases = limiteInferior.length;
        int[] limiteSuperior = new int[numClases];
        for (int i = 0; i < numClases; i++) {
            limiteSuperior[i] = limiteInferior[i] + (dataSet[dataSet.length - 1] - dataSet[0] + 1) / numClases - 1;
        }
        return limiteSuperior;
    }

    public int[] calcularFrecuencia(int[] dataSet, int[] limiteInferior, int[] limiteSuperior) {
        numClases = limiteSuperior.length;
        int[] frecuencia = new int[numClases];
        for (int valor : dataSet) {
            for (int i = 0; i < numClases; i++) {
                if (valor >= limiteInferior[i] && valor <= limiteSuperior[i]) {
                    frecuencia[i]++;
                    break;
                }
            }
        }
        return frecuencia;
    }

    public int[] calcularFrecuenciaAcumulada(int[] frecuenciaClase) {
        numClases = frecuenciaClase.length;
        int[] frecuenciaAcumulada = new int[numClases];
        frecuenciaAcumulada[0] = frecuenciaClase[0];
        for (int i = 1; i < numClases; i++) {
            frecuenciaAcumulada[i] = frecuenciaAcumulada[i - 1] + frecuenciaClase[i];
        }
        return frecuenciaAcumulada;
    }
}