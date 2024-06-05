public class DiscreteMaths {
    public static double[] SLR(double[] x, double[] y){
        int n = x.length;
        double Exi = 0, Eyi = 0, Exiyi = 0, Ex2i = 0;
        double B0, B1;

        for(int i = 0; i<n; i++){
            Exi += x[i];
            Eyi += y[i];
            Exiyi += x[i] * y[i];
            Ex2i += x[i] * x[i];
        }
        B1 = (n * Exiyi - Exi * Eyi) / (n * Ex2i - Exi * Exi);
        B0 = (Eyi - B1 * Exi) / n;
        return new double[]{B0, B1};
    }

    public static double[] QLR(double[] x, double[] y) {
        int n = x.length;
        double Exi = 0, Eyi = 0, Ex2i = 0, Ex3i = 0, Ex4i = 0, Exiyi = 0, Ex2iyi = 0;
        double B0, B1, B2;

        double xi, yi, xi2, xi3, xi4;

        for (int i = 0; i < n; i++) {
            xi = x[i];
            yi = y[i];
            xi2 = xi * xi;
            xi3 = xi * xi * xi;
            xi4 = xi * xi * xi * xi;

            Exi += xi;
            Eyi += yi;
            Ex2i += xi2;
            Ex3i += xi3;
            Ex4i += xi4;
            Exiyi += xi * yi;
            Ex2iyi += xi2 * yi;
        }

        double dS = (n * Ex2i * Ex4i + Exi * Ex3i * Ex2i +Ex2i * Exi * Ex3i
                - Ex2i * Ex2i * Ex2i - Ex3i * Ex3i * n - Ex4i * Exi * Exi);

        B0 = (Eyi * Ex2i * Ex4i + Exi * Ex3i * Ex2iyi + Ex2i * Exiyi * Ex3i
                - Ex2iyi * Ex2i * Ex2i - Ex3i * Ex3i * Eyi - Ex4i * Exiyi * Exi) / dS;

        B1 = (n * Exiyi * Ex4i + Eyi * Ex3i * Ex2i + Ex2i * Exi * Ex2iyi
                - Ex2i * Exiyi * Ex2i - Ex2iyi * Ex3i * n - Ex4i * Exi * Eyi) / dS;

        B2 = (n * Ex2i * Ex2iyi + Exi * Exiyi * Ex2i + Eyi * Exi * Ex3i
                - Ex2i * Ex2i * Eyi - Ex3i * Exiyi * n - Ex2iyi * Exi * Exi) / dS;

        return new double[]{B0, B1, B2};
    }



    public static double[] CLR(double[] x, double[] y){
        int n = x.length;
        double Exi = 0, Eyi = 0, Ex2i = 0, Ex3i = 0, Ex4i = 0, Ex5i = 0, Ex6i = 0, Exiyi = 0, Ex2iyi = 0, Ex3iyi = 0, Ex4iyi = 0;

        for(int i = 0; i < n; i++){
            double xi = x[i];
            double yi = y[i];
            double xi2 = xi * xi;
            double xi3 = xi * xi * xi;
            double xi4 = xi * xi * xi * xi;
            double xi5 = xi * xi * xi * xi * xi;
            double xi6 = xi * xi * xi * xi * xi * xi;

            Exi += xi;
            Eyi += yi;
            Exiyi += xi * yi;
            Ex2i += xi2;
            Ex3i += xi3;
            Ex4i += xi4;
            Ex5i += xi5;
            Ex6i += xi6;
            Ex2iyi += xi2 * yi;
            Ex3iyi += xi3 * yi;
            Ex4iyi += xi4 * yi;
        }

        double[][] matriz = {
                {n, Exi, Ex2i, Ex3i},
                {Exi, Ex2i, Ex3i, Ex4i},
                {Ex2i, Ex3i, Ex4i, Ex5i},
                {Ex3i, Ex4i, Ex5i, Ex6i}
        };
        double[] constantes = {Eyi, Exiyi, Ex2iyi, Ex3iyi};
        double[] coeficientes = Matrix(matriz, constantes);
        return coeficientes;
    }
    private static double[] Matrix(double[][] matriz, double[] constantes){
        int n = matriz.length;
        double[] coeficientes = new double[n];

        for(int i = 0; i<n; i++){
            double pivote = matriz[i][i];
            for(int j = i + 1; j<n; j++){
                double radio = matriz[j][i] / pivote;
                for(int k = 0; k<n; k++){
                    matriz[j][k] -= radio * matriz[i][k];
                }
                constantes[j] -= radio * constantes[i];
            }
        }

        for(int i = n - 1; i>=0; i--){
            double suma = constantes[i];
            for(int j = i + 1; j<n; j++){
                suma -= matriz[i][j] * coeficientes[j];
            }
            coeficientes[i] = suma / matriz[i][i];
        }
        return  coeficientes;
    }
}