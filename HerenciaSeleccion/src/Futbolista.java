public class Futbolista extends SeleccionFutbol {
    private int dorsal;
    private String posicion;
    public Futbolista(int id, String Nombre, String Apellidos, int Edad, int dorsal, String posicion) {
        super(id, Nombre, Apellidos, Edad);
        this.dorsal = dorsal;
        this.posicion = posicion;
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
    public void jugarPartido(){
        System.out.println("-------------------------");
        System.out.println("       Futbolista         ");
        System.out.println("Estoy jugando un partido");
        System.out.println("-------------------------");
    }
    public void entrenar(){
        System.out.println("-------------------------");
        System.out.println("       Futbolista         ");
        System.out.println("Estoy entrenando");
        System.out.println("-------------------------");
    }
}
