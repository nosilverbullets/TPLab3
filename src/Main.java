import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Usuario> listadoUsuarios = new ArrayList<>();
        Admin admin = new Admin(UsuarioTipo.admin, "administrador@clinica-colon.com", "123456", "33898687", "Colon 4190", "Mar del Plata", "223456789");
        Profesional profesional = new Profesional(UsuarioTipo.profesional, "doctor1@clinicacolon.com", "123456", "13092520", "Salta 2390", "Mar del Plata", "223456123", "001");
        Paciente paciente = new Paciente(UsuarioTipo.paciente, "ramiro54@gmail.com", "abc123", "38005813", "Arenales 50", "Mar del Plata", "2236954956", ListaEnfermedad.covid);


        System.out.println("Creando lista de tareas...");
        ArrayList<TareaControl> listadoTareas = new ArrayList<>();
        System.out.println("Cargando lista de tareas...");
        cargarTareasDefault(listadoTareas);
        // El admin puede agregar asi nuevas tareas
        // agregarTarea(listadoTareas);

        // Muestra lista de tareas
        // verListaTareas(listadoTareas);

        // Le asigna un paciente a un medico -> ADMIN
        System.out.println("Asignando un paciente a un profesional...");
        profesional.agregarPacienteToProfesional(paciente);

        // Crea un Control para paciente por N dias -> PROFESIONAL
        System.out.println("Creando control de tareas para paciente...\n");
        crearControlPaciente(paciente, listadoTareas);

        // Crea una nueva tarea -> ADMIN
        // crearNuevaTarea(listadoTareas);

        System.out.println("Viendo controles asignados a paciente: ");
        paciente.verControles();

        System.out.println("");
        System.out.println("Ver control de hoy: ");
        paciente.verControlHoy();

        // Cargar plan de Tareas -> PACIENTE

        Control controlHoy = paciente.getControlHoy();
        completarTareaPaciente(paciente);

    }

    // Carga una serie de tareas por defecto a la lista de tareas
    public static void cargarTareasDefault(ArrayList<TareaControl> listadoTareas) {
        listadoTareas.add(new TareaControl("Tomar presion"));
        listadoTareas.add(new TareaControl("Tomar temperatura"));
        listadoTareas.add(new TareaControl("Tomar oxigeno en sangre"));
        listadoTareas.add(new TareaControl("Tomar medicacion"));
    }

    // El admin la usa para agregar nuevas tareas a la lista de tareas
    public static void agregarTarea(ArrayList<TareaControl> listadoTareas) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese nueva tarea: ");
        listadoTareas.add(new TareaControl(scan.nextLine()));
    }

    public static void verListaTareas(ArrayList<TareaControl> listadoTareas) {
        System.out.println("\n\tLista de Tareas:");
        for (TareaControl c : listadoTareas)
            System.out.println(c);
    }


    public static TareaControl buscarListaTareas(String nombreTarea, ArrayList<TareaControl> listadoTareas) {
        TareaControl aux = null;
        for (TareaControl c : listadoTareas) {
            if (c.getNombre().equalsIgnoreCase(nombreTarea)) {
                aux = c;
            }
        }
        return aux;
    }

    public static void crearControlPaciente(Paciente paciente, ArrayList<TareaControl> listadoTareas){
        String respuesta = "si";
        Scanner scan = new Scanner(System.in);
        Control controlAux = new Control();
        while (!respuesta.equalsIgnoreCase("0")) {
            verListaTareas(listadoTareas);
            System.out.println("\n\tIngrese nombre de tarea a asignar en paciente:");
            System.out.println("\t-> Para salir ingrese 0");
            respuesta = scan.nextLine();
            if (!respuesta.equalsIgnoreCase("0")){
                TareaControl tareaAux = buscarListaTareas(respuesta, listadoTareas);
                if (tareaAux != null) {
                    controlAux.agregarTarea(tareaAux);
                    System.out.println("\n\tTarea ingresada con exito!");
                } else {
                    System.out.println("\n\tTarea no encontrada o ya enlistada!");
                }
            }
        }

        System.out.println("\nTareas asignadas: ");
        for (TareaControl f: controlAux.tareas){
            System.out.println(f);
        }

        System.out.println("\n\tIngrese la duracion del tratamiento en dias: ");
        int duracion = scan.nextInt();
        // LocalDate fecha = LocalDate.now();

        for (int i = 0; i < duracion; i++){
            Control aux = new Control();
            aux.setFecha(LocalDate.now().plusDays(i));
            aux.setNombreDoctorResponsable("Ramon");
            aux.tareas = controlAux.tareas;
            paciente.agregarListaControl(aux);
        }
        scan.close();
    }

    public static void completarTareaPaciente(Paciente paciente){
        Control aux = paciente.getControlHoy();
        for (TareaControl g: aux.tareas){
            System.out.println("Tarea: " + g.getNombre() + " - Ingrese respuesta: ");
            Scanner teclado = new Scanner(System.in);
            g.setRespuesta("SI - Fix esto");
            System.out.println(g.getRespuesta());
            teclado.close();
        }
    }



















    public static void crearNuevaTarea(ArrayList<TareaControl> listadoTareas) {
        String respuesta = "si";
        while (!respuesta.equalsIgnoreCase("0")) {
            verListaTareas(listadoTareas);
            System.out.println("Ingrese nueva tarea a la lista de tareas:");
            System.out.println("-> Para salir ingrese 0");
            Scanner scan = new Scanner(System.in);
            respuesta = scan.nextLine();
            TareaControl aux = buscarListaTareas(respuesta, listadoTareas);
            if (aux != null) {
                listadoTareas.add(aux);
                System.out.println("\n\tTarea ingresada con exito!");
            } else {
                System.out.println("\n\tTarea no encontrada, o ya enlistada!");
            }
        }
    }








}
