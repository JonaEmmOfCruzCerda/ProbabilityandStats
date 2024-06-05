public class Main {
    public static void main(String[] args) {
        DataSet dataSet = new DataSet();
        DiscreteMaths dM = new DiscreteMaths();
        SLR slr = dM.sumatoria(dataSet);

        System.out.println("Ecuacion de regresion: ");
        System.out.println(" y = " + String.format("%.2f", slr.getB0()) + " + " + String.format("%.2f", slr.getB1()) + " x1");
        System.out.println();

        int[] x = {30, 20, 10, 40, 50};
        double prediccionY = 0;

        System.out.println("Predicciones: ");
        for (int i = 0; i < x.length; i++) {
            prediccionY = slr.prediccion(x[i]);
            System.out.println("X = " + x[i] + " Y = " + String.format("%.2f", prediccionY));
        }
    }
}