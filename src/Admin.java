import java.util.ArrayList;

public class Admin extends Usuario{

    public Admin(UsuarioTipo tipoUsuario, String email, String contrasena, String dni, String direccion, String localidad, String telefono) {
        super(tipoUsuario, email, contrasena, dni, direccion, localidad, telefono);
    }

    // CRUD Usuarios -> Solo en vista administrador
    public void crearUser(){
        // TODO Crea paciente o profesional
    }
    public void buscarUser(){
        // TODO Busca paciente o profesional
    }
    public void modificarUser(){
        // TODO Modifica paciente o profesional
    }
    public void borrarUser(){
        // TODO Borra paciente o profesional
    }

    // CRUD Enfermedades y Tareas control



}
