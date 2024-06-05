public class QLR {
    //Posicion en el array 0 = n, 1 = Exi, 2 = Eyi, 3 = Ex2i, 4 = Ex3i, 5 = Ex4i, 6 = Exiyi y 7 = Ex2iyi
    public static double dS(double[] x, double[] y) {
        double[] sumatorias = DiscreteMaths.sumatorias(x, y);
        double n = sumatorias[0];
        double Ex2i = sumatorias[3];
        double Ex4i = sumatorias[5];
        double Exi = sumatorias[1];
        double Ex3i = sumatorias[4];
        double d1 = (n * Ex2i * Ex4i + Exi * Ex3i * Ex2i + Ex2i * Exi * Ex3i);
        double d2 = (Ex2i * Ex2i * Ex2i - Ex3i * Ex3i * n - Ex4i * Exi * Exi);
        return d1 - d2;
    }
    public static double dB0(double[] x, double[] y) {
        double[] sumatorias = DiscreteMaths.sumatorias(x, y);
        double Eyi = sumatorias[2];
        double Ex2i = sumatorias[3];
        double Ex4i = sumatorias[5];
        double Exi = sumatorias[1];
        double Ex3i = sumatorias[4];
        double Ex2iyi = sumatorias[7];
        double Exiyi = sumatorias[6];
        double d1 = (Eyi * Ex2i * Ex4i + Exi * Ex3i * Ex2iyi + Ex2i * Exiyi * Ex3i);
        double d2 = (Ex2iyi * Ex2i * Ex2i - Ex3i * Ex3i * Eyi - Ex4i * Exiyi * Exi);
        return (d1 - d2) / dS(x, y);
    }
    public static double dB1(double[] x, double[] y) {
        double[] sumatorias = DiscreteMaths.sumatorias(x, y);
        double n = x.length;
        double Exiyi = sumatorias[6];
        double Ex4i = sumatorias[5];
        double Eyi = sumatorias[2];
        double Ex3i = sumatorias[4];
        double Ex2i = sumatorias[3];
        double Exi = sumatorias[1];
        double Ex2iyi = sumatorias[7];
        double d1 = (n * Exiyi * Ex4i + Eyi * Ex3i * Ex2i + Ex2i * Exi * Ex2iyi);
        double d2 = (Ex2i * Exiyi * Ex2i - Ex2iyi * Ex3i * n - Ex4i * Exi * Eyi);
        return (d1 - d2) / dS(x, y);
    }
    public static double dB2(double[] x, double[] y) {
        double[] sumatorias = DiscreteMaths.sumatorias(x, y);
        double n = x.length;
        double Ex2iyi = sumatorias[7];
        double Exi = sumatorias[1];
        double Ex3i = sumatorias[4];
        double Ex2i = sumatorias[3];
        double Eyi = sumatorias[2];
        double d1 = (n * Ex2i * Ex2iyi + Exi * sumatorias[6] * Ex2i + Eyi * Exi * Ex3i);
        double d2 = (Ex2i * Ex2i * Eyi - Ex3i * Ex2iyi * n - Ex2iyi * Exi * Exi);
        return (d1 - d2) / dS(x, y);
    }
}