import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema {
    ArrayList<Usuario> listadoUsuario;
    ArrayList<TareaControl> listadoTarea;
    ArrayList<Control> listadoControl;
    ArrayList<Enfermedad> listadoEnfermedad;

    ArrayList<Especialidad> listadoEspecialidad;

    public Sistema() {
        this.listadoUsuario = new ArrayList<>();
        this.listadoTarea = new ArrayList<>();
        this.listadoControl = new ArrayList<>();
        this.listadoEnfermedad = new ArrayList<>();
        this.listadoEspecialidad = new ArrayList<>();
    }

    public void generarDatosDefault(){

        // Especialidades
        listadoEspecialidad.add(new Especialidad("Odontologia"));
        listadoEspecialidad.add(new Especialidad("Pediatria"));
        listadoEspecialidad.add(new Especialidad("Neumonologia"));
        listadoEspecialidad.add(new Especialidad("Urologia"));
        listadoEspecialidad.add(new Especialidad("Cardiologia"));

        // Enfermedad
        listadoEnfermedad.add(new Enfermedad("Caries"));
        listadoEnfermedad.add(new Enfermedad("Gastroenteritis"));
        listadoEnfermedad.add(new Enfermedad("Covid"));
        listadoEnfermedad.add(new Enfermedad("Infeccion urinaria"));
        listadoEnfermedad.add(new Enfermedad("Cardiopatia"));

        // Tarea control
        listadoTarea.add(new TareaControl("Enjuague bucal"));
        listadoTarea.add(new TareaControl("Quitar sarro"));

        listadoTarea.add(new TareaControl("Tomar Buscapina"));
        listadoTarea.add(new TareaControl("Tomar te"));

        listadoTarea.add(new TareaControl("Tomar temperatura"));
        listadoTarea.add(new TareaControl("Tomar Ibuprofeno"));

        listadoTarea.add(new TareaControl("Tomar medicamento para la infeccion"));
        listadoTarea.add(new TareaControl("Tomar agua"));

        listadoTarea.add(new TareaControl("Tomar Bayaspirina Prevent"));
        listadoTarea.add(new TareaControl("Medir presion"));

        // Controles preestablecidos
        Control caries = new Control("Caries");
        caries.agregarEnfermedadID(0); caries.agregarTareaID(0); caries.agregarTareaID(1);
        listadoControl.add(caries);

        Control gastroenteritis = new Control("Gastroenteritis");
        gastroenteritis.agregarEnfermedadID(1); gastroenteritis.agregarTareaID(2); gastroenteritis.agregarTareaID(3);
        listadoControl.add(gastroenteritis);

        Control covid = new Control("Covid");
        covid.agregarEnfermedadID(2); covid.agregarTareaID(4); covid.agregarTareaID(5);
        listadoControl.add(covid);

        Control infeccionUrinaria = new Control("Infeccion Urinaria");
        infeccionUrinaria.agregarEnfermedadID(3); infeccionUrinaria.agregarTareaID(6); infeccionUrinaria.agregarTareaID(7);
        listadoControl.add(infeccionUrinaria);

        Control cardiopatia = new Control("Cardiopatia");
        cardiopatia.agregarEnfermedadID(4); cardiopatia.agregarTareaID(8); cardiopatia.agregarTareaID(9);
        listadoControl.add(cardiopatia);

        // Usuarios
        listadoUsuario.add(new Admin("Juan Administrador", "admin", "123456", "38001002"));

        Profesional profesional = new Profesional("Doctor Bianchi", "profesional", "123456", "20123456", 0);
        profesional.agregarPacientesProfesionalID(0);
        listadoUsuario.add(profesional);

        listadoUsuario.add(new Profesional("Doctora Gimenez", "profesional2", "123456", "10123456", 1));
        listadoUsuario.add(new Profesional("Doctora Ullua", "profesional3", "123456", "30123456", 2));
        listadoUsuario.add(new Profesional("Doctor Pettinato", "profesional4", "123456", "25123456", 3));
        listadoUsuario.add(new Profesional("Doctor Gaggini", "profesional5", "123456", "29123456", 4));

        listadoUsuario.add(new Paciente("Paciente Silvia", "paciente", "123456", "26456789", 0));
        listadoUsuario.add(new Paciente("Paciente Carlos", "paciente2", "123456", "26456789", 1));
        listadoUsuario.add(new Paciente("Paciente Romina", "paciente3", "123456", "26456789", 2));
        listadoUsuario.add(new Paciente("Paciente Juan", "paciente4", "123456", "26456789", 3));
        listadoUsuario.add(new Paciente("Paciente Carla", "paciente5", "123456", "26456789", 4));

    }
    // Retorna el usuario si el login es valido
    public Usuario login(String email, String clave){
        for (Usuario c: listadoUsuario){
            if (c.getEmail().equalsIgnoreCase(email) && c.getClave().equalsIgnoreCase(clave)){
                return c;
            }
        }
        return null;
    }
    // -----------------------------------------------------------------------------------------
    public void verTareasControl(){
        for (TareaControl c: listadoTarea){
            System.out.println(c);
        }
    }
    // Si tarea ya existe no se agrega
    public boolean agregarTarea(String tarea){
        for (TareaControl c: listadoTarea){
            if (c.getNombre().equalsIgnoreCase(tarea)){
                return false;
            }
        }
        this.listadoTarea.add(new TareaControl(tarea));
        return true;
    }
    public boolean borrarTareaID(int id){
        boolean aux = false;
        for (TareaControl c: listadoTarea){
            if (c.getId() == id){
                this.listadoTarea.remove(c);
                aux = true;
            }
        }
        return aux;
    }
    public TareaControl buscarTareaID(int idTarea){
        TareaControl aux = null;
        for (TareaControl c: listadoTarea){
            if (c.getId() == idTarea){
                aux = c;
            }
        }
        return aux;
    }
    public boolean buscarTarea(int id){
        for (TareaControl c: listadoTarea){
            if (c.getId() == id){
                return true;
            }
        }
        return false;
    }
    public void verEnfermedades(){
        for (Enfermedad c: listadoEnfermedad){
            System.out.println(c);
        }
    }

    public boolean buscarEnfermedad(int idEnfermedad){
        for (Enfermedad c: listadoEnfermedad){
            if(c.getId() == idEnfermedad){
                return true;
            }
        }
        return false;
    }

    // Si la enfermedad ya se encuentra no se agrega
    public boolean agregarEnfermedad(String enfermedad){
        for (Enfermedad c: listadoEnfermedad){
            if (c.getNombre().equalsIgnoreCase(enfermedad)){
                return false;
            }
        }
        this.listadoEnfermedad.add(new Enfermedad(enfermedad));
        return true;
    }
    public boolean borrarEnfermedadID(int id){
        for (Enfermedad c: listadoEnfermedad){
            if (c.getId() == id){
                this.listadoEnfermedad.remove(c);
                return true;
            }
        }
        return false;
    }
    public void verEspecialidades(){
        for (Especialidad c: listadoEspecialidad){
            System.out.println(c);
        }
    }
    public int contarEspecialidad(){
        int i = 0;
        for (Especialidad c: listadoEspecialidad){
            i++;
        }
        return i;
    }

    public boolean buscarEspecialidad(int idEspecialidad){
        for (Especialidad c: listadoEspecialidad){
            if (c.getId() == idEspecialidad){
                return true;
            }
        }
        return false;
    }

    public boolean agregarEspecialidad(String especialidad){
        for (Especialidad c: listadoEspecialidad){
            if (c.getNombre().equalsIgnoreCase(especialidad)){
                return false;
            }
        }
        this.listadoEspecialidad.add(new Especialidad(especialidad));
        return true;
    }
    public boolean borrarEspecialidadID(int id){
        for (Especialidad c: listadoEspecialidad){
            if (c.getId() == id){
                this.listadoEspecialidad.remove(c);
                return true;
            }
        }
        return false;
    }
    public boolean buscarMail(String email){
        for (Usuario c: listadoUsuario){
            if (c.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }
    public boolean buscarDNI(String dni){
        for (Usuario c: listadoUsuario){
            if (c.getDni().equalsIgnoreCase(dni)) {
                return true;
            }
        }
        return false;
    }
    public void verProfesionales(){
        for (Usuario c: listadoUsuario){
            if (c.tipoUsuario.equals(TipoUsuario.profesional)){
                System.out.println(c);
            }
        }
    }
    public void verProfesionalesActivos(){
        for (Usuario c: listadoUsuario){
            if (c.tipoUsuario.equals(TipoUsuario.profesional)){
                if (((Profesional) c).estaActivo()) {
                    System.out.println(c);
                }
            }
        }
    }
    public void verProfesionalesEspecialidad(int id){
        for (Usuario c: listadoUsuario){
            if (c.tipoUsuario.equals(TipoUsuario.profesional)){
                if (((Profesional) c).estaActivo() && ((Profesional) c).getEspecialidad() == id) {
                    System.out.println(c);
                }
            }
        }
    } // Muestra los profesionales activos segun especialidad
    public boolean agregarProfesional(Profesional profesional){
        for (Usuario c: listadoUsuario){
            if (c.getDni().equalsIgnoreCase(profesional.getDni())){
                return false;
            }
        }
        this.listadoUsuario.add(profesional);
        return true;
    } // Agrega profesional si su DNI no existe en la lista
    public boolean borrarProfesionalID(int id){

        for (Usuario c: listadoUsuario){
            if (c.getTipoUsuario().equals(TipoUsuario.profesional)){
                if (((Profesional) c).getID() == id){
                    System.out.println(c.getNombre());
                    ((Profesional) c).setActivo(!((Profesional) c).estaActivo());
                    return true;
                }
            }
        }
        return false;
    }
    public void verPacientesActivos(){
        for (Usuario c: listadoUsuario){
            if (c.tipoUsuario.equals(TipoUsuario.paciente)){
                if (((Paciente) c).estaActivo()) {
                    System.out.println(c);
                }
            }
        }
    }
    public void verPacientes(){
        for (Usuario c: listadoUsuario){
            if (c.tipoUsuario.equals(TipoUsuario.paciente)){
                System.out.println(c);
            }
        }
    }
    public Paciente buscarPacienteID(int id){
        Paciente aux;
        for (Usuario c: listadoUsuario){
            if (c.getTipoUsuario().equals(TipoUsuario.paciente)){
                aux = (Paciente) c;
                if (aux.getID() == id){
                    return aux;
                }
            }
        }
        return null;
    }
    // Agrega paciente si su DNI no existe en la lista
    public boolean agregarPaciente(Paciente paciente){
        for (Usuario c: listadoUsuario){
            if (c.getDni().equalsIgnoreCase(paciente.getDni())){
                return false;
            }
        }
        this.listadoUsuario.add(paciente);
        return true;
    }
    // Agrega un paciente a un profesional
    public boolean agregarPacienteProfesional(Paciente paciente, int idProfesional){
        boolean estado = false;
        for(Usuario c: listadoUsuario){
            if(c.getTipoUsuario().equals(TipoUsuario.profesional)){
                if (((Profesional)c).getID() == idProfesional){
                    ((Profesional) c).agregarPacientesProfesionalID(paciente.getID());
                    estado = true;
                }
            }
        }
        return estado;
    }
    public boolean borrarPacienteID(int id){
        for (Usuario c: listadoUsuario){
            if (c.getTipoUsuario().equals(TipoUsuario.paciente)){
                if (((Paciente) c).getID() == id){
                    System.out.println(c.getNombre());
                    ((Paciente) c).setActivo(!((Paciente) c).estaActivo());
                    return true;
                }
            }
        }
        return false;
    }
    public void verListadoPacientesProfNuevos(Profesional profesional){
        Paciente aux;
        for (Integer c: profesional.getListaPacientesNuevosID()){
            aux = buscarPacienteID(c);
            System.out.println(aux);
        }
    }
    public void verListadoPacientesProfTratados(Profesional profesional){
        Paciente aux;
        for (Integer c: profesional.getListaPacientesEnTratamiendoID()){
            aux = buscarPacienteID(c);
            System.out.println(aux);
        }
    }
    public int contadorPacientesNuevos(Profesional profesional){
        int i = 0;
        for (Integer c: profesional.getListaPacientesNuevosID()){
            i ++;
        }
        return i;
    }
    public int contadorPacientesTratamiento(Profesional profesional){
        int i = 0;
        for (Integer c: profesional.getListaPacientesEnTratamiendoID()){
            i ++;
        }
        return i;
    }
    public void verListadoControles(){
        for (Control c: listadoControl){
            System.out.println(c);
        }
    }
    public Control buscarControlID(int idControl){
        Control aux = null;
        for (Control c: listadoControl){
            if (c.getId() == idControl){
                aux = c;
            }
        }
        return aux;
    }
    public void cargarControlPacientes(Usuario profesional, int idPaciente, int idControl, int duracion){
        Control aux = buscarControlID(idControl);
        if (aux != null){
            for(Integer x: aux.getListadoTareasID()){
                aux.agregarTarea(buscarTareaID(x));
            }
            for (Usuario c: listadoUsuario){
                if (c.getTipoUsuario().equals(TipoUsuario.paciente)){
                    if (((Paciente)c).getID() == idPaciente) {
                        ((Profesional)profesional).setContadorOrdenesGeneradas();
                        for (int i = 0; i < duracion; i++) {
                            Orden auxOrden = new Orden();
                            auxOrden.setId(((Profesional) profesional).getContadorOrdenesGeneradas());
                            auxOrden.setControl(aux);
                            auxOrden.setFecha(LocalDate.now().plusDays(i));
                            auxOrden.setIdProfesional(((Profesional)profesional).getID());
                            ((Paciente)c).agregarListaOrden(auxOrden);
                        }
                        // Paciente: lista sin atender -> lista en tratamiento
                        ((Profesional)profesional).agregarListaPacientesEnTratamiendoID(idPaciente);
                        ((Profesional) profesional).borrarPacienteNuevoID(idPaciente);
                        System.out.println("\nTratamiento cargado con exito ");
                    }
                }
            }
        }
    }
    // Crea un control por cada dia de duracion del tratamiento elegido
    public void cargarControlPacienteCustom(Usuario profesional, int idPaciente, int duracion, ArrayList<Integer> tareas, int idEnfermedad){
        for (Usuario c: listadoUsuario){
            if (c.getTipoUsuario().equals(TipoUsuario.paciente)){
                if (((Paciente)c).getID() == idPaciente) {
                    ((Profesional)profesional).setContadorOrdenesGeneradas();
                    Control auxControl = new Control("Tratamiento personalizado");
                    auxControl.setListadoTareasID(tareas);
                    for(Integer x: auxControl.getListadoTareasID()){
                        auxControl.agregarTarea(buscarTareaID(x));
                    }
                    auxControl.agregarEnfermedadID(idEnfermedad);
                    for (int i = 0; i < duracion; i++) {
                        Orden auxOrden = new Orden();
                        auxOrden.setId(((Profesional) profesional).getContadorOrdenesGeneradas());
                        auxOrden.setControl(auxControl);
                        auxOrden.setFecha(LocalDate.now().plusDays(i));
                        auxOrden.setIdProfesional(((Profesional)profesional).getID());
                        ((Paciente)c).agregarListaOrden(auxOrden);
                    }
                    // Paciente: lista sin atender -> lista en tratamiento
                    ((Profesional)profesional).agregarListaPacientesEnTratamiendoID(idPaciente);
                    ((Profesional) profesional).borrarPacienteNuevoID(idPaciente);
                    System.out.println("\nTratamiento cargado con exito ");
                }
            }
        }
    }
    public boolean profesionalNotificacion(Usuario profesional){
        boolean tieneRespuestas = false;
        for (Integer c: ((Profesional)profesional).getListaPacientesEnTratamiendoID()){
            Paciente aux = buscarPacienteID(c);
            for(Orden d: aux.listaOrdenes){
                if (d.getFecha().equals(LocalDate.now().plusDays(-1))){
                    for (TareaControl e: d.getControl().getListadoTareas()){
                        if (e.getRespuesta().isBlank() || e.getRespuesta().isEmpty()){
                            tieneRespuestas = true;
                        }
                    }
                }
            }
        }
        return tieneRespuestas;
    }
    public void profesionalNotifTareasIncompletas(Usuario profesional){
        for (Integer c: ((Profesional)profesional).getListaPacientesEnTratamiendoID()){
            Paciente aux = buscarPacienteID(c);
            for(Orden d: aux.listaOrdenes){
                if (d.getFecha().equals(LocalDate.now().plusDays(-1))){
                    for (TareaControl e: d.getControl().getListadoTareas()){
                        if (e.getRespuesta().isBlank() || e.getRespuesta().isEmpty()){
                            System.out.println(aux.getNombre() + " no cumplio con el tratamiento ayer.");
                        }
                    }
                }
            }
        }
    }






}
