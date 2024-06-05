public class Entrenador extends SeleccionFutbol {
    private  String idFederacion;
    public Entrenador(int id, String Nombre, String Apellidos, int Edad, String idFederacion) {
        super(id, Nombre, Apellidos, Edad);
        this.idFederacion = idFederacion;
    }
    @Override
    public int getId() {
        return super.getId();
    }
    @Override
    public void setId(int id) {
        super.setId(id);
    }
    @Override
    public String getNombre() {
        return super.getNombre();
    }
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }
    @Override
    public String getApellidos() {
        return super.getApellidos();
    }
    @Override
    public void setApellidos(String apellidos) {
        super.setApellidos(apellidos);
    }
    @Override
    public int getEdad() {
        return super.getEdad();
    }
    @Override
    public void setEdad(int edad) {
        super.setEdad(edad);
    }
    public void dirigirPartido(){
        System.out.println("-------------------------");
        System.out.println("       Entrenador         ");
        System.out.println("Dirigiendo un partido");
        System.out.println("-------------------------");
    }
    public void dirigirEntreno(){
        System.out.println("-------------------------");
        System.out.println("       Entrenador         ");
        System.out.println("Dirigiendo entrenamiento");
        System.out.println("-------------------------");
    }
}
