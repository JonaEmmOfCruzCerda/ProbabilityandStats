import java.util.Arrays;

public class Mediana {
    private DiscreteMaths dM = new DiscreteMaths();
    public double medianaDNA(int[] dataSet) {
        Arrays.sort(dataSet);

        int n = dataSet.length;
        if (n % 2 == 1) {
            int medianPos = (n + 1) / 2 - 1;
            return dataSet[medianPos];
        } else {
            int medianPos = (n + 1) / 2 - 1;
            return dataSet[medianPos] + 0.5;
        }
    }
    public double medianaDA(int[] dataSet) {
        int[] limitesInferiores = dM.calcularLimiteInferior(dataSet);
        int[] limitesSuperiores = dM.calcularLimiteSuperior(dataSet, limitesInferiores);
        int[] frecuenciaClase = dM.calcularFrecuencia(dataSet, limitesInferiores, limitesSuperiores);
        int[] frecuenciaAcumulada = dM.calcularFrecuenciaAcumulada(frecuenciaClase);
        int n = dataSet.length;
        int numClases = limitesInferiores.length;

        System.out.println("| Li - Ls | Frecuencia de clase | Frecuencia Acumulada menor |");
        System.out.println("|---------|---------------------|----------------------------|");
        for (int i = 0; i < frecuenciaClase.length; i++) {
            System.out.printf("| %2d - %2d | %19d | %26d |\n", limitesInferiores[i], limitesSuperiores[i], frecuenciaClase[i], frecuenciaAcumulada[i]);
        }

        int posicionMediana = n / 2; // Posición de la mediana (n/2)
        System.out.println("Total de datos: " + n);
        System.out.println("Mediana = " + n + "/2 = " + posicionMediana + "\n");

        for (int i = 0; i < numClases; i++) {
            if (frecuenciaAcumulada[i] >= posicionMediana) {
                double L = limitesInferiores[i]; // Límite inferior de la clase mediana
                double f = frecuenciaClase[i]; // Frecuencia de la clase mediana
                double FA = (i > 0) ? frecuenciaAcumulada[i - 1] : 0;
                double iWidth = limitesSuperiores[i] - limitesInferiores[i]; // Amplitud de la clase

                System.out.println("Variables de la fórmula:");
                System.out.println("L: " + L);
                System.out.println("n/2: " + posicionMediana);
                System.out.println("FA: " + (i > 0 ? frecuenciaAcumulada[i - 1] : 0)); // Frecuencia acumulada anterior
                System.out.println("f: " + f);
                System.out.println("i: " + iWidth); // Amplitud de la clase

                double mediana = L + ((posicionMediana - (i > 0 ? frecuenciaAcumulada[i - 1] : 0)) / f) * iWidth;
                System.out.println("Mediana = " + L + " + ((" + (n / 2) + " - " + FA + ") / " + f + ") * " + iWidth);
                return mediana;
            }
        }
        return -1;
    }


    /*public double medianaDA(int[] dataSet) {

        Arrays.sort(dataSet); // Ordenar los datos
        int n = dataSet.length; // Total de datos
        int numClases = (int) Math.ceil(1 + 3.322 * Math.log10(n)); // Número de clases
        int amplitudClase = (dataSet[n - 1] - dataSet[0] + 1) / numClases; // Amplitud de clase

        int[] limitesInferiores = new int[numClases]; // Límites de clase
        int[] limitesSuperiores = new int[numClases];
        for (int i = 0; i < numClases; i++) {
            limitesInferiores[i] = dataSet[0] + i * amplitudClase;
            limitesSuperiores[i] = limitesInferiores[i] + amplitudClase - 1;
        }

        int[] frecuenciaClase = new int[numClases]; // Frecuencias de clase
        for (int dato : dataSet) {
            for (int i = 0; i < numClases; i++) {
                if (dato >= limitesInferiores[i] && dato <= limitesSuperiores[i]) {
                    frecuenciaClase[i]++;
                    break;
                }
            }
        }

        int[] frecuenciaAcumulada = new int[numClases]; // Frecuencias acumuladas
        frecuenciaAcumulada[0] = frecuenciaClase[0];
        for (int i = 1; i < numClases; i++) {
            frecuenciaAcumulada[i] = frecuenciaAcumulada[i - 1] + frecuenciaClase[i];
        }

        System.out.println("| Li - Ls | Frecuencia de clase | Frecuencia Acumulada menor |");
        System.out.println("|---------|----------------------|-----------------------------|");
        for (int i = 0; i < numClases; i++) {
            System.out.printf("| %3d - %3d | %20d | %27d |\n", limitesInferiores[i], limitesSuperiores[i], frecuenciaClase[i], frecuenciaAcumulada[i]);
        }

        int posicionMediana = n / 2; // Posición de la mediana (n/2)

        System.out.println("Total de datos: " + n);
        System.out.println("Mediana = " + n + "/2 = " + posicionMediana + "\n");

        for (int i = 0; i < numClases; i++) {
            if (frecuenciaAcumulada[i] >= posicionMediana) {
                double L = limitesInferiores[i]; // Límite inferior de la clase mediana
                double f = frecuenciaClase[i]; // Frecuencia de la clase mediana
                double iWidth = amplitudClase; // Amplitud de la clase

                System.out.println("Variables de la fórmula:");
                System.out.println("L: " + L);
                System.out.println("n/2: " + posicionMediana);
                System.out.println("FA: " + frecuenciaAcumulada[i - 1]); // Frecuencia acumulada anterior
                System.out.println("f: " + f);
                System.out.println("i: " + (amplitudClase - 1)); // Ajustamos la amplitud de clase

                double mediana = L + ((posicionMediana - frecuenciaAcumulada[i - 1]) / f) * (amplitudClase - 1);
                return mediana;
            }
        }
        return -1;
    }*/

}