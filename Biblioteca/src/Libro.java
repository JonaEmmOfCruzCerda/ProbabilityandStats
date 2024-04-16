import java.util.ArrayList;
public class Libro {
    private int isbn;
    private String titulo;
    private String edicion;
    private String genero;
    private Editorial editorial;
    private ArrayList<Autor> autores;
    public Libro (int isbn, String titulo, String edicion, String genero, Editorial editorial, ArrayList autores){
        this.isbn = isbn;
        this.titulo = titulo;
        this.edicion = edicion;
        this.genero = genero;
        this.editorial = editorial;
        this.autores = autores;
    }
    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getEdicion() {
        return edicion;
    }
    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public Editorial getEditorial() {
        return editorial;
    }
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    public ArrayList<Autor> getAutores() {
        return autores;
    }
    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }
}
