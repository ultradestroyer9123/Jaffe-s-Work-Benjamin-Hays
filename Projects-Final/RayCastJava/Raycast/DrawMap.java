import java.util.Random;

public class DrawMap {
    int sizeGrid;
    int wallProbability = 15;
    int plrSpawnX = 6;
    int plrSpawnY = 6;
    int minimumGridSize = 20;
    private String grid = "";
    boolean horizontal;
    boolean placedFinishLine;
    boolean placedPlayer;
    // Constructor
    public DrawMap() {
        System.out.println("Ran!");
        // Grid Scale
        sizeGrid = new Random().nextInt(5) + minimumGridSize;
        if (sizeGrid % 2 != 0) {
            sizeGrid -= 1;
        }
        // Finish Line
        // If equal to 1, the Finish line will be placed on a Horizontal Wall (Up,Down)
        // Else, the Finish line will be placed on a Vertical Wall (Left,Right)
        horizontal = new Random().nextInt(2) == 1; // Updated to handle both cases
        placedFinishLine = false;
        placedPlayer = false;
        // Creating the Grid
        // Each Odd number will not be a wall.
        for (int x = 0; x < sizeGrid; x++) {
            for (int y = 0; y < sizeGrid; y++) {
                if (!placedPlayer && x == plrSpawnX && y == plrSpawnY) {
                    placedPlayer = true;
                    this.grid += "*";
                } else if (x == 0 || x == sizeGrid - 1 || y == 0 || y == sizeGrid - 1) {
                    this.grid += "#";
                } else if (!placedFinishLine && ((horizontal && x == sizeGrid / 2) || (!horizontal && y == sizeGrid / 2))) {
                    this.grid += "F"; // 'F' represents the finish line
                    placedFinishLine = true;
                } else if (new Random().nextInt(wallProbability) == 1) {
                    this.grid += "#";
                } else {
                    this.grid += " ";
                }
            }
            this.grid += "\n";
        }
        System.out.println(this.grid);
    }

    public static void main(String[] args) {
        new DrawMap();
    }
}
