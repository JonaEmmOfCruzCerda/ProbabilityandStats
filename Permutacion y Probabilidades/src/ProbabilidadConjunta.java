public class ProbabilidadConjunta {
    DataSet dS = new DataSet();
    int total;

    public ProbabilidadConjunta(DataSet dS){
        this.dS = dS;
    }

    public String pConjuntaAB(){
        total = dS.getNubladoLlueve()[0];
        double p = (double) total / dS.getTotalDias();
        return total + "/" + dS.getTotalDias() + " = " + p;
    }

    public String pConjuntaABP(){
        total = dS.getNubladoNoLlueve()[0];
        double p = (double) total / dS.getTotalDias();
        return total + "/" + dS.getTotalDias() + " = " + p;
    }

    public String pConjuntaAPB(){
        total = dS.getNoNubladoLlueve()[0];
        double p = (double) total / dS.getTotalDias();
        return total + "/" + dS.getTotalDias() + " = " + p;
    }

    public String pConjuntaAPBP(){
        total = dS.getNoNubladoNoLlueve()[0];
        double p = (double) total / dS.getTotalDias();
        return total + "/" + dS.getTotalDias() + " = " + p;
    }
}