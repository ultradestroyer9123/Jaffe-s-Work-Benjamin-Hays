import java.util.Random;

public class DieN
{
    private int value;
    private int sides;
    
    public DieN(int newValue) {
        this.sides = newValue;
    }
    public void roll() {
        this.value = new Random().nextInt(this.sides) + 1;
    }
    public int getValue() {
        return this.value;
    }
    public int rollAndGetValue() {
        roll();
        return getValue();
    }
}




