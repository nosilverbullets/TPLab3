import java.time.LocalDate;

public class Orden {
    private int id; // Lo asigna el profesional al crear la orden para facilitar el alta
    private Control control;
    private LocalDate fecha;
    private Boolean estado;
    private int idProfesional;

    public Orden() {
        this.estado = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public int getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }

    @Override
    public String toString() {
        return "\nTratamiento ID [" + id + "] " +
                control +
                "\nFecha: " + fecha +
                "\nProfesional ID [" + idProfesional + "] ";
    }
}
