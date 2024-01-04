import java.util.Random;

public class DrawMap {
    int sizeX;
    int sizeY;
    String grid = "";
    boolean horizontal;
    boolean placedFinishLine;
    // Constructor
    public DrawMap() {
        // Grid Scale
        sizeX = new Random().nextInt(50) + 20;
        sizeY = new Random().nextInt(50) + 20;
        // Finish Line
        // If equal to 1, the Finish line will be placed on a Horizontal Wall (Up,Down)
        // Else, the Finish line will be placed on a Vertical Wall (Left,Right
        horizontal = (new Random().nextInt(1) == 1);
        placedFinishLine = false;
        // Creating the Grid
        // Each Odd number will not be a wall.
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; x < sizeY; y++) {
                if (x == 1 || y == 1 || y == sizeY) {
                    grid += "#";
                } else if (x == sizeX) {
                    grid += "#\n";
                }
            }
        }
    }
    
    public String GetMap() {
        System.out.println(grid);
        return grid;
    }

}
