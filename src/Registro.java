public class Registro {


    private String sintomasCompletados;
    boolean completoRegistro;

    public Registro() {
        this.sintomasCompletados = "VACIO";
        this.completoRegistro = false;
    }

    public Registro(String sintomasCompletados, boolean completoRegistro) {
        this.sintomasCompletados = sintomasCompletados;
        this.completoRegistro = completoRegistro;
    }

    public String getSintomasCompletados() {
        return sintomasCompletados;
    }

    public void setSintomasCompletados(String sintomasCompletados) {
        this.sintomasCompletados = sintomasCompletados;
    }

    public boolean isCompletoRegistro() {
        return completoRegistro;
    }

    public void setCompletoRegistro(boolean completoRegistro) {
        this.completoRegistro = completoRegistro;
    }

}
