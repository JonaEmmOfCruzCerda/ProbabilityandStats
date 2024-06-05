public class Pentagono extends Figura{
    private double lado;

    public Pentagono(double x, double y, double lado){
        super(x, y);
        this.lado = lado;
    }
    @Override
    public double area() {
        return perimetro() * apotema() /2;
    }
    @Override
    public double perimetro() {
        return 5 * lado;
    }
    private  double apotema(){
        return lado / (2 * Math.tan(Math.PI/5));
    }
}
