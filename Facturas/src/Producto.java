import java.util.ArrayList;

public class Producto {
    private int id;
    private String descripcion;
    private float precio;
    private static ArrayList<Producto> listarProductos = new ArrayList<>();

    public Producto(int id, String descripcion, float precio){
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public static void agregar(int id, String descripcion, float precio){
        Producto producto = new Producto(id, descripcion, precio);
        listarProductos.add(producto);
    }
    public static Producto buscar(int id){
        for (Producto producto : listarProductos){
            if (producto.getId() == id){
                return producto;
            }
        }
        return null;
    }
    public String toString() {
        return id + "," + descripcion + "," + precio;
    }
}
