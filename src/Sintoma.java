public class Sintoma {
    private String nombre;

    public Sintoma(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Sintoma: " + nombre;
    }
}
