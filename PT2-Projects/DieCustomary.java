import java.util.Random;

public class DieCustomary
{
    private int value;
    private int sides;
    
    public int main() {
        this.value = new Random().nextInt(this.sides) + 1;
        return this.value;
    }
    
    public void setSides(int newValue) {
        this.sides = newValue;
    }
    
    public void roll() {
        DieCustomary number = new DieCustomary();
        
    }
}
