public class PLR {
    public static double rcuadrada(double[] y, double[] predictedY) {
        double mediaY = 0;
        for (double yi : y) {
            mediaY += yi;
        }
        mediaY /= y.length;

        //Calcula la suma total de los cuadrados
        double sst = 0;
        for (double yi : y) {
            sst += (yi - mediaY) * (yi - mediaY);
        }

        //Calcula la suma de los residuos al cuadrado
        double ssr = 0;
        for (int i = 0; i < y.length; i++) {
            ssr += (y[i] - predictedY[i]) * (y[i] - predictedY[i]);
        }

        //Calcula el coeficiente de determinacion
        double rSquared = 1 - (ssr / sst);
        return rSquared * 100;
    }

    public static double[] rsqSLR(double[] x, double[] coeficientes){
        double[] predictedY = new double[x.length];
        for (int i=0; i<x.length; i++){
            predictedY[i] = coeficientes[0] + coeficientes[1] * x[i];
        }
        return predictedY;
    }

    public static double[] rsqQLR(double[] x, double[] coeficientes) {
        double[] predictedY = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            predictedY[i] = coeficientes[0] + coeficientes[1] * x[i] + coeficientes[2] * x[i] * x[i];
        }
        return predictedY;
    }

    public static double[] rsqCLR(double[] x, double[] coeficientes) {
        double[] predictedY = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            predictedY[i] = coeficientes[0] + coeficientes[1] * x[i] + coeficientes[2] * x[i] * x[i] + coeficientes[3] * x[i] * x[i] * x[i];
        }
        return predictedY;
    }
}