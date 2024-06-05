public class Piscina {
    private int nivel;
    public final int MAX_NIVEL;

    public Piscina (int max){
        if(max<0)
            max=0;
        MAX_NIVEL = max;
    }
    public int getNivel() {
        return nivel;
    }
    public void vaciar(int cantidad) throws  PiscinaNivelException{
        if (nivel - cantidad < 0){
            throw new PiscinaNivelException("Vaciado excesivo", nivel - cantidad);
        } else {
            nivel = nivel - cantidad;
        }
    }
    public void llenar(int cantidad) throws PiscinaNivelException{
        if (nivel + cantidad > MAX_NIVEL){
            throw new PiscinaNivelException("Llenado excesivo", nivel + cantidad);
        } else {
            nivel = nivel + cantidad;
        }
    }
}
