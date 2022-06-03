import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;




public class Sistema {
    static protected LocalDate FECHAHOY = LocalDate.now();
    protected ArrayList<Paciente> pacientes;
    protected ArrayList<Admin> usuarioAdmin;
    protected ArrayList<Profesional> profesionales;
    protected ArrayList<Control> controlesPreEstablecidos;
    protected ArrayList<TareaControl> tareasPreEstablecidas;
    protected ArrayList<Login> listaLOGIN;
    Persistencia persistirSistema = new Persistencia();


public void arrancarSistema() throws IOException {
    this.pacientes = persistirSistema.cargarSistemaPacientes();
    this.usuarioAdmin = persistirSistema.cargarSistemaAdmin();
    this.profesionales = persistirSistema.cargarSistemaProfesional();
    this.controlesPreEstablecidos = persistirSistema.cargarSistemaControl();
    this.tareasPreEstablecidas = persistirSistema.cargarSistemaTareaControl();

    for (Paciente x:pacientes) {
        Login log = new Login(x.getEmail(),x.getTipoUsuario());
        listaLOGIN.add(log);
    }
    for (Admin x:usuarioAdmin) {
        Login log = new Login(x.getEmail(),x.getTipoUsuario());
        listaLOGIN.add(log);
    }
    for (Profesional x:profesionales) {
        Login log = new Login(x.getEmail(),x.getTipoUsuario());
        listaLOGIN.add(log);
    }

}

}
