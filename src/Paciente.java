import java.time.LocalDate;
import java.util.ArrayList;

public class Paciente extends Usuario {
    private static int contadorid = 0;
    private int id;
    private int especialidadID; // Se ingresa bajo especialidad, se determina enfermedad via profesional

    private boolean activo;

    public ArrayList<Orden> listaOrdenes; //

    public Paciente(String nombre, String email, String clave, String dni, int especialidadID) {
        super(nombre, email, clave, dni);
        this.id = contadorid++;
        this.tipoUsuario = TipoUsuario.paciente;
        this.especialidadID = especialidadID;
        this.listaOrdenes = new ArrayList<>();
        this.activo = true;
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

    public int getEspecialidad(){
        return this.especialidadID;
    }

    public void agregarListaOrden(Orden orden){
        listaOrdenes.add(orden);
    }

    public boolean verOrdenHoy(){
        boolean aux = false;
        for (Orden c: listaOrdenes){
            if (c.getEstado().equals(true) && c.getFecha().equals(LocalDate.now())){
                aux = true;
                System.out.println(c);
            }
        }
        return aux;
    }

    public boolean notificacion(){
        for (Orden c: listaOrdenes){
            if (c.getEstado().equals(true) && c.getFecha().equals(LocalDate.now())){
                return true;
            }
        }
        return false;
    }

    public void verOrdenes(){
        for (Orden c: listaOrdenes){
            if (c.getEstado().equals(true)){
                System.out.println(c);
            }
        }
    }

    public void verOrdenesVigentes(){
        for (Orden c: listaOrdenes){
            if (c.getEstado().equals(true) && !c.getFecha().isBefore(LocalDate.now())){
                System.out.println(c);
            }
        }
    }

    public void altaPaciente(int idProfesional, int idOrden){
        for (Orden c: listaOrdenes){
            if (c.getIdProfesional() == idProfesional && c.getId() == idOrden){
                c.setEstado(false);
            }

        }
    }

    public void completarTareaHoy(){
        for (Orden c: listaOrdenes){
            if (c.getEstado().equals(true) && c.getFecha().equals(LocalDate.now())){
                c.getControl().completarTareaControl();
            }
        }
    }

    @Override
    public String toString() {
        return "\nID [" + id + "] " + nombre +
                "\nEspecialidad requerida: " + especialidadID +
                "\nEstado: " + estadoActivo() +
                "\nEmail: " + email +
                "\nDNI: " + dni ;
    }
}
