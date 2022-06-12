import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    private static int contadorid = 0;
    private int id;
    private String nombre;
    private ArrayList<Integer> listadoEnfermedadesID; // Para que enfermedades se va a sugerir
    private ArrayList<Integer> listadoTareasID; // Que tareas a realizar incluye
    private ArrayList<TareaControl> listadoTareas; // La copia de las tareas a completar

    public Control(String nombre) {
        this.nombre = nombre;
        this.id = contadorid++;
        this.listadoEnfermedadesID = new ArrayList<>();
        this.listadoTareasID = new ArrayList<>();
        this.listadoTareas = new ArrayList<>();
    }

    public void agregarEnfermedadID(Integer enfermedadID){
        this.listadoEnfermedadesID.add(enfermedadID);
    }

    public void agregarTareaID(Integer tareaID){

        this.listadoTareasID.add(tareaID);
    }

    public void agregarTarea(TareaControl tarea){
        listadoTareas.add(tarea);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Integer> getListadoTareasID() {
        return listadoTareasID;
    }

    public void setListadoTareasID(ArrayList<Integer> listadoTareasID) {
        this.listadoTareasID = listadoTareasID;
    }

    public ArrayList<Integer> getListadoEnfermedadesID() {
        return listadoEnfermedadesID;
    }

    public void setListadoEnfermedadesID(ArrayList<Integer> listadoEnfermedadesID) {
        this.listadoEnfermedadesID = listadoEnfermedadesID;
    }

    public ArrayList<TareaControl> getListadoTareas() {
        return listadoTareas;
    }

    public void completarTareaControl(){
        for (TareaControl c: listadoTareas){
            System.out.println("\n");
            System.out.println(c.getNombre());
            System.out.println("\nDesea responder ahora?");
            System.out.println("[0] Si [1] No");
            Scanner scan = new Scanner(System.in);
            int respuesta = scan.nextInt();
            if (respuesta == 0){
                System.out.println("\nIngrese: [0] Si [1] No [2] Valor numerico");
                respuesta = scan.nextInt();
                switch (respuesta) {
                    case 0 -> c.setRespuesta("Si");
                    case 1 -> c.setRespuesta("No");
                    case 2 -> {
                        System.out.println("\nIngrese valor:");
                        scan.nextLine();
                        String valor = scan.nextLine();
                        c.setRespuesta(valor);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "\nControl [" + id + "] " + nombre +
                "\nEnfermedades: " + listadoEnfermedadesID +
                "\nTareas [ID] " + listadoTareasID
                ;
    }
}
