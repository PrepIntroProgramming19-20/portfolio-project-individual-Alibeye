import java.awt.*;
import javax.swing.*;
public class ImagePanel extends JPanel  //create the imageIcon used in cComponent
{
    // ImageIcons used during testing that were later scrapped
    ImageIcon Center = new ImageIcon("test.jpg");
    ImageIcon Center2 = new ImageIcon("Worm.jpg");
    
    //Overriding the paintComponent
    @Override
    public void paintComponent(Graphics g) {

        Image image = Center.getImage();
        g.drawImage(image, 3, 4, this);

    }
}
