public class TareaControl {
    private static int contadorid = 0;
    private int id;
    private String nombre;
    private String respuesta;

    public TareaControl(String nombre) {
        this.nombre = nombre;
        this.id = contadorid++;
        this.respuesta = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tarea [" + id + "] " + nombre ;
    }
}