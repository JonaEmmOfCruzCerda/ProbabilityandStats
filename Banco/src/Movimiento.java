import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Movimiento {
    public double cantidad;
    public Date fecha;
    public String descripcion;

    public Movimiento(double cantidad, Date fecha, String descripcion){
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
        return "Movimiento" + "\n" +
                "Cantidad: " + cantidad + "\n" +
                "Fecha: " + formatter.format(fecha) + "\n" +
                "Descripción: '" + descripcion + "\n";
    }
}
