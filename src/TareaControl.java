public class TareaControl {
    private String nombre;
    private String respuesta;

    public TareaControl(String nombre) {
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Tarea: " + nombre;
    }
}
