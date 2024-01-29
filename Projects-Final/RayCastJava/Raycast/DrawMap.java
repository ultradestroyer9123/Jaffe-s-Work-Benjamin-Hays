import java.util.Random;

public class DrawMap {
    private String MOVE_KEY = "W";
    
    private int sizeGrid;
    private int wallProbability = 15;
    private int plrSpawnX = 6;
    private int plrSpawnY = 6;
    private int minimumGridSize = 20;
    private String grid = "";
    private boolean horizontal;
    private boolean placedFinishLine;
    private boolean placedPlayer;
    // 0 = West
    // 1 = North
    // 2 = East
    // 3 = South
    private String[] facingWays = {"West", "North", "East", "South"};
    private int facing = 2;
    // Constructor
    public DrawMap() {
        // Grid Scale
        sizeGrid = new Random().nextInt(5) + minimumGridSize;
        if (sizeGrid % 2 != 0) {
            sizeGrid -= 1;
        }
        int offset_x = new Random().nextInt(sizeGrid/2);
        int offset_y = new Random().nextInt(sizeGrid/2);
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
                } else if (!placedFinishLine && ((horizontal && x == (sizeGrid / 2) + offset_x)) || (!horizontal && y == (sizeGrid / 2) + offset_y)) {
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
    }

    public String getMap() {
        return this.grid;
    }
    
    public int[] locateChar() {
        int x_local = 0;
        int y_local = 0;
        for (int character = 0; character < getMap().length(); character++) {
            if (getMap().charAt(character) + "" == "*") {
                break;
            }
            if (getMap().charAt(character) + "" == "\n") {
                y_local += 1;
                x_local = 0;
            } else {
                x_local += 1;
            }
        }
        int[] result = {x_local, y_local};
        return result;
    }
    
    public void printMap() {
        System.out.println(this.grid);
    }
    
    public void faceDirection(String direction) {
        if (direction == "left") {
            this.facing -= 1;
        } else {
            this.facing += 1;
        }
        
        if (this.facing == -1) {
            this.facing = 3;
        } else if (facing == 4) {
            this.facing = 0;
        }
    }
    
    public String getFacing() {
        return facingWays[this.facing];
    }
    
    
    // x and y start at 0
    public String indexGrid(String grid, int x,int y) { 
        return grid.split("\n")[y].substring(x,x+1);
    }
    
    public String changeGridAtIndex(String grid, int x, int y, String changeTo) {
        String[] output = grid.split("\n");
        if (y >= 0 && y < output.length && x >= 0 && x < output[y].length()) {
            output[y] = output[y].substring(0, x) + changeTo + output[y].substring(x + 1);
        } else {
            System.out.println("Error: Coordinates are out of bounds.");
        }
    
        return String.join("\n", output);
    }
    
    public void move() {
        System.out.println(Integer.toString(locateChar()[0])+Integer.toString(locateChar()[1]));
        String direction = getFacing();
        int[] charPos = locateChar();
        this.grid = changeGridAtIndex(this.grid,charPos[0],charPos[1]," ");
        if (direction == "North") {
            this.grid = changeGridAtIndex(this.grid,charPos[0],charPos[1]-1,"*");
        } else if (direction == "South") {
            this.grid = changeGridAtIndex(this.grid,charPos[0],charPos[1]+1,"*");
        } else if (direction == "East") {
            this.grid = changeGridAtIndex(this.grid,charPos[0]+1,charPos[1],"*");
        } else if (direction == "West") {
            this.grid = changeGridAtIndex(this.grid,charPos[0]+1,charPos[1],"*");
        }
    }
}
