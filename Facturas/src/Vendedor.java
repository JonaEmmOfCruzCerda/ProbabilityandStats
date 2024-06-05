import java.util.ArrayList;

public class Vendedor extends Persona{
    private int id;
    private String area;
    private float porcentajeComision;
    private int sueldoBase;
    private ArrayList<Factura> facturas;

    public Vendedor(int id, String nombre, String apellidoPaterno, String apellidoMaterno, Fecha fechaNacimiento, String area, float porcentajeComision, int sueldoBase) {
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
        this.id = id;
        this.area = area;
        this.porcentajeComision = porcentajeComision;
        this.sueldoBase = sueldoBase;
        this.facturas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public float getPorcentajeComision() {
        return porcentajeComision;
    }
    public void setPorcentajeComision(float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }
    public int getSueldoBase() {
        return sueldoBase;
    }
    public void setSueldoBase(int sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public float calcularComision(){
        return sueldoBase * (porcentajeComision / 100);
    }
    public void agregarFactura(Factura factura) {
        this.facturas.add(factura);
    }
    public String toString() {
        return "Vendedor: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno + ", Fecha de Nacimiento: " + fechaNacimiento + ", Área: " + area + ", Porcentaje de Comisión: " + porcentajeComision + ", Sueldo Base: " + sueldoBase;
    }
}
