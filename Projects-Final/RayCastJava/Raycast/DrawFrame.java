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
    int pixel_size = 100;
    int pixel_amount_x = 11;
    int pixel_amount_y = 9;
    int currentMove = 0;
    JPanel[][] pixelList;
    public DrawFrame() {
        JFrame frame = new JFrame();
        DrawMap map = new DrawMap();
        pixelList = new JPanel[pixel_amount_x][pixel_amount_y];
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
                refresh(map.getMap(), map.getFacing(), pixelList);
            }
        });
        Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 20); 
        frame.setLayout(null);//using no layout managers  
        frame.setVisible(false);//making the frame not visible to build pixels  
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(pixel_size*pixel_amount_x,pixel_size*pixel_amount_y);
        frame.setResizable(false);
        int count = 0;
        for (int x = 0; x < pixel_amount_x; x++) {
            for (int y = 0; y < pixel_amount_y; y++) {
                JPanel pixel = new JPanel();
                if (y == pixel_amount_y/2 || y == (pixel_amount_y/2)+0.5) {
                    count++;
                    pixel.setBackground(Color.WHITE);
                } else {
                    pixel.setBackground(Color.BLACK);
                }
                pixel.setBounds(x*pixel_size,y*pixel_size,pixel_size,pixel_size);
                pixelList[x][y] = pixel;
                frame.add(pixel);
            }
        }
        
    
        frame.setVisible(true);//making the frame visible
    }

    
    public void updatePixel(int row, int column, boolean toggled, JPanel[][] pixelList_Parameter) {

        if (pixelList_Parameter != null && pixelList_Parameter[row][column] != null) {
            if (toggled) {
                pixelList_Parameter[row][column].setBackground(Color.WHITE);
                pixelList_Parameter[row][column].repaint();
            } else {
                pixelList_Parameter[row][column].setBackground(Color.BLACK);
                pixelList_Parameter[row][column].repaint();
            }
        }
    }

    
    public void updatePixelColumn(int column, int size, JPanel[][] pixelList_Parameter) {
        int dimension = pixelList[0].length;
        double midPoint;
        if (dimension % 2 == 0) {
            midPoint = (dimension/2)+1;
        } else {
            midPoint = (dimension/2) + 0.5;
        }
        
        int middle = (int) midPoint;
        
        for (int iterate = 0; iterate < dimension; iterate++) {
            updatePixel(column,iterate,false,pixelList_Parameter);
        }
        updatePixel(column,middle,true,pixelList_Parameter);
        for (int iterate = 0; iterate < size; iterate++) {
            updatePixel(column,middle-iterate,true,pixelList_Parameter);
            updatePixel(column,middle+iterate,true,pixelList_Parameter);
        }
    }
    
    public int distanceFromFacing(String map, String facing, int x, int y) {
        int distance = 0;
        boolean startCounting = false;
        if (facing == "North") {
            for (int iterate = y; iterate > 0; iterate--) {
                if ((map.split("\n")[iterate].charAt(x)+"").equals("#")) {
                    // System.out.println(distance);
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
                    //System.out.println(distance);
                    break;
                }
            }
        } else if (facing == "South") { // #-----*---# = distance of 4
            for (int iterate = y; iterate < map.split("\n").length; iterate++) {
                if ((map.split("\n")[iterate].charAt(x)+"").equals("#")) {
                    //System.out.println(distance);
                    break;
                } else {
                    distance += 1;
                }
            }
        } else if (facing == "West") {
            String line = map.split("\n")[y];
            for (int iterating = line.length()-1; iterating >= 0; iterating--) {
                String currentLetter = line.charAt(iterating) + "";
                if (startCounting) {
                    distance += 1;
                }
                if (currentLetter.equals("*")) {
                    startCounting = true;
                } else if (currentLetter.equals("#") && startCounting) {
                    //System.out.println(distance);
                    break;
                }
            }
        }
        return distance;
    }
    
    public int[] locateCharFromString(String map) {
        int x_local = 0;
        int y_local = 0;
    
        for (int character = 0; character < map.length(); character++) {
            if (String.valueOf(map.charAt(character)).equals("*")) {
                break;
            }
            if (String.valueOf(map.charAt(character)).equals("\n")) {
                y_local += 1;
                x_local = 0;
            } else {
                x_local += 1;
            }
        }
        int[] result = {x_local,y_local};
        return result;
    }
    
    public void refresh(String map, String facing, JPanel[][] pixelList_Parameter) {
        // Find what line the player is on
        double midPoint;
        int dimension = pixelList_Parameter.length;
        if (dimension % 2 == 0) {
            midPoint = (dimension/2)+1;
        } else {
            midPoint = (dimension/2) + 0.5;
        }
        
        int middle = (int) midPoint;
        
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

        int[] charPos = locateCharFromString(map);
        int distance_straight_ahead = distanceFromFacing(map,facing,charPos[0],charPos[1]);
        updatePixelColumn(middle,middle-distance_straight_ahead+1, pixelList_Parameter);
        if (facing == "North") {
            // YOU ARE LEAVING OFF HERE AS OF FEBURWARY 9 
            //
            //
            //
            //
            //
            //
            //
            //
            //
            //
            //
            /
        } else if (facing == "East") {
            
        } else if (facing == "South") {
        
        } else if (facing == "West") {
        
        }
    }
}
