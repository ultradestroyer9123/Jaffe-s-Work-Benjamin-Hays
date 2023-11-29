import java.util.Random;

public class DieN
{
    private int value;
    private int sides;
    
    public void main() {
        this.value = new Random().nextInt(this.sides) + 1;
    }
    
    public void setSides(int newValue) {
        this.sides = newValue;
    }
    
    public int roll20() {
        int original = this.value;
        setSides(20);
        main();
        setSides(original);
        return this.value;
    }
    
    public int roll6() {
        int original = this.value;
        setSides(6);
        main();
        setSides(original);
        return this.value;
    }
    
    public int rollN() {
        main();
        return this.value;
    }
    
    public String getCurrentData() {
        return "Current selected sides: " + Integer.toString(this.sides) + ", " + "Last Roll: " + Integer.toString(this.value);
    }
}
