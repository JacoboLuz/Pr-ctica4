import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BarajaEspanola extends JPanel{
    private BufferedImage[] imagenesNaipes;
    private static int ancho=208;
    private static int alto=319;

    public BarajaEspanola(){
        this.cargarImagenes();
    }
/**/
    public static int getAncho() {
        return ancho;
    }
    public static void setAncho(int ancho) {
        BarajaEspanola.ancho = ancho;
    }
/**/
    public static int getAlto() {
        return alto;
    }
    public static void setAlto(int alto) {
        BarajaEspanola.alto = alto;
    }
/**/
    private void cargarImagenes(){
        imagenesNaipes=new BufferedImage[48];
        String[] palos={"oros","copas","espadas","bastos"};
        for(int i=0;i<4;i++){
            for (int j=0;j<12;j++){
                String nombreImagen="src/imagenes/"+palos[i]+"/"+(j + 1)+".png";
                try{
                    BufferedImage imagen=ImageIO.read(new File(nombreImagen));
                    imagenesNaipes[i*12+j]=imagen;
                }catch(IOException error){
                    error.printStackTrace();
                }
            }
        }
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int x=10;
        int y=10;
        BufferedImage[] var4 = this.imagenesNaipes;
        int var5 = var4.length;
        for(int var6 = 0; var6 < var5; ++var6){
            BufferedImage imagen = var4[var6];
            g.drawImage(imagen,x,y,ancho,alto,this);
            x +=ancho+10;
            if(x>getWidth()-ancho){
                x=10;
                y+=alto+10;
            }
        }
    }

    public Dimension getPreferredSize(){
        int an=(ancho+10)*12/2;
        int al=(alto+10)*4/2;
        return new Dimension(an,al);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{
            JFrame frame=new JFrame("Baraja Española");
            frame.setDefaultCloseOperation(3);
            BarajaEspanola panel=new BarajaEspanola();
            frame.add(panel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
