public abstract class TareaControl {

    protected String nombreTarea;
    protected String descripcion;

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    abstract String completarTarea();
///FUNCION CUSTOM DE COMPLETADO
}
