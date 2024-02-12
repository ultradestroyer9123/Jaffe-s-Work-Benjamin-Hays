import java.util.Random;

public class DrawMap {
    private String MOVE_KEY = "W";
    
    private int sizeGrid;
    private int plrSpawnX = 6;
    private int plrSpawnY = 6;
    private String grid = "";
    private boolean horizontal;
    private boolean placedFinishLine;
    private boolean placedPlayer;
    private int dimension;
    // 0 = West
    // 1 = North
    // 2 = East
    // 3 = South
    private String[] facingWays = {"West", "North", "East", "South"};
    private int facing = 2;
    // Constructor
    public DrawMap(int gridSize, int wallSpawnProbability) {
        // Grid Scale
        sizeGrid = gridSize;
        if (sizeGrid % 2 != 0) {
            sizeGrid -= 1;
        }
        this.dimension = sizeGrid;
        int offset_x = new Random().nextInt(sizeGrid/2);
        int offset_y = new Random().nextInt(sizeGrid/2);
        // Finish Line
        // If equal to 1, the Finish line will be placed on a Horizontal Wall (Up,Down)
        // Updated to handle both cases
        placedFinishLine = false; // should be false, set this to false in the future, true for now because of debugging
        placedPlayer = false;
        int finish_x = ((int) new Random().nextInt(50)) + 1;
        int iterate = 0;
        // Creating the Grid
        // Each Odd number will not be a wall.
        for (int x = 0; x < sizeGrid; x++) {
            for (int y = 0; y < sizeGrid; y++) {
                iterate += 1;
                if (iterate == finish_x && !placedFinishLine) {
                    this.grid += "F";
                    placedFinishLine = true;
                } else if (!placedPlayer && x == plrSpawnX && y == plrSpawnY) {
                    placedPlayer = true;
                    this.grid += "*";
                } else if (x == 0 || x == sizeGrid - 1 || y == 0 || y == sizeGrid - 1) {
                    this.grid += "#";
                } else if (new Random().nextInt(wallSpawnProbability) == 1) {
                    this.grid += "#";
                } else {
                    this.grid += " ";
                }
            }
            this.grid += "\n";
        }
    }
    
    public int getDimension() {
        return this.dimension;
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
