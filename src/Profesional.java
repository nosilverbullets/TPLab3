import java.util.ArrayList;

public class Profesional extends Usuario{
    private String licencia;
    private List<Control> listaControles;
    private ArrayList<Paciente> listaPacientes; // Los pacientes asignados por Admin

    public Profesional(UsuarioTipo tipoUsuario, String email, String contrasena, String dni, String direccion,
                       String localidad, String telefono, String licencia) {
        super(tipoUsuario, email, contrasena, dni, direccion, localidad, telefono);
        this.licencia = licencia;
        this.listaPacientes = new ArrayList<>();
    }


    public void verListadoControles(){
        // TODO Puede ver un listado de controles y elegir un plan para aplicar
    }
    public boolean asignarControl(Paciente paciente){
        // TODO Asigna un "Control" a un paciente
        return true; // si fue asignado correctamente
    }
    public void verControlPaciente(){
        // TODO Ver el estado del control del paciente
    }
    public void terminarControl(){
        // TODO dar alta "logico", listaEnfermedad = ninguna
    }


}
