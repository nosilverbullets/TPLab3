import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Usuario> listadoUsuarios = new ArrayList<>();

        Admin admin = new Admin(UsuarioTipo.admin, "administrador@clinica-colon.com", "123456", "33898687", "Colon 4190", "Mar del Plata", "223456789");




        /* TODO Borrador -> Asignar un Control a cada dia del Tratamiento
        *
        * for (int i = 0; i < diasTratamiento; i++){
        *   planillaControl planilla = new planillaControl(puntos a controlar);
        *   fecha: localDate.plus(i); -> Una por cada dia del tratamiento;
        *   planilla control.add -> a lista de dias de control
        * }
        *
        * Vista paciente:
        * if (lista.isEmpty){
        *   sout"Error al cargar el control"
        * } else {
        *   for (Control x: listaControl){
        *       if (listaControl.fecha.equals(localdate.now)){
        *           sout(x)
        *       }
        *   }
        * }
        * */

        System.out.println("Hello world!");
    }














}