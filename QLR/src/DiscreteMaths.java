public class DiscreteMaths {
    private static double Exi, Eyi, Ex2i, Ex3i, Ex4i, Exiyi, Ex2iyi;

    public static double[] sumatorias(double[] x, double[] y) {
        int n = x.length;
        Exi = 0;
        Eyi = 0;
        Ex2i = 0;
        Ex3i = 0;
        Ex4i = 0;
        Exiyi = 0;
        Ex2iyi = 0;

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

        return new double[]{n, Exi, Eyi , Ex2i, Ex3i, Ex4i, Exiyi, Ex2iyi};
    }
}