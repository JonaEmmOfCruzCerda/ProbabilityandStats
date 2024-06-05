public class Main {
    static TipoDatos tD = new TipoDatos();
    static Media media = new Media();
    static Mediana mediana = new Mediana();
    static Moda moda = new Moda();

    public static void main(String[] args) {
        DataSet dataSet = new DataSet();
        int[] dS = dataSet.getDS();

        String tipo = tD.tipoDatos(dS);
        System.out.println("El DataSet son " + tipo);

        // Verificando el tipo de datos utilizando la longitud del arreglo dS
        if (dS.length > 35) {
            // Media, mediana y moda para datos agrupados
            System.out.println("Media: " + media.mediaDA(dS) + "\n");
            System.out.println("Mediana: " + mediana.medianaDA(dS) + "\n");
            System.out.println("Moda: " + moda.modaDA(dS) + "\n");
        } else {
            // Media, mediana y moda para datos no agrupados
            System.out.println("Media: " + media.mediaDNA(dS));
            System.out.println("Mediana: " + mediana.medianaDNA(dS));
            System.out.println("Moda: " + moda.modaDNA(dS));
        }
        System.out.println();
    }

}

