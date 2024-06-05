import java.io.*;
public class Archivos1 {
    public static void main(String [] args){
        File f = new File("numeros.txt"); // Carga el archivo
        try {
            FileReader fr = new FileReader(f); //Crea el flujo hacia f
            BufferedReader br = new BufferedReader(fr); // Permite la lectura
            String linea = br.readLine(); // Linea toma el valor de la primera linea
            while (linea != null){ // Mientras haya datos en el archivo
                System.out.println(linea);
                linea = br.readLine();
            }
            fr.close(); // Cierra el archivo
        } catch (IOException e) {
            e.getMessage();
            System.out.println("Error"); // Si no se puedo acceder al archivo
        }
    }
}