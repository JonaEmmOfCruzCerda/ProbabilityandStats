import java.util.ArrayList;

import java.util.ArrayList;

public class Factura {
    private int id;
    private Fecha fechaFactura;
    private float subTotal, iva, total;
    private ArrayList<Producto> productos;
    private Vendedor vendedor;
    private Cliente cliente;

    public Factura(int id, Fecha fechaFactura, Cliente cliente, Vendedor vendedor, float subTotal, float iva, float total){
        this.id = id;
        this.fechaFactura = fechaFactura;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.productos = new ArrayList<>();
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
    }

    public float getSubTotal() {
        return subTotal;
    }
    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }
    public float getIva() {
        return iva;
    }
    public void setIva(float iva) {
        this.iva = iva;
    }
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }
    public void eliminarProducto(Producto producto){
        productos.remove(producto);
    }

    public double calcularSubTotal(){
        double subtotal = 0;
        for (Producto producto : productos){
            subtotal += producto.getPrecio();
        }
        return subtotal;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura ID: ").append(id).append(", Fecha: ").append(fechaFactura);
        sb.append(", Cliente: ").append(cliente.getNombre());
        sb.append(", Vendedor: ").append(vendedor.getNombre());
        sb.append(", Total: ").append(total);
        sb.append(", Productos: ");
        for (Producto producto : productos) {
            sb.append(producto.getDescripcion()).append(", ");
        }
        return sb.toString();
    }
}

