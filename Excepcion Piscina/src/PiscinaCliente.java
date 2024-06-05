public class PiscinaCliente {
    public static void operacionesPiscina(Piscina P){
        try {
            for (int i=1; i<=3; i++){
                P.llenar((int) (Math.random() * 100));
                System.out.println("Llenado... " + P.getNivel());
                P.vaciar((int) (Math.random() * 100));
                System.out.println("vaciado... " + P.getNivel());
            }
        } catch (PiscinaNivelException e){
            System.out.println(e.toString() + ' ' + e.nivel);
        }
        System.out.println("El nivel de la piscina es... " + P.getNivel());
    }

    public static void main (String[] args){
        Piscina P = new Piscina(100);
        operacionesPiscina(P);
    }
}
