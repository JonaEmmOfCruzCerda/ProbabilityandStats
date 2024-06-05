public class PiscinaNivelException extends Exception{
    int nivel;
    public PiscinaNivelException (String descripcion, int valor){
        super (descripcion);
        nivel = valor;
    }
}
