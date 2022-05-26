import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    private String nombreDoctorResponsable;
    public ArrayList<TareaControl> tareas;
    private LocalDate fecha;


    public Control() {
        this.tareas = new ArrayList<>();
    }

    public void setNombreDoctorResponsable(String nombreDoctorResponsable) {
        this.nombreDoctorResponsable = nombreDoctorResponsable;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void agregarTarea(TareaControl tarea){
        this.tareas.add(tarea);
    }

    @Override
    public String toString() {
        return "Control{" +
                "Profesional: " + nombreDoctorResponsable +
                " - Tareas: " + tareas +
                " - Fecha: " + fecha +
                '}';
    }
}
