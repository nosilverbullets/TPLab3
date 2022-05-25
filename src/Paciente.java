import java.util.ArrayList;

public class Paciente extends Usuario {
    private String historial;
    private String enfermedad;
    private Control controles;
    private ArrayList<Registro> registroTratamiento;

    public Paciente(UsuarioTipo tipoUsuario, String email, String contrasena, String dni,
                    String direccion, String localidad, String telefono, ListaEnfermedad enfermedad,Control esteControl) {
        super(tipoUsuario, email, contrasena, dni, direccion, localidad, telefono);
        this.enfermedad = "Undefined";
        this.controles = esteControl;
    }


    public void completarControl(){
        // TODO Poder completar el control, las N veces que dure el control
    }

    public void editarControl(){
        // TODO edita el "control" del dia actual
    }

    public void historialControl(){
        // TODO Ver historial de controles / enfermedad
    }


}
