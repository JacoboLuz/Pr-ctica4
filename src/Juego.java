import java.util.Scanner;
public class Juego {
    public static void main(String[] args) {
        System.out.println("Bienvenido a 'Siete y Media'.\n");
        System.out.println("                                                                      --Instrucciones--");
        System.out.println("El objetivo del juego es puntuar siete puntos y medio. " +
                "Se le repartirá una carta a cada jugador, el cual verá su puntaje y " +
                "decidirá si pedir otra carta o \nno. " +
                "Dependiendo de la suma, el ganador será decidido en base a qué tan cerca estuvo de acumular siete puntos y medio sin pasarse.\n");
        System.out.println("NOTA!!! Tome en cuenta el valor de cada una de las cartas:\n" +
                "-Cartas del 2 al 7: Tienen el mismo valor que su carta\n" +
                "-As: Tiene como valor 1\n" +
                "-Rey, Caballo y Sota: Tienen medio punto como su valor.\n");
        /****/
        System.out.println("Presione cualquier tecla para continuar.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("----------------------");
        SieteYMedia juego=new SieteYMedia();
        juego.main(args);
    }

}
