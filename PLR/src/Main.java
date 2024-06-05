public class Main {
    public static void main(String[] args){
        DataSet dataSet = new DataSet();
        DiscreteMaths dM = new DiscreteMaths();
        double[] x = dataSet.getX();
        double[] y = dataSet.getY();
        double[] SLR = dM.SLR(x, y);
        double[] QLR = dM.QLR(x, y);
        double[] CLR = dM.CLR(x, y);


        System.out.println("Ecuaciones de Regresion Polinomiales");
        double[] rcuadradaL = PLR.rsqSLR(x, SLR);
        double rSL = PLR.rcuadrada(y, rcuadradaL);
        double r2SL = rSL / 100;
        double rl = Math.sqrt(r2SL);
        System.out.println("Lineal: ");
        System.out.println("Machine Efficiency % = "+ String.format("%.2f", SLR[0]) + " + " + String.format("%.4f", SLR[1]) + " Batch Size");
        System.out.println("R-sq: " + String.format("%.1f%%", rSL));
        System.out.println("Coeficiente de correlacion: " + String.format("%.2f%%", rl));
        System.out.println("Coeficiente de determinacion: " + String.format("%.2f%%", r2SL));
        System.out.println();

        double[] rcuadradaQ = PLR.rsqQLR(x, QLR);
        double rSQ = PLR.rcuadrada(y, rcuadradaQ);
        double r2SQ = rSQ / 100;
        double rq = Math.sqrt(r2SQ);
        System.out.println("Cuadratica: ");
        System.out.println("Machine Efficiency % = " + String.format("%.2f", QLR[0]) + " + " + String.format("%.4f", QLR[1]) + " Batch Size " + String.format("%.6f", QLR[2]) + " Batch Size^2");
        System.out.println("R-sq: " + String.format("%.1f%%", rSQ));
        System.out.println("Coeficiente de correlacion: " + String.format("%.2f%%", rq));
        System.out.println("Coeficiente de determinacion: " + String.format("%.2f%%", r2SQ));
        System.out.println();


        double[] rcuadradaC = PLR.rsqCLR(x, CLR);
        double rSC = PLR.rcuadrada(y, rcuadradaC);
        double r2SC = rSC / 100;
        double rc = Math.sqrt(r2SC);
        System.out.println("Cubica:");
        System.out.println("Machine Efficiency % = " + String.format("%.2f", CLR[0]) + " " + String.format("%.4f", CLR[1]) + " Batch Size + " + String.format("%.5f", CLR[2]) + " Batch Size^2 " + String.format("%.6f", CLR[3]) + " Batch Size^3");
        System.out.println("R-sq: " + String.format("%.1f%%", rSC));
        System.out.println("Coeficiente de correlacion: " + String.format("%.2f%%", rc));
        System.out.println("Coeficiente de determinacion: " + String.format("%.2f%%", r2SC));
        System.out.println();

        double[] vC = {50,40,30,20,10};
        double[] vD = {100,90,80,70,60};

        double[] lC = PLR.rsqSLR(vC, SLR);
        double[] lD = PLR.rsqSLR(vD, SLR);
        double[] qC = PLR.rsqQLR(vC, QLR);
        double[] qD = PLR.rsqQLR(vD, QLR);
        double[] cC = PLR.rsqCLR(vC, CLR);
        double[] cD = PLR.rsqCLR(vD, CLR);

        System.out.println("Prediccion de valores conocidos");
        System.out.println("Lineal: ");
        for (int i=0; i<vC.length; i++){
            System.out.println("x = " + vC[i] + " Y = " + lC[i]);
        }
        System.out.println();

        System.out.println("Cuadratica: ");
        for (int i=0; i<vC.length; i++){
            System.out.println("x = " + vC[i] + " Y = " + qC[i]);
        }
        System.out.println();

        System.out.println("Cubica: ");
        for (int i=0; i<vC.length; i++){
            System.out.println("x = " + vC[i] + " Y = " + cC[i]);
        }
        System.out.println();

        System.out.println("Prediccion de valores desconocidos");
        System.out.println("Lineal: ");
        for (int i=0; i<vD.length; i++){
            System.out.println("x = " + vD[i] + " Y = " + lD[i]);
        }
        System.out.println();

        System.out.println("Cuadratica: ");
        for (int i=0; i<vC.length; i++){
            System.out.println("x = " + vD[i] + " Y = " + qD[i]);
        }
        System.out.println();

        System.out.println("Cubica: ");
        for (int i=0; i<vC.length; i++){
            System.out.println("x = " + vD[i] + " Y = " + cD[i]);
        }
        System.out.println();

    }
}