import java.util.Date;

public class Cliente {
    private String nombre, apellidos, domicilio, ciudad, telefono;

    public Cliente(String nombre, String apellidos, String domicilio, String ciudad, String telefono){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public String getCiudad() {
        return ciudad;
    }
    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

