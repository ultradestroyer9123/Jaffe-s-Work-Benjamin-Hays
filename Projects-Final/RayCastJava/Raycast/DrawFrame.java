public class DrawFrame {
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
    
    // Constructor
    public DrawFrame(String grid, String facing) {
        
    }
}
