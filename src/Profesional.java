import java.util.ArrayList;

public class Profesional extends Usuario {
    private static int contadorid = 0;
    private int id;
    private int especialidad;
    private int contadorOrdenesGeneradas = -1;
    private ArrayList<Integer> listaPacientesNuevosID; // Los pacientes asignados por Admin
    private ArrayList<Integer> listaPacientesEnTratamiendoID; // Los pacientes asignados por Admin
    private boolean activo;

    public Profesional(String nombre, String email, String clave, String dni, int especialidadID) {
        super(nombre, email, clave, dni);
        this.tipoUsuario = TipoUsuario.profesional;
        this.listaPacientesNuevosID = new ArrayList<>();
        this.listaPacientesEnTratamiendoID = new ArrayList<>();
        this.especialidad = especialidadID;
        this.id = contadorid++;
        this.activo = true;
    }

    public int getContadorOrdenesGeneradas() {
        return contadorOrdenesGeneradas;
    }

    public void setContadorOrdenesGeneradas() {
        this.contadorOrdenesGeneradas ++;
    }

    public int getID() {
        return id;
    }

    public boolean estaActivo() {
        return activo;
    }

    public void setActivo(boolean estado) {
        this.activo = estado;
    }

    public String estadoActivo(){
        if (this.activo){
            return "Activo";
        }else{
            return "Inactivo";
        }
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void agregarPacientesProfesionalID(Integer id) {
        this.listaPacientesNuevosID.add(id);
    }

    public ArrayList<Integer> getListaPacientesNuevosID() {
        return listaPacientesNuevosID;
    }

    public void borrarPacienteNuevoID(int idPaciente){
        listaPacientesNuevosID.remove(idPaciente);
    }

    public ArrayList<Integer> getListaPacientesEnTratamiendoID() {
        return listaPacientesEnTratamiendoID;
    }

    public void agregarListaPacientesEnTratamiendoID(Integer idPaciente) {
        this.listaPacientesEnTratamiendoID.add(idPaciente);
    }



    @Override
    public String toString() {
        return "\nID [" + id + "] " + nombre +
                "\nEspecialidad: " + especialidad +
                "\nPacientes: " + listaPacientesNuevosID +
                "\nEstado: " + estadoActivo() +
                "\nCorreo: " + email +
                "\nDNI: " + dni;
    }
}
