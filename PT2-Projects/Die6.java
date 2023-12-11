import java.util.Random;

public class Die6
{
    private int value;
    
    public void roll() {
        this.value = new Random().nextInt(6) + 1;
    }
    public int getValue() {
        return this.value;
    }
    public int rollAndGetValue() {
        roll();
        return getValue();
    }
}




