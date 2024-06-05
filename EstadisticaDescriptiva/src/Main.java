public class Main {
    public static void main(String[] args){
        DataSet dataSet = new DataSet();
        DiscreteMaths dM = new DiscreteMaths();
        dM.agruparDatos(dataSet);
        dM.tablaDescriptiva();
    }
}