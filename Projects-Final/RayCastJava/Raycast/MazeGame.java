public class MazeGame {
    private DrawMap map;
    private DrawFrame frame;
    public MazeGame() {
        newMap();
        this.frame = new DrawFrame(this.map.getMap(), "north");
    }
    
    public void refresh() {
        //this.frame.printFrame();
    }

    public void newMap() {
        this.map = new DrawMap();
        refresh();
    }
}
