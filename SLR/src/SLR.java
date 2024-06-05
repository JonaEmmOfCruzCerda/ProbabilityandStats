public class SLR {
    public double B1, B0;
    public void formula(double Exi, double Eyi, double Ex2i, double Exiyi, double n){
        B1 = (n * Exiyi - Exi * Eyi) / (n*Ex2i - Exi * Exi);
        B0 = (Eyi - B1 * Exi) / n;
    }
    public double prediccion(int x) {
        return B0 + B1 * x;
    }
    public double getB0() {
        return B0;
    }
    public double getB1() {
        return B1;
    }
}