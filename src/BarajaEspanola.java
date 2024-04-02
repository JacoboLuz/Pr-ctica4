import javax.swing.*;
import java.awt.*;

public class BarajaEspanola extends JPanel {
    private ImageIcon cartaImagen;

    public BarajaEspanola(String palo, int valor) {
        setPreferredSize(new Dimension(56, 319));
        String path = "src/imagenes/" + palo + "/" + valor + ".png";
        cartaImagen = new ImageIcon(path);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (cartaImagen != null) {
            cartaImagen.paintIcon(this, g, 0, 0);
        }
    }
}
