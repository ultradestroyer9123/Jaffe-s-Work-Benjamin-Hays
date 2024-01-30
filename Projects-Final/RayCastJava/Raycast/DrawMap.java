import java.util.Random;

public class DrawMap {
    private String MOVE_KEY = "W";
    
    private int sizeGrid;
    private int wallProbability = 1000;
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
        placedFinishLine = true; // should be false, set this to false in the future, true for now because of debugging
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
    
    public String locateChar() {
        int x_local = 0;
        int y_local = 0;
    
        for (int character = 0; character < getMap().length(); character++) {
            if (String.valueOf(getMap().charAt(character)).equals("*")) {
                break;
            }
            if (String.valueOf(getMap().charAt(character)).equals("\n")) {
                y_local += 1;
                x_local = 0;
            } else {
                x_local += 1;
            }
        }
    
        return Integer.toString(x_local) + "," + Integer.toString(y_local);
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
    
    public void move(boolean reverse) {
        int moveAmount;
        if (reverse) {
            moveAmount = -1;
        } else {
            moveAmount = 1;
        }
        String charPosString = locateChar();
        boolean blockage = false;
        int[] charPos = {Integer.parseInt(charPosString.split(",")[0]), Integer.parseInt(charPosString.split(",")[1])};
        System.out.println(charPosString);
        String direction = getFacing();
        
        if (direction.equals("North")) {
            if (indexGrid(this.grid, charPos[0], charPos[1] - moveAmount).equals("#")) {
                blockage = true;
            }
        } else if (direction.equals("South")) {
            if (indexGrid(this.grid, charPos[0], charPos[1] + moveAmount).equals("#")) {
                blockage = true;
            }
        } else if (direction.equals("East")) {
            if (indexGrid(this.grid, charPos[0] + moveAmount, charPos[1]).equals("#")) {
                blockage = true;
            }
        } else if (direction.equals("West")) {
            if (indexGrid(this.grid, charPos[0] - moveAmount, charPos[1]).equals("#")) {
                blockage = true;
            }
        }
        if (!blockage) {
            this.grid = this.grid.replace("*", " ");
            
            if (direction.equals("North")) {
                this.grid = changeGridAtIndex(this.grid, charPos[0], charPos[1] - moveAmount, "*");
            } else if (direction.equals("South")) {
                this.grid = changeGridAtIndex(this.grid, charPos[0], charPos[1] + moveAmount, "*");
            } else if (direction.equals("East")) {
                this.grid = changeGridAtIndex(this.grid, charPos[0] + moveAmount, charPos[1], "*");
            } else if (direction.equals("West")) {
                this.grid = changeGridAtIndex(this.grid, charPos[0] - moveAmount, charPos[1], "*");
            }
        }
    }

}
