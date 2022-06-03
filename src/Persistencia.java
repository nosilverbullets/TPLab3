import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {
    private static final String path = "C:\\Users\\Shiki\\Desktop\\TPLab3-main\\TPLab3-main";
    public Persistencia() {
    }

    public  void persistirPacientes(ArrayList<Paciente> pacientes) throws IOException {
        File file = new File(path + "\\PACIENTE.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, pacientes);
    }

    public  void persistirProfesional(ArrayList<Profesional> profesional) throws IOException {
        File file = new File(path + "\\PROFESIONAL.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, profesional);
    }

    public  void persistirAdmin(ArrayList<Admin> Admin) throws IOException {
        File file = new File(path + "\\ADMIN.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, Admin);
    }

    public  void persistirTarea(ArrayList<TareaControl> tarea) throws IOException {
        File file = new File(path + "\\TAREA.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, tarea);
    }

    public  void persistirControl(ArrayList<Control> control) throws IOException {
        File file = new File(path + "\\CONTROL.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, control);
    }


    public  ArrayList<Paciente> cargarSistemaPacientes() throws IOException {
        File file = new File(path + "\\PACIENTE.json");
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Paciente> p = mapper.readValue( file, new TypeReference<ArrayList<Paciente>>(){});
        return p;
    }

    public  ArrayList<Profesional> cargarSistemaProfesional() throws IOException {
        File file = new File("PROFESIONAL.json");
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Profesional> p = mapper.readValue( file, new TypeReference<ArrayList<Profesional>>(){});
        return p;
    }

    public  ArrayList<Admin> cargarSistemaAdmin() throws IOException {
        File file = new File("ADMIN.json");
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Admin> p = mapper.readValue( file, new TypeReference<ArrayList<Admin>>(){});
        return p;
    }

    public  ArrayList<TareaControl> cargarSistemaTareaControl() throws IOException {
        File file = new File("TAREA.json");
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<TareaControl> p = mapper.readValue( file, new TypeReference<ArrayList<TareaControl>>(){});
        return p;
    }

    public  ArrayList<Control> cargarSistemaControl() throws IOException {
        File file = new File("CONTROL.json");
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Control> p = mapper.readValue( file, new TypeReference<ArrayList<TareaControl>>(){});
        return p;
    }



}
