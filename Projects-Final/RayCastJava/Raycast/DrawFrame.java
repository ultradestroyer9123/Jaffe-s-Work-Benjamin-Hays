import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.border.Border;
import java.util.Random;
import static java.lang.System.out;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.net.CookieHandler;
public class DrawFrame {
    int pixel_size = 10;
    int pixel_amount_x = 100;
    int pixel_amount_y = 80;
    int currentMove = 0;
    public DrawFrame() {
        JFrame frame = new JFrame();
        DrawMap map = new DrawMap();
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                currentMove += 1;
                if (keyCode == KeyEvent.VK_W) {
                    map.move(false);
                }
                else if (keyCode == KeyEvent.VK_A) {
                    map.faceDirection("left");
                }
                else if (keyCode == KeyEvent.VK_D) {
                    map.faceDirection("right");
                } else if (keyCode == KeyEvent.VK_S) {
                    map.move(true);
                }
                map.printMap();
                System.out.println(map.getFacing());
                System.out.println("Ran: "+Integer.toString(currentMove));
                refresh(map.getMap(), map.getFacing());
            }
        });
        Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 20); 
        frame.setLayout(null);//using no layout managers  
        frame.setVisible(false);//making the frame not visible to build pixels  
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(pixel_size*pixel_amount_x,pixel_size*pixel_amount_y);
        frame.setResizable(false);
        for (int x = 0; x < pixel_amount_x; x++) {
            for (int y = 0; y < pixel_amount_y; y++) {
                JPanel pixel = new JPanel();
                if (y == pixel_amount_y/2 || y == (pixel_amount_y/2)+0.5) {
                    pixel.setBackground(Color.white);
                } else {
                    pixel.setBackground(Color.black);
                }
                pixel.setBounds(x*pixel_size,y*pixel_size,pixel_size,pixel_size);
                frame.add(pixel);
            }
        }
        
        
        
        frame.setVisible(true);//making the frame visible
    }
    
    public int distanceFromFacing(String map, String facing, int x, int y) {
        int distance = 0;
        boolean startCounting = false;
        if (facing == "North") {
            for (int iterate = y; iterate > 0; iterate--) {
            	if ((map.split("\n")[iterate].charAt(x)+"").equals("#")) {
                    break;
                } else {
                    distance += 1;
                }
            }
        } else if (facing == "East") { // #-----*---# = distance of 4
            String line = map.split("\n")[y];
            for (int iterating = 0; iterating < line.length(); iterating++) {
                String currentLetter = line.charAt(iterating) + "";
                if (startCounting) {
                    distance += 1;
                }
                if (currentLetter.equals("*")) {
                    startCounting = true;
                } else if (currentLetter.equals("#") && startCounting) {
                    System.out.println(distance);
                }
            }
        } else if (facing == "South") { // #-----*---# = distance of 4
        
        } else if (facing == "West") {
            String line = map.split("\n")[y];
            for (int iterating = line.length()-1; iterating >= 0; iterating--) {
                System.out.println(iterating);
                String currentLetter = line.charAt(iterating) + "";
                if (startCounting) {
                    distance += 1;
                }
                if (currentLetter.equals("*")) {
                    startCounting = true;
                } else if (currentLetter.equals("#") && startCounting) {
                    System.out.println(distance);
                }
            }
        }
        return distance;
    }
    
    public void refresh(String map, String facing) {
        // Find what line the player is on
        boolean doBreak = false;
        int plr_pos_x;
        int plr_pos_y;
        for (int line = 0; line < map.split("\n").length; line++) {
            if (doBreak) {
                break;
            }
            for (int character = 0; character < map.split("\n")[line].length(); character++) {
                if ((map.split("\n")[line].charAt(character) + "").equals("*")) {
                    plr_pos_x = character;
                    plr_pos_y = line;
                    doBreak = true;
                    break;
                }
            }
        }
        
        int distance_straight_ahead;
        
        if (facing == "North") {
            
        } else if (facing == "East") {
            
        } else if (facing == "South") {
        
        } else if (facing == "West") {
        
        }
    }
}
