import java.awt.*;
import javax.swing.*;
public class ImagePanel extends JPanel  //create the imageIcon used in cComponent
{
    ImageIcon Center = new ImageIcon("test.jpg");
    ImageIcon Center2 = new ImageIcon("Worm.jpg");
    @Override
    public void paintComponent(Graphics g) {

        Image image = Center.getImage();
        g.drawImage(image, 3, 4, this);

    }
}
