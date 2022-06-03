import java.util.Scanner;

public class TareaNumerica extends TareaControl{



    public TareaNumerica(float respuestaUsuario) {
        super();
    }

    @Override
    String completarTarea() {
        Scanner scan = new Scanner(System.in);
        StringBuilder str = new StringBuilder(descripcion +" : ");
        while (true) {
            try {
       float user = scan.nextFloat();
       str.append(user);
                break;
            } catch (NumberFormatException a) {
                System.out.println("Ingrese valor numerico");
            }
        }
        return str.toString().toUpperCase();
    }
}
