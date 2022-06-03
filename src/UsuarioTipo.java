public enum UsuarioTipo {

    ADMIN(1), PROFESIONAL(2), PACIENTE(3);

    private int tipoUsuario;

    UsuarioTipo(short tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    UsuarioTipo(int i) {
    }

}
