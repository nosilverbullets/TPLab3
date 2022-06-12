public class Enfermedad {
    private static int contadorid = 0;
    private int id;
    private String nombre;

    public Enfermedad(String nombre) {
        this.nombre = nombre;
        this.id = contadorid++;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Enfermedad [" + id + "] " + nombre;
    }
}
