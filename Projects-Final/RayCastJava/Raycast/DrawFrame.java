import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class DrawFrame {
    public DrawFrame(String grid, String facing) {
        JFrame myJFrame = new JFrame();
    
        myJFrame.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_W) {
              System.out.println("Forward");
            }
            else if (keyCode == KeyEvent.VK_A) {
              System.out.println("Left");
            }
            else if (keyCode == KeyEvent.VK_D) {
            System.out.println("Right");
            }
          }
        });
    
        myJFrame.setVisible(true);
    }
}
