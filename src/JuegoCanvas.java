import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JuegoCanvas extends JFrame implements ActionListener {
    private JButton botonTomar; private JButton botonNoTomar;
    private JLabel puntos; private JLabel ganador; private JLabel turno;
    private Random rand;
    private double jugador1; private double jugador2;
    private int terminado;
    private int carta; private double valor;
    private List<BarajaEspanola> cartasJugador1;
    private List<BarajaEspanola> cartasJugador2;
    private String[] palos = {"oros", "copas", "espadas", "bastos"};
    private JPanel cartas1;
    private JPanel cartas2;
    private boolean turnoJugador;

    public JuegoCanvas() {
        setTitle("Siete y Media");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        botonTomar=new JButton("Tomar otra carta");
        botonNoTomar=new JButton("No tomar otra carta");
        puntos=new JLabel(); ganador = new JLabel(); turno = new JLabel();

        JPanel botones=new JPanel();
        botones.add(botonTomar); botones.add(botonNoTomar);

        cartasJugador1=new ArrayList<>();
        cartasJugador2=new ArrayList<>();

        cartas1=new JPanel(); cartas2=new JPanel();

        cartas1.setLayout(new FlowLayout());
        cartas2.setLayout(new FlowLayout());

        add(puntos, BorderLayout.NORTH);
        add(cartas1, BorderLayout.WEST);
        add(cartas2, BorderLayout.EAST);
        add(botones, BorderLayout.CENTER);
        add(ganador, BorderLayout.SOUTH);
        add(turno, BorderLayout.PAGE_START);

        botonTomar.addActionListener(this);
        botonNoTomar.addActionListener(this);

        rand=new Random();
        jugador1=0; jugador2=0;
        terminado=0;
        turnoJugador=true;

        actualizarTurno();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(terminado==2){
            mostrarMensajeFinal();
            return;
        }

        if(e.getSource()==botonTomar){
            if(turnoJugador==true){
                tomarCarta(cartasJugador1, cartas1);
                actualizarInterfazJugador1();
            }else{
                terminado=0;
                tomarCarta(cartasJugador2, cartas2);
                actualizarInterfazJugador2();
            }
        }else if(e.getSource()==botonNoTomar){
            terminado++;
            if (turnoJugador==true) {
                turnoJugador=false;
                actualizarTurno();
            } else {
                turnoJugador = true;
                actualizarTurno();
            }
        }
    }
    private void tomarCarta(List<BarajaEspanola> cartasJugador, JPanel panelCartasJugador) {
        carta=rand.nextInt(10)+1;
        if(carta>7){
            valor=0.5;
        }else{
            valor=carta;
        }
        if(turnoJugador==true){
            jugador1+=valor;
            actualizarInterfazJugador1();
        } else {
            jugador2+=valor;
            actualizarInterfazJugador2();
        }
        agregarCarta(cartasJugador,panelCartasJugador,palos[rand.nextInt(palos.length)], carta);
        if(jugador1>=7.5||jugador2>=7.5||terminado==2){
            terminado=2;
            mostrarMensajeFinal();
        }
    }

    private void actualizarInterfazJugador1() {
        this.puntos.setText("Puntos Jugador 1: " + jugador1);
    }

    private void actualizarInterfazJugador2() {
        this.puntos.setText("Puntos Jugador 2: " + jugador2);
    }

    private void mostrarMensajeFinal() {
        if (jugador1 > 7.5 || jugador2 > 7.5) {
            if (jugador1 > 7.5) {
                ganador.setText("El jugador 2 ha ganado!");
            }
            if (jugador2 > 7.5) {
                ganador.setText("El jugador 1 ha ganado!");
            }
            if (jugador1 > 7.5 && jugador2 > 7.5) {
                ganador.setText("Es un empate!");
            }
        } else {
            if (jugador1 > jugador2) {
                ganador.setText("El jugador 1 ha ganado!");
            }
            if (jugador2 > jugador1) {
                ganador.setText("El jugador 2 ha ganado!");
            }
            if (jugador1 == jugador2) {
                ganador.setText("Es un empate!");
            }
        }
        botonTomar.setEnabled(false);
        botonNoTomar.setEnabled(false);
    }

    private void agregarCarta(List<BarajaEspanola> cartasJugador, JPanel panelCartasJugador, String palo, int valor) {
        BarajaEspanola nuevaCarta = new BarajaEspanola(palo, valor);
        cartasJugador.add(nuevaCarta);
        panelCartasJugador.add(nuevaCarta);
        panelCartasJugador.revalidate();
        panelCartasJugador.repaint();
    }

    private void actualizarTurno() {
        if (turnoJugador==true) {
            turno.setText("Turno del jugador 1");
            actualizarInterfazJugador1();
        } else {
            turno.setText("Turno del jugador 2");
            actualizarInterfazJugador2();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JuegoCanvas());
    }
}
