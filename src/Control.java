import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/// VA A TRABAJAR EN CONJUNTO CON UN REGISTRO.
public class Control{
    private String nombreControl;
    protected LinkedList<TareaControl> tareaControl;


    public Control(String nombreControl) {
        this.nombreControl = nombreControl;
        this.tareaControl = new LinkedList<>();
    }
    public void agregarTareaControl(TareaControl tarea){
        this.tareaControl.add(tarea);
    }

    public String getNombreControl() {
        return nombreControl;
    }

    public void setNombreControl(String nombreControl) {
        this.nombreControl = nombreControl;
    }

    public LinkedList<TareaControl> getTareaControl() {
        return tareaControl;
    }

    public void setTareaControl(LinkedList<TareaControl> tareaControl) {
        this.tareaControl = tareaControl;
    }
}