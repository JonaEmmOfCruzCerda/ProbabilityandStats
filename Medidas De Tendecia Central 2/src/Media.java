public class Media {
    private DiscreteMaths dM = new DiscreteMaths();
    public double mediaDNA(int[] dataSet) {
        double suma = 0;
        for (int num : dataSet) {
            suma += num;
        }
        return suma / dataSet.length;
    }

    public double mediaDA(int[] dataSet){
        int[] limiteInferior = dM.calcularLimiteInferior(dataSet);
        int[] limiteSuperior = dM.calcularLimiteSuperior(dataSet, limiteInferior);
        int[] frecuencia = dM.calcularFrecuencia(dataSet, limiteInferior, limiteSuperior);

        System.out.println("| Li - Ls | f | Xc | f * Xc |");
        System.out.println("|---------|---|----|--------|");
        for (int i=0; i< frecuencia.length; i++){
            int xc = (limiteInferior[i] + limiteSuperior[i]) / 2;
            int fx = frecuencia[i] * xc;
            System.out.printf("| %2d - %2d | %2d | %2d | %6d |\n", limiteInferior[i], limiteSuperior[i], frecuencia[i], xc, fx);
        }

        int sumaDeProductos = 0; // Reinicia la suma de productos en cada llamada al método
        for (int i = 0; i < frecuencia.length; i++) {
            int xc = (limiteInferior[i] + limiteSuperior[i]) / 2;
            sumaDeProductos += frecuencia[i] * xc;
        }
        double media = (double) sumaDeProductos / dataSet.length;
        System.out.println("Media: " + sumaDeProductos + "/" + dataSet.length);
        return media;
    }


    /*public double mediaDA(int[] dataSet) {
        int n, numClases, amplitudClase, sumaDeProductos, f, xc, fx;
        double media;

        Arrays.sort(dataSet); // Ordenar los datos
        n = dataSet.length; // Total de datos
        numClases = (int) Math.ceil(1 + 3.322 * Math.log10(n)); // Número de clases
        amplitudClase = (dataSet[n - 1] - dataSet[0] + 1) / numClases; // Amplitud de clase

        int[] limitesInferior = new int[numClases]; // Límites de clase
        int[] limitesSuperior = new int[numClases];
        for (int i = 0; i < numClases; i++) {
            limitesInferior[i] = dataSet[0] + i * amplitudClase;
            limitesSuperior[i] = limitesInferior[i] + amplitudClase - 1;
        }

        int[] frecuencia = new int[numClases];
        sumaDeProductos = 0;
        for (int valor : dataSet) { // Frecuencia de clase
            for (int i = 0; i < numClases; i++) {
                if (valor >= limitesInferior[i] && valor <= limitesSuperior[i]) {
                    frecuencia[i]++;
                    break;
                }
            }
        }

        System.out.println("| Li - Ls | f | Xc | f * Xc |");
        System.out.println("|---------|---|----|--------|");
        for (int i = 0; i < numClases; i++) {
            f = frecuencia[i];
            xc = (limitesInferior[i] + limitesSuperior[i]) / 2; // punto medio
            fx = f * xc;
            sumaDeProductos += fx;
            System.out.printf("| %2d - %2d | %2d | %2d | %6d |\n", limitesInferior[i], limitesSuperior[i], f, xc, fx);
        }

        media = (double) sumaDeProductos / n;
        return media;
    } */
}