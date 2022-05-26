public abstract class Usuario {
    protected UsuarioTipo tipoUsuario;
    protected String email;
    protected String contrasena;
    protected String dni;


    public Usuario(UsuarioTipo tipoUsuario, String email, String contrasena, String dni, String direccion, String localidad, String telefono) {
        this.tipoUsuario = tipoUsuario;
        this.email = email;
        this.contrasena = contrasena;
        this.dni = dni;
    }
}
