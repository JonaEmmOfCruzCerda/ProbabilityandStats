import java.util.List;

public class Main {
    public static void main (String[] args){
        DataSet dS = new DataSet();
        Permutacion p = new Permutacion();
        ProbabilidadMarginal pM = new ProbabilidadMarginal(dS);
        ProbabilidadConjunta pC = new ProbabilidadConjunta(dS);
        ProbabilidadCondicional pCo = new ProbabilidadCondicional(dS);


        String[] permutacion = dS.getPermutacion();
        List<String> permuta = p.getPermutaciones(permutacion);
        int n = permutacion.length;
        int factorial = p.factorial(n);
        System.out.println("       Permutaciones       ");
        System.out.println("Factorial de " + n + " (" + n + "!): " + factorial);
        System.out.println();

        int count = 1;
        for (String perm : permuta) {
            System.out.println(count + ". " + perm);
            count++;
        }

        System.out.println();
        System.out.println("     Probabilidades \n ");
        System.out.println("Probabilidad Marginal");
        System.out.println("P(A): " + pM.pMarginalA());
        System.out.println("P(A`): " + pM.pMarginalAP());
        System.out.println("P(B): " + pM.pMarginalB());
        System.out.println("P(B`): " + pM.pMarginalBP());
        System.out.println();

        System.out.println("Probabilidad Conjunta");
        System.out.println("P(A∩B): " + pC.pConjuntaAB());
        System.out.println("P(A∩B`): " + pC.pConjuntaABP());
        System.out.println("P(A`∩B): " + pC.pConjuntaAPB());
        System.out.println("P(A`∩ B`): " + pC.pConjuntaAPBP());
        System.out.println();

        System.out.println("Probabilidad Condicional");
        System.out.println("P(B|A): " + pCo.pCondicionalBA());
        System.out.println("P(B|A`): " + pCo.pCondicionalBAP());
        System.out.println("P(B`|A): " + pCo.pCondicionalBPA());
        System.out.println("P(B`|A`): " + pCo.pCondicionalBPAp());
        System.out.println("P(A|B): " + pCo.pCondicionalAB());
        System.out.println("P(A|B`): " + pCo.pCondicionalABp());
    }
}