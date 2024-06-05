public class Main {
    public static void main(String[] args) {
        DataSet dataSet = new DataSet();
        QLR qlr = new QLR();

        double[] x = dataSet.getX();
        double[] y = dataSet.getY();
        double db0 = qlr.dB0(x, y);
        double db1 = qlr.dB1(x, y);
        double db2 = qlr.dB2(x, y);

        System.out.println("Ecuacion de regresion: ");
        System.out.println("Y = " + db2 + "X2" + " + " + db1 + " + " + db0);
        System.out.println();

        double[] X = {30, 20, 10, 40, 50};

        System.out.println("Predicciones: ");
        for (double valorX : X) {
            double prediccionY = db0 + db1 * valorX + db2 * valorX * valorX;
            System.out.println("X = " + valorX + " Y = " + prediccionY);
        }
    }
}