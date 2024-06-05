public class SeleccionFutbol {
    protected int id;
    protected  String Nombre;
    protected  String Apellidos;
    protected int Edad;
    public SeleccionFutbol(int id, String Nombre, String Apellidos, int Edad){
        this.id = id;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Edad = Edad;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }
    public String getApellidos() {
        return Apellidos;
    }
    public void setEdad(int edad) {
        Edad = edad;
    }
    public int getEdad() {
        return Edad;
    }
    public void Concentrarse(){
    }
    public void Viajar(){
    }
}
