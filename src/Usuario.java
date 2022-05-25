public abstract class Usuario {
    protected UsuarioTipo tipoUsuario;
    protected String email;
    protected String contrasena;
    protected String dni;
    protected String direccion;
    protected String localidad;
    protected String telefono;

    public Usuario(UsuarioTipo tipoUsuario, String email, String contrasena, String dni, String direccion, String localidad, String telefono) {
        this.tipoUsuario = tipoUsuario;
        this.email = email;
        this.contrasena = contrasena;
        this.dni = dni;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
    }
}
