public class Media {
    private DiscreteMaths dM = new DiscreteMaths();
    public double mediaDNA(int[] dataSet) {
        double suma = 0;
        for (int num : dataSet) { // for-each
            suma += num;
        }
        return suma / dataSet.length; // Aplico la formula
    }

    public double mediaDA(int[] dataSet){
        int[] limiteInferior = dM.calcularLimiteInferior(dataSet);
        int[] limiteSuperior = dM.calcularLimiteSuperior(dataSet, limiteInferior);
        int[] frecuencia = dM.calcularFrecuencia(dataSet, limiteInferior, limiteSuperior);

        System.out.println("           Media             ");
        System.out.println("| Li - Ls | f | Xc | f * Xc |");
        System.out.println("|---------|---|----|--------|");
        for (int i=0; i< frecuencia.length; i++){
            int xc = (limiteInferior[i] + limiteSuperior[i]) / 2; // Calculo el punto medio
            int fx = frecuencia[i] * xc; // Calculo f * Xc
            System.out.printf("| %2d - %2d | %2d | %2d | %6d |\n", limiteInferior[i], limiteSuperior[i], frecuencia[i], xc, fx);
        }

        int sumaDeProductos = 0; // Reinicia la suma de productos en cada llamada al método
        for (int i = 0; i < frecuencia.length; i++) {
            int xc = (limiteInferior[i] + limiteSuperior[i]) / 2; // Calculo el punto medio
            sumaDeProductos += frecuencia[i] * xc; // Acumulo los productos de f * Xc
        }
        double media = (double) sumaDeProductos / dataSet.length; // Aplico la formula
        System.out.println("Media: " + sumaDeProductos + "/" + dataSet.length);
        return media;
    }
}