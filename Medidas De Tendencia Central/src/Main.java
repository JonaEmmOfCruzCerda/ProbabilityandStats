public class Main {
    static TipoDatos tD = new TipoDatos();
    static Media media = new Media();
    static Mediana mediana = new Mediana();
    static Moda moda = new Moda();

    public static void main(String[] args) {
        int[] dS1 = tD.dS.getDS1();
        int[] dS2 = tD.dS.getDS2();
        mostrarEstadistica(dS1, "1");
        mostrarEstadistica(dS2, "2");
    }

    public static void mostrarEstadistica(int[] dataSet, String dataSetName) {
        System.out.println("DataSet " + dataSetName + ": " + tD.tipoDatos(dataSet));
        if (dataSet.length > 35) {
            // Media, mediana y moda para datos agrupados
            System.out.println("Media: " + media.mediaDA(dataSet) + "\n");
            System.out.println("Mediana: " + mediana.medianaDA(dataSet) + "\n");
            System.out.println("Moda: " + moda.modaDA(dataSet) + "\n");
        } else {
            // Media, mediana y moda para datos no agrupados
            System.out.println("Media: " + media.mediaDNA(dataSet));
            System.out.println("Mediana: " + mediana.medianaDNA(dataSet));
            System.out.println("Moda: " + moda.modaDNA(dataSet));
        }
        System.out.println();
    }
}
