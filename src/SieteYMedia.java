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
            carta=rand.nextInt(10);

            do{
                jugador1=0; jugador2=0;
                System.out.println("Dime que hacer:");
                System.out.println("1. Jugar en la consola");
                System.out.println("2. Jugar en canvas");
                System.out.println("3. Salir\n");
                System.out.print(">>");
                flag2=leer.nextInt();
                System.out.println("---------");
                switch (flag2){
                    case 1:
                        System.out.println("---Jugar en consola---");
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
                                if (jugador1==jugador2){
                                    System.out.println("Es un empate!\n");
                                }
                            }
                        break;
                    case 2:
                        JuegoCanvas juego=new JuegoCanvas();
                        juego.main(args);
                        break;
                    case 3:
                        System.out.println("Muchas gracias por su tiempo");
                        break;
                    default:
                        System.out.println("Revise su respuesta.\n");
                }

            }while(flag2!=3);

        }
}
