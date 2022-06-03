import java.util.Objects;

public final class Login{
    private String mail;
    private UsuarioTipo tipoUsuario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Login)) return false;
        Login login = (Login) o;
        return Objects.equals(mail, login.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }

    public Login(String mail, UsuarioTipo tipoUsuario) {
        this.mail = mail;
        this.tipoUsuario = tipoUsuario;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public UsuarioTipo getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(UsuarioTipo tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
