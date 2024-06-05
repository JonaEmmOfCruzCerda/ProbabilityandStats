import java.util.ArrayList;

public class Cliente extends Persona {
    private int id;
    private String rfc;
    private String domicilio;
    private ArrayList<Factura> compras;

    public Cliente(int id, String nombre, String apellidoPaterno, String apellidoMaterno, Fecha fechaNacimiento, String rfc, String domicilio) {
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
        this.id = id;
        this.rfc = rfc;
        this.domicilio = domicilio;
        this.compras = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public ArrayList<Factura> getCompras() {
        return compras;
    }

    public void comprar(Factura factura) {
        compras.add(factura);
    }

    public static Cliente buscarClientePorId(int id, ArrayList<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}
