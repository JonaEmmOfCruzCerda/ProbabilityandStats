import java.util.ArrayList;
import java.util.List;

public class Permutacion {
    public List<String> getPermutaciones(String[] permutacion) {
        List<String> results = new ArrayList<>(); // Es la lista donde se almacena las permutaciones
        if (permutacion == null || permutacion.length == 0) {
            return results; // Se almacena las permutaciones
        }
        permute(permutacion, 0, results); // Genera las permutaciones
        return results;
    }

    private void permute(String[] permutacion, int index, List<String> results) {
        if (index == permutacion.length) { // Verifica si se alcanzo la longitud del arreglo
            results.add(String.join("", permutacion)); // Agrega a la lista los resultados
            return;
        }
        for (int i = index; i < permutacion.length; i++) {
            swap(permutacion, index, i);
            permute(permutacion, index + 1, results); //  Genera todas las permutaciones a partir de la posición siguiente
            swap(permutacion, index, i); // Restaura el arreglo
        }
    }

    private void swap(String[] permutacion, int i, int j) { // Intercambia las posiciones de las letras
        String temp = permutacion[i];
        permutacion[i] = permutacion[j];
        permutacion[j] = temp;
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}