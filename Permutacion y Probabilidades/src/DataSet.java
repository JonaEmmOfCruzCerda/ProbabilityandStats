public class DataSet {
    String[] permutacion = {"a", "b", "c", "d"};
    private int[] nubladoLlueve = {8}; private int[] nubladoNoLlueve = {3};
    private int[] noNubladoLlueve = {3}; private int[] noNubladoNoLlueve = {6};
    private int totalDias = 18;

    public String[] getPermutacion() {
        return permutacion;
    }
    public int[] getNubladoLlueve() {
        return nubladoLlueve;
    }
    public int[] getNubladoNoLlueve() {
        return nubladoNoLlueve;
    }
    public int[] getNoNubladoLlueve() {
        return noNubladoLlueve;
    }
    public int[] getNoNubladoNoLlueve() {
        return noNubladoNoLlueve;
    }
    public int getTotalDias() {
        return totalDias;
    }
}