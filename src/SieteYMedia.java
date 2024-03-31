import java.util.Random;
import java.util.Scanner;

public class SieteYMedia {
        public static void main(String[] args) {
            System.out.println("--MENÚ--");
            Random rand=new Random();
            int flag=0;
            int flag2=0;
            double carta;
            double jugador1=0;
            double jugador2=0;
            int terminado=0;
            Scanner leer=new Scanner(System.in);
            int jugarOtravez=0;
            carta=rand.nextInt(10);

            do{
                System.out.println("Dime que hacer:");
                System.out.println("1. Jugar");
                System.out.println("2. Salir\n");
                System.out.print(">>");
                flag=leer.nextInt();
                System.out.println("---------");
                switch (flag){
                    case 1:
                        System.out.println("---Jugar---");
                        do {
                            terminado=0;
                            System.out.println("........");
                            //jugador 1
                            System.out.println(">Jugador 1:");
                            do {
                                carta = rand.nextInt(10) + 1;
                                if (carta > 7) {
                                    carta = 0.5;
                                }
                                jugador1 += carta;
                                System.out.println("Puntos del jugador 1: " + jugador1);
                                if (jugador1 < 7.5) {
                                    System.out.println("¿Desea tomar otra carta? (1: Sí, 2: No)\n");
                                    System.out.print(">>");
                                    flag = leer.nextInt();
                                    if (flag == 2) {
                                        terminado++;
                                    }
                                }else if (jugador1>=7.5){
                                    flag=2;
                                }
                            } while (flag == 1);
                            if (jugador1 > 7.5) {
                                System.out.println("El jugador 1 ha excedido la cantidad de puntos máxima.");
                                terminado=2;
                            } else if (jugador1 == 7.5) {
                                System.out.println("El jugador 1 ha conseguido 7.5 puntos.");
                                terminado=2;
                            }
                            //jugador 2
                            if(terminado!=2) {
                                System.out.println(">Jugador 2:");
                                do {
                                    carta = rand.nextInt(10) + 1;
                                    if (carta > 7) {
                                        carta = 0.5;
                                    }
                                    jugador2 += carta;
                                    System.out.println("Puntos del jugador 2: " + jugador2);
                                    if (jugador2 < 7.5) {
                                        System.out.println("¿Desea tomar otra carta? (1: Sí, 2: No)\n");
                                        System.out.print(">>");
                                        flag = leer.nextInt();
                                        if (flag == 2) {
                                            terminado++;
                                        }else if(flag==1){
                                            terminado=0;
                                        }
                                    }else if (jugador2>=7.5){
                                        flag=2;
                                    }
                                } while (flag == 1);
                                if (jugador2 > 7.5) {
                                    System.out.println("El jugador 2 ha excedido la cantidad de puntos máxima.");
                                    terminado=2;
                                } else if (jugador2 == 7.5) {
                                    System.out.println("El jugador 2 ha conseguido 7.5 puntos.");
                                    terminado=2;
                                }
                            }
                        }while(terminado!=2);
                            if (jugador1 > 7.5 || jugador2 > 7.5) {
                                if (jugador1 > 7.5) {
                                    System.out.println("El jugador 2 ha ganado!\n");
                                }
                                if (jugador2 > 7.5) {
                                    System.out.println("El jugador 1 ha ganado!\n");
                                }
                                if (jugador1 > 7.5 && jugador2 > 7.5) {
                                    System.out.println("Es un empate!\n");
                                }
                            }else{
                                if (jugador1 > jugador2) {
                                    System.out.println("El jugador 1 ha ganado!\n");
                                }
                                if (jugador2 > jugador1) {
                                    System.out.println("El jugador 2 ha ganado!\n");
                                }
                            }
                        break;
                    case 2:
                        System.out.println("Muchas gracias por su tiempo");
                        flag=2;
                        break;
                    default:
                        System.out.println("Revise su respuesta.\n");
                }

            }while(flag!=2);

        }
}
