public class ExcepcionContinua {
    static void divide() {
        int num[] = {4,8,16,32,64,128,256};
        //int den[] = {2,0,4,4,0,8,16};
        int den[] = {2,0,4,4,0,8};

        for (int i=0; i<num.length + 1; i++){
            try{
                System.out.println(num[i] + " / " + den[i] + " = " + num[i] / den[i]);
            } catch (java.lang.ArithmeticException exception){
                System.out.println("Dividiendo por cero");
            }
            catch (java.lang.ArrayIndexOutOfBoundsException exception){
                System.out.println("Error al accesar el vector");
            }
        }
    }
}

class PruebaExcepcionContinua {
    public static void main(String[] args) {
        ExcepcionContinua.divide();
    }
}

