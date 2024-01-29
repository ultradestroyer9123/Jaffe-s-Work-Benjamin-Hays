public class Main {
    public String changeGridAtIndex(String grid, int x, int y, String changeTo) {
        String[] output = grid.split("\n");
        if (y >= 0 && y < output.length && x >= 0 && x < output[y].length()) {
            output[y] = output[y].substring(0, x) + changeTo + output[y].substring(x + 1);
        } else {
            System.out.println("Error: Coordinates are out of bounds.");
        }
    
        return String.join("\n", output);
    }
    public void main(String[] args) {
        System.out.println(changeGridAtIndex("####\n####\n####\n####", 1,1,"-"));
    }
}