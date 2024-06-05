import java.io.*;
public class Archivos2 {
    public static void main(String[] args){
        File f = new File("numeros.txt"); // Carga el archivo
        try {
            FileWriter fw = new FileWriter(f, true); // Crea el flujo hacia f
            PrintWriter pw = new PrintWriter(fw); // Permite la escritura en el archivo
            for (int i=1; i<=20; i++){
                pw.println(i); // Introduce el valor de i en el archivo
            }
            fw.close();
        } catch (IOException e) {
            e.getMessage();
            System.out.println("Error");
        }
    }
}