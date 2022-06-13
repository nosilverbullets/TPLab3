import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //TODO Json Localdate [Solucionado]
        //TODO [Solucionado] Static no lo toma gson -> ID AUTO ++
        //TODO Lista: Tarea, Control, Enfermedad, Especialidad: [Solucionado]
        //TODO Lista: Usuarios [Solucionado] Se genera una lista por tipo, se persiste y luego se unifica
        //TODO Evaluar funcionalidades
        //TODO Cambiar mails por defecto
        //TODO Evaluar implementacion gson en clases con https://www.jsonlint.com/


        Sistema clinica = new Sistema();
        //clinica.generarDatosDefault(); // Carga valores por defecto

        //clinica.separarUsuarios(); // Divide la lista de usuarios para serializar por separado

        //clinica.actualizarAdmin();
        //clinica.actualizarPaciente();
        //clinica.actualizarProfesional();



        //clinica.actualizarUsuarios(); -> NO USAR
        //clinica.actualizarControl();
        //clinica.actualizarTarea();
        //clinica.actualizarEspecialidad();
        //clinica.actualizarEnfermedad();

        //clinica.cargarUsuarios(); -> NO USAR
        clinica.cargarControl();
        clinica.cargarTarea();
        clinica.cargarEspecialidad();
        clinica.cargarEnfermedad();

        clinica.cargarAdmin();
        clinica.cargarPaciente();
        clinica.cargarProfesional();

        clinica.unificarUsuarios();

        login(clinica);
    }

    // -----------------------------------------------------------------------------------------

    public static void login(Sistema clinica) {
        Usuario user;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("\n\t>> Sistema de gestion <<");
            System.out.println("\nadmin -> 123456");
            System.out.println("\nprofesional -> 123456");
            System.out.println("\npaciente -> 123456");
            System.out.println("\nIngrese email: ");
            String email = scan.nextLine();
            System.out.println("Ingrese clave");
            String clave = scan.nextLine();

            user = clinica.login(email, clave);

            if (user != null) {
                menu(user, clinica);
            } else {
                System.out.println("Correo o clave incorrectos...");
                pausa();
            }
        } while (user == null);
    } // Lee datos de inicio, compara en la lista de usuarios y accede al menu si son validos

    public static boolean estaVacio(String nombre) {
        return nombre.isEmpty() && nombre.isBlank();
    } // Verifica si un string esta vacio

    public static void pausa() { // Nos obliga a presionar Enter para continuar
        System.out.println("\n\tPresione ENTER para continuar...");
        try {
            int valor = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // Presiona Enter para continuar

    public static void menu(Usuario user, Sistema clinica) {
        switch (user.getTipoUsuario()) {
            case admin -> menuAdmin(clinica, user);
            case paciente -> menuPaciente(clinica, (Paciente) user);
            case profesional -> menuProfesional(clinica, user);
        }
    } // Muestra el menu correspondiente para cada tipo de usuario

    public static void menuAdmin(Sistema clinica, Usuario admin) {
        int opcion = 0;
        Scanner scan = new Scanner(System.in);
        do {
            boolean continua;
            do {
                try {
                    continua = false;
                    System.out.println("\n\tBienvendo " + admin.getNombre());
                    System.out.println("\nPanel de administracion");
                    System.out.println("1 - Menu tareas de control");
                    System.out.println("2 - Menu enfermedades");
                    System.out.println("3 - Menu especialidades");
                    System.out.println("4 - Menu profesionales");
                    System.out.println("5 - Menu pacientes");
                    System.out.println("0 - Para salir");
                    opcion = scan.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar obligatoriamente una opcion");
                    scan.next();
                    continua = true;
                }
            } while (continua);
            switch (opcion) {
                case 1 -> {
                    menuAdminTareas(clinica, admin);
                    pausa();
                }
                case 2 -> {
                    menuAdminEnfermedades(clinica, admin);
                    pausa();
                }
                case 3 -> {
                    menuAdminEspecialidades(clinica, admin);
                    pausa();
                }
                case 4 -> {
                    menuAdminProfesional(clinica, admin);
                    pausa();
                }
                case 5 -> {
                    menuAdminPaciente(clinica, admin);
                    pausa();
                }
                default -> {
                    System.out.println("Opcion invalida!");
                    pausa();
                }
                case 0 -> {
                }
            }
        } while (opcion != 0);
        login(clinica); // Vuelve al menu de validacion de usuario
    } // Menu vista administrador

    public static void menuAdminTareas(Sistema clinica, Usuario admin) {
        int opcion = 0;
        Scanner scan = new Scanner(System.in);
        do {
            boolean continua;
            do {
                try {
                    continua = false;
                    System.out.println("\nPanel de tareas de control");
                    System.out.println("1 - Ver tareas de control");
                    System.out.println("2 - Agregar tarea de control");
                    System.out.println("3 - Eliminar tarea de control");
                    System.out.println("0 - Para volver al menu anterior");
                    opcion = scan.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar obligatoriamente una opcion");
                    scan.next();
                    continua = true;
                }
            } while (continua);
            switch (opcion) {
                case 1 -> {
                    clinica.verTareasControl();
                    pausa();
                }
                case 2 -> {
                    System.out.println("Ingrese nombre de la nueva tarea: ");
                    scan.nextLine(); // Limpia
                    String tarea = scan.nextLine();
                    if (!estaVacio(tarea) && clinica.agregarTarea(tarea)) {
                        System.out.println("Tarea agregada: " + tarea);
                        clinica.actualizarTarea(); // TODO Testing
                    } else {
                        System.out.println("Tarea duplicada o error al cargar");
                    }
                    pausa();
                }
                case 3 -> {
                    System.out.println("\nListado de tareas:");
                    clinica.verTareasControl();
                    int id = 0;
                    do {
                        try {
                            continua = false;
                            System.out.println("\nIngrese ID a borrar:");
                            id = scan.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Debe ingresar obligatoriamente una opcion");
                            scan.next();
                            continua = true;
                        }
                    } while (continua);
                    if (clinica.borrarTareaID(id)) {
                        System.out.println("Elemento borrado con exito");
                        clinica.actualizarTarea(); // TODO Testing
                    } else {
                        System.out.println("ID incorrecto o no se pudo borrar el elemento");
                    }
                    pausa();
                }
                default -> {
                    System.out.println("Opcion invalida!");
                    pausa();
                }
                case 0 -> {
                }
            }
        } while (opcion != 0);
        menuAdmin(clinica, admin); // Vuelve al menu anterior
    } // Menu admin -> tareas

    public static void menuAdminEnfermedades(Sistema clinica, Usuario admin) {
        int opcion = 0;
        Scanner scan = new Scanner(System.in);
        do {
            boolean continua;
            do {
                try {
                    continua = false;
                    System.out.println("\nPanel de enfermedades");
                    System.out.println("1 - Ver lista de enfermedades");
                    System.out.println("2 - Agregar enfermedad");
                    System.out.println("3 - Eliminar enfermedad");
                    System.out.println("0 - Para volver al menu anterior");
                    opcion = scan.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar obligatoriamente una opcion");
                    scan.next();
                    continua = true;
                }
            } while (continua);
            switch (opcion) {
                case 1 -> {
                    clinica.verEnfermedades();
                    pausa();
                }
                case 2 -> {
                    System.out.println("Ingrese nombre de la enfermedad a agregar: ");
                    scan.nextLine(); // Limpia
                    String enfermedad = scan.nextLine();
                    if (!estaVacio(enfermedad) && clinica.agregarEnfermedad(enfermedad)) {
                        System.out.println("Enfermedad agregada: " + enfermedad);
                    } else {
                        System.out.println("Enfermedad duplicada o error al cargar");
                    }
                    pausa();
                }
                case 3 -> {
                    System.out.println("\nListado de enfermedades");
                    clinica.verEnfermedades();
                    int id = 0;
                    do {
                        try {
                            continua = false;
                            System.out.println("\nIngrese ID a borrar:");
                            id = scan.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Debe ingresar obligatoriamente una opcion");
                            scan.next();
                            continua = true;
                        }
                    } while (continua);
                    if (clinica.borrarEnfermedadID(id)) {
                        System.out.println("Elemento borrado con exito");
                    } else {
                        System.out.println("ID incorrecto o no se pudo borrar el elemento");
                    }
                    pausa();
                }
                default -> {
                    System.out.println("Opcion invalida!");
                    pausa();
                }
                case 0 -> {
                }
            }
        } while (opcion != 0);
        menuAdmin(clinica, admin); // Vuelve al menu anterior
    } // Menu admin -> enfermedades

    public static void menuAdminEspecialidades(Sistema clinica, Usuario admin) {
        int opcion = 0;
        Scanner scan = new Scanner(System.in);
        do {
            boolean continua;
            do {
                try {
                    continua = false;
                    System.out.println("\nPanel de especialidades");
                    System.out.println("1 - Ver lista de especialidades");
                    System.out.println("2 - Agregar especialidad");
                    System.out.println("3 - Eliminar especialidad");
                    System.out.println("0 - Para volver al menu anterior");
                    opcion = scan.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar obligatoriamente una opcion");
                    scan.next();
                    continua = true;
                }
            } while (continua);
            switch (opcion) {
                case 1 -> {
                    clinica.verEspecialidades();
                    pausa();
                }
                case 2 -> {
                    System.out.println("Ingrese nombre de la especialidad a agregar: ");
                    scan.nextLine(); // Limpia
                    String especialidad = scan.nextLine();
                    if (!estaVacio(especialidad) && clinica.agregarEspecialidad(especialidad)) {
                        System.out.println("Especialidad agregada: " + especialidad);
                    } else {
                        System.out.println("Especialidad duplicada o error al cargar");
                    }
                    pausa();
                }
                case 3 -> {
                    System.out.println("\nListado de especialidades");
                    clinica.verEspecialidades();
                    int id = 0;
                    do {
                        try {
                            continua = false;
                            System.out.println("\nIngrese ID a borrar:");
                            id = scan.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Debe ingresar obligatoriamente una opcion");
                            scan.next();
                            continua = true;
                        }
                    } while (continua);
                    if (clinica.borrarEspecialidadID(id)) {
                        System.out.println("Elemento borrado con exito");
                    } else {
                        System.out.println("ID incorrecto o no se pudo borrar el elemento");
                    }
                    pausa();
                }
                default -> {
                    System.out.println("Opcion invalida!");
                    pausa();
                }
                case 0 -> {
                }
            }
        } while (opcion != 0);
        menuAdmin(clinica, admin); // Vuelve al menu anterior
    } // Menu admin -> especialidades

    public static void menuAdminProfesional(Sistema clinica, Usuario admin) {
        int opcion = 0;
        Scanner scan = new Scanner(System.in);
        do {
            boolean continua;
            do {
                try {
                    continua = false;
                    System.out.println("\nPanel de profesionales");
                    System.out.println("1 - Ver lista de profesionales activos");
                    System.out.println("2 - Agregar profesional");
                    System.out.println("3 - Asignar paciente a profesional");
                    System.out.println("4 - Activar / desactivar profesional");
                    System.out.println("0 - Para volver al menu anterior");
                    opcion = scan.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar obligatoriamente una opcion");
                    scan.next();
                    continua = true;
                }
            } while (continua);
            switch (opcion) {
                case 1 -> {
                    System.out.println("\nLista de profesionales activos");
                    clinica.verProfesionalesActivos();
                    pausa();
                }
                case 2 -> {
                    System.out.println("\nIngrese nombre del profesional: ");
                    scan.nextLine();
                    String nombre = scan.nextLine();
                    if (!estaVacio(nombre)) {
                        System.out.println("\nIngrese correo:");
                        String email = scan.nextLine();
                        if (!estaVacio(email) && !clinica.buscarMail(email)) {
                            System.out.println("\nIngrese clave:");
                            String clave = scan.nextLine();
                            if (!estaVacio(clave)) {
                                System.out.println("\nIngrese DNI:");
                                String dni = scan.nextLine();
                                if (!estaVacio(dni) && !clinica.buscarDNI(dni)) {
                                    System.out.println("\nLista de especialidades:");
                                    clinica.verEspecialidades();
                                    int idEspecialidad = 0;
                                    do {
                                        try {
                                            continua = false;
                                            System.out.println("\nIngrese ID especialidad:");
                                            idEspecialidad = scan.nextInt();
                                        } catch (InputMismatchException ex) {
                                            System.out.println("Debe ingresar obligatoriamente una opcion");
                                            scan.next();
                                            continua = true;
                                        }
                                    } while (continua);
                                    if (idEspecialidad < clinica.contarEspecialidad()){
                                        Profesional aux = new Profesional(nombre, email, clave, dni, idEspecialidad);
                                        if (clinica.agregarProfesional(aux)) {
                                            System.out.println("\nProfesional agregado con exito");
                                        } else {
                                            System.out.println("\nError al cargar el profesional");
                                        }
                                    }else{
                                        System.out.println("\nEspecialidad invalida!");
                                    }
                                } else {
                                    System.out.println("\nEl DNI ingresado no es valido, o ya fue ingresado!");
                                }
                            }
                        } else {
                            System.out.println("El correo ya se encuentra registrado!");
                        }
                    }
                    pausa();
                }
                case 3 -> {
                    System.out.println("\nLista de pacientes activos");
                    clinica.verPacientesActivos();
                    int idPaciente3 = 0;
                    do {
                        try {
                            continua = false;
                            System.out.println("\nIngrese ID paciente");
                            idPaciente3 = scan.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Debe ingresar obligatoriamente una opcion");
                            scan.next();
                            continua = true;
                        }
                    } while (continua);
                    Paciente auxPaciente = clinica.buscarPacienteID(idPaciente3);
                    if (auxPaciente != null) {
                        System.out.println("\nListado de profesionales en esa especialidad: ");
                        clinica.verProfesionalesEspecialidad(auxPaciente.getEspecialidad());
                        int idProfesional2 = 0;
                        do {
                            try {
                                continua = false;
                                System.out.println("\nIngrese ID de profesional a asignar:");
                                idProfesional2 = scan.nextInt();
                            } catch (InputMismatchException ex) {
                                System.out.println("Debe ingresar obligatoriamente una opcion");
                                scan.next();
                                continua = true;
                            }
                        } while (continua);
                        if (clinica.agregarPacienteProfesional(auxPaciente, idProfesional2)) {
                            System.out.println("Paciente asignado correctamente");
                        } else {
                            System.out.println("Error al asignar el paciente");
                        }
                    } else {
                        System.out.println("Paciente no encontrado o incorrecto");
                    }
                    pausa();
                }
                case 4 -> {
                    System.out.println("\nListado de profesionales activos e inactivos");
                    clinica.verProfesionales();
                    int id = 0;
                    do {
                        try {
                            continua = false;
                            System.out.println("\nIngrese ID a cambiar estado:");
                            id = scan.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Debe ingresar obligatoriamente una opcion");
                            scan.next();
                            continua = true;
                        }
                    } while (continua);
                    if (clinica.borrarProfesionalID(id)) {
                        System.out.println("Estado cambiado con exito");
                    } else {
                        System.out.println("ID incorrecto o no se pudo borrar el elemento");
                    }
                    pausa();
                }
                default -> {
                    System.out.println("Opcion invalida!");
                    pausa();
                }
                case 0 -> {
                }
            }
        } while (opcion != 0);
        menuAdmin(clinica, admin); // Vuelve al menu anterior
    } // Menu admin -> profesionales

    public static void menuAdminPaciente(Sistema clinica, Usuario admin) {
        int opcion = 0;
        Scanner scan = new Scanner(System.in);
        do {
            boolean continua;
            do {
                try {
                    continua = false;
                    System.out.println("\nPanel de pacientes");
                    System.out.println("1 - Ver lista de pacientes activos");
                    System.out.println("2 - Asignar paciente a profesional");
                    System.out.println("3 - Agregar paciente y asignar a un profesional");
                    System.out.println("4 - Activar / desactivar paciente");
                    System.out.println("0 - Para volver al menu anterior");
                    opcion = scan.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar obligatoriamente una opcion");
                    scan.next();
                    continua = true;
                }
            } while (continua);
            switch (opcion) {
                case 1 -> {
                    System.out.println("\nLista de pacientes activos");
                    clinica.verPacientesActivos();
                    pausa();
                }
                case 2 -> {
                    System.out.println("\nLista de pacientes activos");
                    clinica.verPacientesActivos();
                    int idPaciente3 = 0;
                    do {
                        try {
                            continua = false;
                            System.out.println("\nIngrese ID paciente");
                            idPaciente3 = scan.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Debe ingresar obligatoriamente una opcion");
                            scan.next();
                            continua = true;
                        }
                    } while (continua);
                    Paciente auxPaciente = clinica.buscarPacienteID(idPaciente3);
                    if (auxPaciente != null) {
                        System.out.println("\nListado de profesionales en esa especialidad");
                        clinica.verProfesionalesEspecialidad(auxPaciente.getEspecialidad());
                        int idProfesional2 = 0;
                        do {
                            try {
                                continua = false;
                                System.out.println("\nIngrese ID de profesional a asignar:");
                                idProfesional2 = scan.nextInt();
                            } catch (InputMismatchException ex) {
                                System.out.println("Debe ingresar obligatoriamente una opcion");
                                scan.next();
                                continua = true;
                            }
                        } while (continua);
                        if (clinica.agregarPacienteProfesional(auxPaciente, idProfesional2)) {
                            System.out.println("Paciente asignado correctamente");
                        } else {
                            System.out.println("Error al asignar el paciente");
                        }
                    } else {
                        System.out.println("Paciente no encontrado o incorrecto");
                    }
                    pausa();
                }
                case 3 -> {
                    System.out.println("Ingrese nombre del paciente: ");
                    scan.nextLine();
                    String nombre = scan.nextLine();
                    if (!estaVacio(nombre)) {
                        System.out.println("Ingrese correo:");
                        String email = scan.nextLine();
                        if (!estaVacio(email) && !clinica.buscarMail(email)) {
                            System.out.println("Ingrese clave:");
                            String clave = scan.nextLine();
                            if (!estaVacio(clave)) {
                                System.out.println("Ingrese DNI:");
                                String dni = scan.nextLine();
                                if (!estaVacio(dni) && !clinica.buscarDNI(dni)) {
                                    System.out.println("\nLista de especialidades:");
                                    clinica.verEspecialidades();
                                    int idEspecialidad = 0;
                                    do {
                                        try {
                                            continua = false;
                                            System.out.println("Ingrese ID especialidad:");
                                            idEspecialidad = scan.nextInt();
                                        } catch (InputMismatchException ex) {
                                            System.out.println("Debe ingresar obligatoriamente una opcion");
                                            scan.next();
                                            continua = true;
                                        }
                                    } while (continua);
                                    if (clinica.buscarEspecialidad(idEspecialidad)){
                                        Paciente aux = new Paciente(nombre, email, clave, dni, idEspecialidad);
                                        if (clinica.agregarPaciente(aux)) {
                                            System.out.println("\nPaciente agregado con exito");
                                            System.out.println("\nListado de profesionales en esa especialidad");
                                            clinica.verProfesionalesEspecialidad(idEspecialidad);
                                            int idProfesional = 0;
                                            do {
                                                try {
                                                    continua = false;
                                                    System.out.println("\nIngrese ID de profesional a asignar:");
                                                    idProfesional = scan.nextInt();
                                                } catch (InputMismatchException ex) {
                                                    System.out.println("Debe ingresar obligatoriamente una opcion");
                                                    scan.next();
                                                    continua = true;
                                                }
                                            } while (continua);
                                            if (clinica.agregarPacienteProfesional(aux, idProfesional)) {
                                                System.out.println("Paciente asignado correctamente");
                                            } else {
                                                System.out.println("Error al asignar el paciente");
                                            }
                                        } else {
                                            System.out.println("Error al cargar el paciente");
                                        }
                                    }
                                } else {
                                    System.out.println("\nEl DNI ingresado no es valido o ya se encuentra registrado!");
                                }
                            }
                        }
                    }
                    pausa();
                }
                case 4 -> {
                    System.out.println("\nListado de pacientes activos e inactivos");
                    clinica.verPacientes();
                    int id = 0;
                    do {
                        try {
                            continua = false;
                            System.out.println("\nIngrese ID a cambiar estado:");
                            id = scan.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Debe ingresar obligatoriamente una opcion");
                            scan.next();
                            continua = true;
                        }
                    } while (continua);
                    if (clinica.borrarPacienteID(id)) {
                        System.out.println("Estado cambiado con exito");
                    } else {
                        System.out.println("ID incorrecto o no se pudo borrar el elemento");
                    }
                    pausa();
                }
                default -> {
                    System.out.println("Opcion invalida!");
                    pausa();
                }
                case 0 -> {
                }
            }
        } while (opcion != 0);
        menuAdmin(clinica, admin); // Vuelve al menu anterior
    } // Menu admin -> pacientes
    // --------------------------------------------------------------------------------------


    public static void menuProfesional(Sistema clinica, Usuario profesional) { // -> Menu profesinal
        int opcion = 0;
        Scanner scan = new Scanner(System.in);
        do {
            boolean continua;
            do {
                System.out.println("\n\tBienvendo " + profesional.getNombre());
                System.out.println("\nPanel de administracion");
                notificacionPaciente(clinica, (Profesional) profesional); // <- Notificacion paciente nuevo
                System.out.println("\n************************************************");
                if (clinica.profesionalNotificacion(profesional)) {
                    System.out.println("\nDispone de pacientes que no completaron su tratamiento ayer");
                } else {
                    System.out.println("\nNo dispone de tratamientos incompletos de ayer");
                }
                try {
                    continua = false;
                    System.out.println("\n************************************************");
                    System.out.println("\n1 - Ver pacientes nuevos");
                    System.out.println("2 - Ver pacientes en tratamiento");
                    System.out.println("3 - Ver listado de controles predeterminados");
                    System.out.println("4 - Asignar control a paciente");
                    System.out.println("5 - Dar de alta paciente");
                    System.out.println("6 - Ver pacientes que ayer no cumplieron con el tratamiento");
                    System.out.println("0 - Para volver al menu anterior");
                    opcion = scan.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar obligatoriamente una opcion");
                    scan.next();
                    continua = true;
                }
            } while (continua);
            switch (opcion) {
                case 1 -> {
                    if (clinica.contadorPacientesNuevos((Profesional) profesional) > 0) {
                        System.out.println("\nListado de pacientes sin tratamiento: \n");
                        clinica.verListadoPacientesProfNuevos((Profesional) profesional);
                    } else {
                        System.out.println("No dispone de pacientes nuevos");
                    }
                    pausa();
                }
                case 2 -> {
                    if (clinica.contadorPacientesTratamiento((Profesional) profesional) > 0) {
                        System.out.println("\nListado de pacientes sin tratamiento: \n");
                        clinica.verListadoPacientesProfNuevos((Profesional) profesional);
                    } else {
                        System.out.println("No dispone de pacientes nuevos");
                    }
                    pausa();
                }
                case 3 -> {
                    clinica.verListadoControles();
                    pausa();
                }
                case 4 -> menuAsignar(clinica, profesional);
                case 5 -> {
                    System.out.println("\nListado de pacientes en tratamiento:\n");
                    clinica.verListadoPacientesProfTratados((Profesional) profesional);
                    int idPaciente = 0;
                    do {
                        try {
                            continua = false;
                            System.out.println("\nIngrese ID paciente: ");
                            idPaciente = scan.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Debe ingresar obligatoriamente una opcion");
                            scan.next();
                            continua = true;
                        }
                    } while (continua);
                    Paciente auxPaciente = clinica.buscarPacienteID(idPaciente);
                    System.out.println("\nLista de tratamientos aplicados vigentes");
                    auxPaciente.verOrdenesVigentes();
                    int idOrden = 0;
                    do {
                        try {
                            continua = false;
                            System.out.println("\nIngrese id de tratamiento a dar de alta");
                            idOrden = scan.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Debe ingresar obligatoriamente una opcion");
                            scan.next();
                            continua = true;
                        }
                    } while (continua);
                    auxPaciente.altaPaciente(((Profesional) profesional).getID(), idOrden);
                    pausa();

                }
                case 6 -> {
                    if (clinica.profesionalNotificacion(profesional)){
                        clinica.profesionalNotifTareasIncompletas(profesional);
                    }else{
                        System.out.println("\nNo se detectaron incumplimientos");
                    }

                }
            }
        }while(opcion !=0);
        login(clinica); // Vuelve al menu de validacion de usuario
    } // Menu profesional

    public static void menuAsignar(Sistema clinica, Usuario profesional){
        Scanner scan = new Scanner(System.in);
        boolean continua;
        if (clinica.contadorPacientesNuevos((Profesional) profesional) < 1){
            System.out.println("No dispone de pacientes sin tratar");
        }else{
            int duracion = 0;
            int idControl = 0;
            int respuesta = 0;
            int idPaciente = 0;
            System.out.println("\nListado de pacientes sin tratamiento: \n");
            clinica.verListadoPacientesProfNuevos((Profesional) profesional);
            do {
                try {
                    continua = false;
                    System.out.println("\nIngrese ID paciente a tratar: ");
                    idPaciente = scan.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar obligatoriamente una opcion");
                    scan.next();
                    continua = true;
                }
            } while (continua);
            do {
                try {
                    continua = false;
                    System.out.println("\nDesea agregar un control prestablecido? Ingrese: ");
                    System.out.println("[1] Control prestablecido [2] Crear control personalizado [0] Cancelar");
                    respuesta = scan.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar obligatoriamente una opcion");
                    scan.next();
                    continua = true;
                }
            } while (continua);
            switch (respuesta) {
                case 1 -> {
                    System.out.println("\n>> Listado de controles:");
                    clinica.verListadoControles();
                    do {
                        try {
                            continua = false;
                            System.out.println("\nIngrese ID de control a aplicar: ");
                            idControl = scan.nextInt();
                            System.out.println("Ingrese dias de duracion del tratamiento: ");
                            duracion = scan.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Debe ingresar obligatoriamente una opcion");
                            scan.next();
                            continua = true;
                        }
                    } while (continua);
                    // Ciclo agrega control a paciente con fecha
                    clinica.cargarControlPacientes(profesional, idPaciente, idControl, duracion);
                    pausa();
                }
                case 2 -> {
                    ArrayList<Integer> tareas = new ArrayList<>();
                    System.out.println("Listado de enfermedades:");
                    clinica.verEnfermedades();
                    int idEnfermedad = 0;
                    do {
                        try {
                            continua = false;
                            System.out.println("Ingrese ID enfermedad a asignar:");
                            idEnfermedad = scan.nextInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Debe ingresar obligatoriamente una opcion");
                            scan.next();
                            continua = true;
                        }
                    } while (continua);
                    int respuestaDos = 0;
                    if (!clinica.buscarEnfermedad(idEnfermedad)){
                        System.out.println("\nEnfermedad no encontrada!");
                    }else{
                        do {
                            System.out.println("\nListado de tareas disponibles");
                            clinica.verTareasControl();
                            do {
                                try {
                                    continua = false;
                                    System.out.println("\nIngrese ID tarea: ");
                                    int idTarea = scan.nextInt();
                                    boolean existeTarea = false;
                                    for (Integer c: tareas){
                                        if (c.equals(idTarea)){
                                            existeTarea = true;
                                        }
                                    }
                                    if (!existeTarea && clinica.buscarTarea(idTarea)){
                                        tareas.add(idTarea);
                                    }else{
                                        System.out.println("\nTarea repetida");
                                    }
                                    System.out.println("Desea seguir agregando?");
                                    System.out.println("[0] No [1] Si");
                                    respuestaDos = scan.nextInt();
                                } catch (InputMismatchException ex) {
                                    System.out.println("Debe ingresar obligatoriamente una opcion");
                                    scan.next();
                                    continua = true;
                                }
                            } while (continua);
                        } while (respuestaDos != 0);
                        int duracionDos = 0;
                        do {
                            try {
                                continua = false;
                                System.out.println("Ingrese dias de duracion del tratamiento: ");
                                duracionDos = scan.nextInt();
                            } catch (InputMismatchException ex) {
                                System.out.println("Debe ingresar obligatoriamente una opcion");
                                scan.next();
                                continua = true;
                            }
                        } while (continua);
                        clinica.cargarControlPacienteCustom(profesional, idPaciente, duracionDos, tareas, idEnfermedad);
                        System.out.println("\nTratamiento agregado con exito!");
                    }
                    pausa();
                }
            }
        }
    } // Menu profesional -> avoid nested switch

    public static void notificacionPaciente(Sistema clinica, Profesional profesional) {
        if (clinica.contadorPacientesNuevos(profesional) == 0) {
            System.out.println(">> " + profesional.getNombre() + ", no tiene pacientes nuevos, o sin atender.");
        } else if (clinica.contadorPacientesNuevos(profesional) == 1) {
            System.out.println(">> " + profesional.getNombre() + ", usted tiene un paciente nuevo, o sin atender");
        } else if (clinica.contadorPacientesNuevos(profesional) > 1) {
            System.out.println(">> " + profesional.getNombre() + ", usted tiene: " + clinica.contadorPacientesNuevos(profesional) + " pacientes nuevos, o sin atender");
        }
    } // Menu profesional -> Notificacion nuevo paciente
    // --------------------------------------------------------------------------------------
    public static void menuPaciente(Sistema clinica, Paciente paciente) { // -> Menu profesinal
        int opcion = 0;
        Scanner scan = new Scanner(System.in);
        do {
            boolean continua;
            do {
                System.out.println("\n************************************************");
                System.out.println("\n\tBienvendo " + paciente.getNombre());
                System.out.println("\nPanel de administracion");
                if (paciente.notificacion()) {
                    System.out.println("> Usted dispone de tareas para cargar hoy");
                } else {
                    System.out.println("> Usted no dispone de tareas a realizar hoy");
                }
                try {
                    continua = false;
                    System.out.println("\n************************************************");
                    System.out.println("\n1 - Ver control de hoy");
                    System.out.println("2 - Ver listado de controles asignados");
                    System.out.println("3 - Completar tarea de hoy");
                    System.out.println("0 - Para volver al menu anterior");
                    opcion = scan.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Debe ingresar obligatoriamente una opcion");
                    scan.next();
                    continua = true;
                }
            } while (continua);
            switch (opcion) {
                case 1 -> {
                    if (paciente.notificacion()) {
                        paciente.verOrdenHoy();
                    } else {
                        System.out.println("\n> No hay tratamientos asignados pata hoy");
                    }
                    pausa();
                }
                case 2 -> {
                    if (paciente.notificacion()) {
                        paciente.verOrdenes();
                    } else {
                        System.out.println("\n> No hay tratamientos asignados pata hoy");
                    }
                    pausa();
                }
                case 3 -> {
                    if (paciente.notificacion()) {
                        paciente.completarTareaHoy();
                    } else {
                        System.out.println("\n> No hay tratamientos asignados pata hoy");
                    }
                    pausa();
                }
                default -> pausa();
            }
            // scan.close(); -> se rompe
        } while (opcion != 0);
        login(clinica); // Vuelve al menu de validacion de usuario
    } // Menu admin -> tareas
// -----------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------
}