import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Paciente extends Usuario {
    public ArrayList<Control> listaControl;
    private ListaEnfermedad enfermedad;

    public Paciente(UsuarioTipo tipoUsuario, String email, String contrasena, String dni, String direccion, String localidad, String telefono, ListaEnfermedad enfermedad) {
        super(tipoUsuario, email, contrasena, dni, direccion, localidad, telefono);
        this.listaControl = new ArrayList<>();
        this.enfermedad = enfermedad;
    }

    public void verControles(){
        for (Control c: listaControl){
            System.out.println(c);
        }
    }

    public Control getControlHoy(){
        Control aux = null;
        for (Control c: listaControl){
            if (c.getFecha().equals(LocalDate.now())){
                aux = c;
            }
        }
        return aux;
    }

    public void verControlHoy(){
        for (Control c: listaControl){
            if (c.getFecha().equals(LocalDate.now()))
                System.out.println(c);
        }
    }

    public void agregarListaControl(Control control){
        listaControl.add(control);
    }



}
