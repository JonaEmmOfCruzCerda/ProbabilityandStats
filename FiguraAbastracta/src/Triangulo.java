public class Triangulo extends Figura{
    private double lado;
    public Triangulo(double x, double y, double lado){
        super(x, y);
        this.lado = lado;
    }
    @Override
    public double area() {
        return (lado * altura() /2);
    }
    @Override
    public double perimetro() {
        return 3 * lado;
    }
    private double altura(){
        return (Math.sqrt(3)/ 2) * lado;
    }
}