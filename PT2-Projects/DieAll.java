import java.util.Random;

public class DieAll
{
    private int value;
    private int sides;
    
    public DieAll() {
        // Combined all of the functions but I understand that this
        // would be the __init__() equivilant
        // this.roll()
        // System.out.println("Running the dice machine!");
        this.sides = 6;
    }
    
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
    
    public int rollDouble6() {
        return roll6() + roll6();
    }
    
    public int rollN() {
        main();
        return this.value;
    }
    
    public String getCurrentData() {
        return "Current selected sides: " + Integer.toString(this.sides) + ", " + "Last Roll: " + Integer.toString(this.value);
    }
}
