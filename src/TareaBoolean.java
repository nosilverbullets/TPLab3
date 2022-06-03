import java.util.Scanner;

public class TareaBoolean extends  TareaControl{

    public TareaBoolean(boolean respuestaUsuario) {
        super();
    }


    @Override
    String completarTarea() {
        Scanner scan = new Scanner(System.in);
        StringBuilder str1 = new StringBuilder(descripcion + " : ");
            System.out.println("OPCION 1 - SI");
            System.out.println("OPCION 2 - NO");
            short opcion;
            do {
                opcion = scan.nextShort();
                try {
                    switch (opcion) {
                        case 1:
                            str1.append("SI");
                            break;
                        case 2:
                            str1.append("NO");
                            break;
                        default:
                            System.out.println("NO INGRESO VALOR ADECUADO");
                    }
                } catch (NumberFormatException a) {
                    System.out.println("INGRESE NUMERO");
                }
            }while (opcion!=1&&opcion!=2);
        return str1.toString().toUpperCase();
    }
}
