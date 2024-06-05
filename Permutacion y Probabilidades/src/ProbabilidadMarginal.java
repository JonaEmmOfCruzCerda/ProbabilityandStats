public class ProbabilidadMarginal {
    DataSet dS = new DataSet();
    int totalNublado;
    public ProbabilidadMarginal(DataSet dS){
        this.dS = dS;
    }

    public String pMarginalA(){
        totalNublado = dS.getNubladoLlueve()[0] + dS.getNubladoNoLlueve()[0];
        double rP = (double) totalNublado / dS.getTotalDias();
        return totalNublado + "/" + dS.getTotalDias() + " = " + rP;
    }
    public String pMarginalAP(){
        totalNublado = dS.getNoNubladoLlueve()[0] + dS.getNoNubladoNoLlueve()[0];
        double rP = (double) totalNublado / dS.getTotalDias();
        return totalNublado + "/" + dS.getTotalDias() + " = " + rP;
    }
    public String pMarginalB(){
        totalNublado = dS.getNubladoLlueve()[0] + dS.getNoNubladoLlueve()[0];
        double rP = (double) totalNublado / dS.getTotalDias();
        return totalNublado + "/" + dS.getTotalDias() + " = " + rP;
    }
    public String pMarginalBP(){
        totalNublado = dS.getNubladoNoLlueve()[0] + dS.getNoNubladoNoLlueve()[0];
        double rP = (double) totalNublado / dS.getTotalDias();
        return totalNublado + "/" + dS.getTotalDias() + " = " + rP;
    }
}