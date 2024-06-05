public class DiscreteMaths {
    int k;
    double[] limitesClase;
    int[] frecuenciaClase;
    double[] puntosMedios;
    int[] frecuenciaAcumulada;
    double[] frecuenciaRelativa;
    double[] frecuenciaRelativaAcumulada;
    double[] porcentaje;

    public void agruparDatos(DataSet dataSet) {
        double[] d = dataSet.getD();
        int n = d.length;
        double r, amplitudClase, aCR, li;

        //Numero de clases Sugles
        k = (int) (1 + 3.322 * Math.log10(n));
        if (n <= 1) {
            k = 1;
        }
        System.out.println();
        System.out.println("Numero de clases: " + k);

        //Amplitud de las clases
        double om = Double.MAX_VALUE;
        double OM = Double.MIN_VALUE;
        for (double value : d) {
            if (value < om) {
                om = value;
            }
            if (value > OM) {
                OM = value;
            }
        }

        //Rango
        //Observacion Mayor y menor
        r = OM - om;
        System.out.println("Rango: " + r);
        amplitudClase = r / k;
        aCR = (int) (amplitudClase + 0.5);
        System.out.println("Amplitud de la clase: " + String.format("%.2f", amplitudClase) + " redondeado: " + aCR);

        //Limite de clase
        limitesClase = new double[k];
        limitesClase[0] = om;
        for (int i = 1; i < k; i++) {
            limitesClase[i] = limitesClase[i - 1] + amplitudClase;
        }

        //Frecuencia
        frecuenciaClase = new int[k];
        for (double value : d) {
            for (int i=0; i<k; i++){
                if (i == 0 && value <= limitesClase[i]){
                    frecuenciaClase[i]++;
                    break;
                } else if (i==k-1 && value > limitesClase[i]){
                    frecuenciaClase[i]++;
                    break;
                } else if (i>0 && value > limitesClase[i-1] && value <= limitesClase[i]) {
                    frecuenciaClase[i]++;
                    break;
                }
            }
        }
        int totalFrecuencia = 0;
        for (int i = 0; i < k; i++) {
            totalFrecuencia += frecuenciaClase[i];
        }
        System.out.println("Frecuencia: " + totalFrecuencia);

        // Punto Medio
        puntosMedios = new double[k];
        for (int i = 0; i < k - 1; i++) {
            puntosMedios[i] = (limitesClase[i] + limitesClase[i + 1]) / 2;
        }

        // Frecuencia acumulada
        frecuenciaAcumulada = new int[k];
        frecuenciaAcumulada[0] = frecuenciaClase[0];
        for (int i = 1; i < k; i++) {
            frecuenciaAcumulada[i] = frecuenciaAcumulada[i - 1] + frecuenciaClase[i];
        }

        // Frecuencia Relativa
        frecuenciaRelativa = new double[k];
        for (int i = 0; i < k; i++) {
            frecuenciaRelativa[i] = (double) frecuenciaClase[i] / n;
        }
        double totalFrecuenciaRelativa = 0.0;
        for (int i = 0; i < k; i++) {
            totalFrecuenciaRelativa += frecuenciaRelativa[i];
        }
        System.out.println("Frecuencia relativa: " + totalFrecuenciaRelativa);

        // Frecuencia relativa acumulada
        frecuenciaRelativaAcumulada = new double[k];
        frecuenciaRelativaAcumulada[0] = frecuenciaRelativa[0];
        for (int i = 1; i < k; i++) {
            frecuenciaRelativaAcumulada[i] = frecuenciaRelativaAcumulada[i - 1] + frecuenciaRelativa[i];
        }

        // Porcentaje
        porcentaje = new double[k];
        for (int i = 0; i < k; i++) {
            porcentaje[i] = frecuenciaRelativa[i] * 100;
        }
        double porcentajeTotal = 0;
        for (int i = 0; i < k; i++) {
            porcentajeTotal += porcentaje[i];
        }
        System.out.println("Porcentaje total: " + String.format("%.2f", porcentajeTotal) + "%");

    }
    public void tablaDescriptiva() {
        System.out.println();
        System.out.println("|                                                      Tabla Descriptiva                                                     |");
        System.out.println("| Clase | Frecuencia | Punto Medio | Frecuencia Acumulada | Frecuencia Relativa | Frecuencia Relativa Acumulada | Porcentaje |");
        for (int i = 0; i < k; i++) {
            System.out.println("|   " + (i + 1) + "         " + frecuenciaClase[i] + "           " + String.format("%.2f", puntosMedios[i]) +
                    "              " + frecuenciaAcumulada[i] + "                     " + String.format("%.2f", frecuenciaRelativa[i]) +
                    "                     " + String.format("%.2f", frecuenciaRelativaAcumulada[i]) + "                     " + String.format("%.2f", porcentaje[i]) + "    |");
        }

    }
}
