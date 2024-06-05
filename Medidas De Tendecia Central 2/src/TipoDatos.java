public class TipoDatos {
    protected DataSet dS = new DataSet();
    public String tipoDatos(int[] dataSet) {
        return (dataSet.length > 35) ? "datos Agrupados" : "datos no agrupados"; // Operador ternario
    }
}
