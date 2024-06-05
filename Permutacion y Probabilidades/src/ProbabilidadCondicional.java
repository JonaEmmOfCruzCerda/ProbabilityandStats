public class ProbabilidadCondicional {
    DataSet dS = new DataSet();
    int numerador, denominador;

    public ProbabilidadCondicional(DataSet dS){
        this.dS = dS;
    }

    public String pCondicionalBA(){
        numerador = dS.getNubladoLlueve()[0];
        denominador = dS.getNubladoLlueve()[0] + dS.getNubladoNoLlueve()[0];
        double p = (double) numerador / denominador;
        return numerador + "/" + denominador + " = " + p;
    }

    public String pCondicionalBAP(){
        numerador = dS.getNoNubladoLlueve()[0];
        denominador = dS.getNubladoLlueve()[0] + dS.getNubladoNoLlueve()[0];
        double p = (double) numerador / denominador;
        return numerador + "/" + denominador + " = " + p;
    }

    public String pCondicionalBPA(){
        numerador = dS.getNubladoNoLlueve()[0];
        denominador = dS.getNubladoLlueve()[0] + dS.getNubladoNoLlueve()[0];
        double p = (double) numerador / denominador;
        return numerador + "/" + denominador + " = " + p;
    }

    public String pCondicionalBPAp(){
        numerador = dS.getNoNubladoNoLlueve()[0];
        denominador = dS.getNoNubladoLlueve()[0] + dS.getNoNubladoNoLlueve()[0];
        double p = (double) numerador / denominador;
        return numerador + "/" + denominador + " = " + p;
    }

    public String pCondicionalAB(){
        numerador = dS.getNubladoLlueve()[0];
        denominador = dS.getNubladoLlueve()[0] + dS.getNoNubladoLlueve()[0];
        double p = (double) numerador / denominador;
        return numerador + "/" + denominador + " = " + p;
    }

    public String pCondicionalABp(){
        numerador = dS.getNubladoNoLlueve()[0];
        denominador = dS.getNubladoNoLlueve()[0] + dS.getNoNubladoNoLlueve()[0];
        double p = (double) numerador / denominador;
        return numerador + "/" + denominador + " = " + p;
    }
}