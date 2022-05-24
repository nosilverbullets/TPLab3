import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Profesional> listaMedicos = new ArrayList<>();
        ArrayList<Paciente> listaPacientes = new ArrayList<>();
        ArrayList<Enfermedad> listaEnfermedades = new ArrayList<>();

        ArrayList<Sintoma> listaSintomas = new ArrayList<>();
        crearSintomas(listaSintomas);

        mostrarLista(listaSintomas); // Muestra lista generica - Set: toString

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

    public static void crearSintomas(ArrayList listaSintomas){
        listaSintomas.add(new Sintoma("Tos"));
        listaSintomas.add(new Sintoma("Mucosidad"));
        listaSintomas.add(new Sintoma("Estornudo"));
        listaSintomas.add(new Sintoma("Congestion nasal"));
        listaSintomas.add(new Sintoma("Dolor de garganta"));
        listaSintomas.add(new Sintoma("Dolor de oido"));
        listaSintomas.add(new Sintoma("Fiebre"));
        listaSintomas.add(new Sintoma("Dolor corporal"));
        listaSintomas.add(new Sintoma("Dolor de cabeza"));
        listaSintomas.add(new Sintoma("Dolor en rostro"));
        listaSintomas.add(new Sintoma("Enrojecimiento de la piel"));
        listaSintomas.add(new Sintoma("Inflamacion del area afectada"));
        listaSintomas.add(new Sintoma("Ronquera"));
        listaSintomas.add(new Sintoma("Dolor al orinar"));
        listaSintomas.add(new Sintoma("Necesidad de orinar con frecuencia"));
    }

    public static void mostrarLista(ArrayList lista){
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
    }













}