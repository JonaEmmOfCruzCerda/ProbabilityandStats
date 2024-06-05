public class Masajista extends SeleccionFutbol{
    private String Titulacion;
    private  int aniosExperiencia;
    public Masajista(int id, String Nombre, String Apellidos, int Edad, String Titulacion, int aniosExperiencia) {
        super(id, Nombre, Apellidos, Edad);
        this.Titulacion = Titulacion;
        this.aniosExperiencia = aniosExperiencia;
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
    public void darMasaje(){
        System.out.println("-------------------------");
        System.out.println("       Masajista         ");
        System.out.println("Estoy dando masajes");
        System.out.println("-------------------------");
    }
}
