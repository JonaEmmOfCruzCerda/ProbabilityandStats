public class Ciclos {

    private int x, i;
    private int suma = 0;
    public Ciclos(){}

    public Ciclos(int suma){
        this.suma = suma;
    }

    public int sumatoria10(){
        for(x=1; x<11; x++){
            suma += x;
        }
        return suma;
    }

    public int sumatoriaDe5(){
        for (int x = 5; x <= 100; x += 5) {
            suma += x;
            System.out.print(x + " + ");
        }
        return suma;
    }

    public static void tablaDeMultiplicar(int num){
        for(int x=1; x<=10; x++){
            System.out.println(num + " x " + x + " = " + num * x);
        }
    }

    public int numerosPrimos(int numP){
        for(x=2; x<= numP; x++){
            i=2;
            while (x%i !=0){
                i++;
            }
            if(i==x){
                System.out.println(x);
            }
        }
        return x;
    }

    public double factorial(double n){
        double factorial = 1;
        for(i=2; i<=n; i++){
            factorial *= i;
        }
        return factorial;
    }

    public void numeroImpar(int numI) {
        for (int i = 1; i <= 2 * numI; i += 2) {
            System.out.println("El " + i + " es un número impar");
        }
    }

    public boolean numeroPerfecto(int n) {
        if (n <= 1) {
            return false;
        }
        int suma = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                suma += i;
            }
        }
        return suma == n;
    }

    public boolean numerosAmigos(int n1, int n2){
        return (sumaDivisores(n1) == n2) && (sumaDivisores(n2) == n1);
    }

    private int sumaDivisores(int num){
        int suma = 0;
        for(int i = 1; i <= num / 2; i++){
            if(num % i == 0){
                suma += i;
            }
        }
        return suma;
    }

    public int elevar(int base, int exponente) {
        int resultado = 1;
        for(int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        return resultado;
    }

    public double calcularEx(int x) {
        double eToX = 1;
        int num = 100; // Número de términos
        double factorial = 1;
        double potencia = 1;
        for(int i = 1; i <= num; i++) {
            factorial *= i;
            potencia *= x;
            eToX += potencia / factorial;
        }
        return eToX;
    }
}
