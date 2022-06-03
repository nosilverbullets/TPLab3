import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class Paciente extends Usuario {
    private String enfermedad;
    private Control controlEstablecido;
    protected LinkedList<Registro> registroTratamiento;
    private LocalDate fechaInicio;
    private LocalDate fechaFIN;

    public Paciente(UsuarioTipo tipoUsuario, String email, String contrasena, String dni, Control esteControl) {
        super(tipoUsuario, email, contrasena, dni);
        this.enfermedad = "Undefined";
        this.controlEstablecido = esteControl;
        this.registroTratamiento = new LinkedList<>();
        this.fechaInicio = null;
        this.fechaFIN = null;
    }

///FUNCION COMPLETAR TODAS LAS TAREAS SE GUARDARA LAS REPSUESTAS EN UN STRING BUILDER.
// /FUCION CHECKEA SI COMPLETO TODAS LAS TAREAS O NO
    ///FUNCION CREA REGISTRO PARA ALMARZENAR EN ELUSUARIO.

    public void completarControl() {
        StringBuilder auxUsuario = new StringBuilder();
        Registro auxRegistro = registroTratamiento.getLast();
        int contador = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Usted Empezara a completar el plan de control");
        System.out.println("En caso que desee cancelar el plan ingrese 0");

        for (TareaControl x : controlEstablecido.tareaControl) {
            System.out.println("INGRESE : " + x.descripcion);
            System.out.println("Completar?");
            short continuar = scan.nextShort();
            while (true) {
                try {
                    if (continuar != 0) {
                        auxUsuario.append(x.completarTarea());
                        contador++;
                        break;
                    }
                } catch (NumberFormatException a) {
                    System.out.println("No ingreso numero volver a intentar");
                }
            }
        }
        if (contador == controlEstablecido.tareaControl.size()) {
            auxRegistro.setCompletoRegistro(true);
            auxRegistro.setSintomasCompletados(auxRegistro.toString());
            System.out.println("Usted completo el Resistro Diario!!!");
        } else {
            auxRegistro.setSintomasCompletados(auxUsuario.toString());
            System.out.println("Quedaron datos sin completar");
        }

    }


    public void editarControl() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Desea volver a completar el registro?");
        System.out.println("Recuerde que debera completarlo en su totalidad nuevamente en caso de que asi lo desee");
        short opcion = scan.nextShort();
        try {


            switch (opcion) {
                case 1:
                    completarControl();
                    break;
                case 2:
                    System.out.println("Volvemos al menu inicial");
                    /// llamado al menu
                    break;
                default:
                    System.out.println("opcion invalida se volvera el menu");
                    break;
            }

        } catch (NumberFormatException a) {
            System.out.println("NO INGRESO NUMERO");
            editarControl();
        }
    }

    public void historialControl() {
        if ((registroTratamiento != null)) {
            if (!registroTratamiento.getLast().completoRegistro) {
                System.out.println("Usted Posse un registro diario para completar.");
                System.out.println("El plan de control finaliza el : " + fechaFIN);
            } else {
                System.out.println("Usted no ah iniciado aun un plan de control");
            }
        }


    }

    public void iniciarlizarRegistroDiario(){
        Registro nuevoRegistro = new Registro();
        this.registroTratamiento.add(nuevoRegistro);
    }
    ///FUNCION DIARIA DONDE SE AGREGAN NUEVOS REGISTROS DIARIOS A TODOS LOS PACIENTES ACTIVOS.


    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Control getControlEstablecido() {
        return controlEstablecido;
    }

    public void setControlEstablecido(Control controlEstablecido) {
        this.controlEstablecido = controlEstablecido;
    }

    public LinkedList<Registro> getRegistroTratamiento() {
        return registroTratamiento;
    }

    public void setRegistroTratamiento(LinkedList<Registro> registroTratamiento) {
        this.registroTratamiento = registroTratamiento;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFIN() {
        return fechaFIN;
    }

    public void setFechaFIN(LocalDate fechaFIN) {
        this.fechaFIN = fechaFIN;
    }

}