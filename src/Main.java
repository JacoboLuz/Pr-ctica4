import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        Random rand=new Random();
        int flag=0;
        int flag2=0;
        double carta;
        double jugador1=0;
        double jugador2=0;
        Scanner leer=new Scanner(System.in);
        int jugarOtravez=0;
        carta=rand.nextInt(10);
        do{
            System.out.println("Dime que hacer\n1 jugar\n2 salir\n");
            flag=leer.nextInt();
            switch (flag){
                case 1:
                    do {
                        carta = rand.nextInt(10) + 1;
                        if (carta > 7) {
                            carta = 0.5;
                        }
                        jugador1 += carta;
                        carta = rand.nextInt(10) + 1;
                        if (carta > 7) {
                            carta = 0.5;
                        }
                        jugador2 += carta;
                        System.out.println("Jugador 1: " + jugador1 + "\nJugador 2" + jugador2 + "\n");
                        if(jugador1>7.5 || jugador2>7.5) {
                            if (jugador1>7.5){
                                System.out.println("Gano jugador 2\n");
                            }
                            if (jugador2>7.5){
                                System.out.println("Gano jugador 1\n");
                            }
                            if (jugador1>7.5 && jugador2>7.5){
                                System.out.println("empate\n");
                            }
                            flag2=1;
                        }else{
                            System.out.println("¿Quieres otra carta?\n1 si\n2 no\n");
                            jugarOtravez = leer.nextInt();
                            if(jugarOtravez==1){
                                flag2=1;
                                if(jugador1>jugador2){
                                    System.out.println("Gano jugador 1\n");
                                }
                                if(jugador1<jugador2){
                                    System.out.println("Gano jugador 2\n");
                                }
                                if(jugador1==jugador2){
                                    System.out.println("empate\n");
                                }
                            }
                        }
                    }while(flag2==1);
                    break;
                case 2:
                    System.out.println("Adios");
                    flag=2;
                    break;
                default:
                    System.out.println("Eso no se puede\n");
            }

        }while(flag==2);

    }
}
