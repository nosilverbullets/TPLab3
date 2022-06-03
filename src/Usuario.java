public abstract class Usuario {
    protected UsuarioTipo tipoUsuario;
    protected String email;
    protected String contrasena;
    protected String dni;

    public Usuario(UsuarioTipo tipoUsuario, String email, String contrasena, String dni) {
        this.tipoUsuario = tipoUsuario;
        this.email = email;
        this.contrasena = contrasena;
        this.dni = dni;
    }

    public UsuarioTipo getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(UsuarioTipo tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
