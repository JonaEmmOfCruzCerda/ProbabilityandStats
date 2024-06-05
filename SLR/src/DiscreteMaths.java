public class DiscreteMaths {
    public SLR sumatoria(DataSet dataSet) {
        int[] x = dataSet.getX();
        int[] y = dataSet.getY();
        int n = 9;
        double Exi = 0, Eyi = 0, Ex2i = 0, Exiyi = 0;
        double xi, yi, xi2;

        for (int i = 0; i < n; i++) {
            xi = x[i];
            yi = y[i];
            xi2 = xi * xi;

            Exi += xi;
            Eyi += yi;
            Ex2i += xi2;
            Exiyi += xi * yi;
        }
        SLR slr = new SLR();
        slr.formula(Exi, Eyi, Ex2i, Exiyi, n);
        return slr;
    }
}